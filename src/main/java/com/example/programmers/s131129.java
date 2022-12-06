package com.example.programmers;

import java.util.HashMap;

public class s131129 {

  public static int[] solution(int target) {
    int[] answer = {};

    HashMap<Integer, int[]> map = new HashMap<>();
    //key : 점수 //value : [0]라운드 수 [1]싱글+불 횟수
    for (int i = 0; i <= target; i++) {
      map.put(i, new int[2]);
    }

    for (int i = 1; i <= 20; i++) {
      //더블, 트리플
      if (i * 2 <= target) {
        map.get(i * 2)[0] = 1;
        map.get(i * 2)[1] = 0;
      }
      if (i * 3 <= target) {
        map.get(i * 3)[0] = 1;
        map.get(i * 3)[1] = 0;
      }
      //싱글
      if (i <= target) {
        map.get(i)[0] = 1;
        map.get(i)[1] = 1;
      }
    }
    //50점
    if (50 <= target) {
      map.get(50)[0] = 1;
      map.get(50)[1] = 1;
    }

    //key : 점수 //value : [0]라운드 수 [1]싱글+불 횟수
    for (int i = 21; i <= target; i++) { //i : 이번에 만들 점수

      if (map.get(i)[0] == 0) { //아직 점수가 한번도 기록되지 않은 경우
        map.get(i)[0] = map.get(i - 1)[0] + 1;
        map.get(i)[1] = map.get(i - 1)[1] + 1;
      }

      for (int j = 1; j <= 20; j++) {
        //싱글
        if (isNewScore(map, i, j, 1)) {
          map.get(i)[0] = map.get(i - j)[0] + 1;
          map.get(i)[1] = map.get(i - j)[1] + 1;
        }

        //더블
        if (isNewScore(map, i, j * 2, 0)) {
          map.get(i)[0] = map.get(i - j * 2)[0] + 1;
          map.get(i)[1] = map.get(i - j * 2)[1];
        }
        //트리플
        if (isNewScore(map, i, j * 3, 0)) {
          map.get(i)[0] = map.get(i - j * 3)[0] + 1;
          map.get(i)[1] = map.get(i - j * 3)[1];
        }
      }
      //볼
      if (isNewScore(map, i, 50, 1)) {
        map.get(i)[0] = map.get(i - 50)[0] + 1;
        map.get(i)[1] = map.get(i - 50)[1] + 1;
      }
    }

    answer = map.get(target);
    return answer;
  }


  //key : 점수 //value : [0]라운드 수 [1]싱글+불 횟수
  private static boolean isNewScore(HashMap<Integer, int[]> map, int target, int nowScore,
      int isBall) {
    //1. 맞추기 전 점수가 존재하는가
    if (target - nowScore <= 0) {
      return false;
    }

    //2. target 점수의 최저 라운드수보다 적게 수행하는가?
    if (map.get(target)[0] > map.get(target - nowScore)[0] + 1) {
      return true;
    }

    //3. 같다면 싱글 + 볼의 수가 더 많은가
    if (map.get(target)[0] == map.get(target - nowScore)[0] + 1) {
      return map.get(target)[1] < map.get(target - nowScore)[1] + isBall;
    }
    return false;
  }
}
