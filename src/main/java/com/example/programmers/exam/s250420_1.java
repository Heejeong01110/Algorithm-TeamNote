package com.example.programmers.exam;

import java.util.ArrayList;
import java.util.HashSet;

public class s250420_1 {

  static int n, answer;
  static ArrayList<int[]>[] map;

  public static int solution(int[][] problems) {
    n = problems.length;
    map = new ArrayList[n];

    for (int i = 0; i < n; i++) {//n번째 문제의 점수 케이스 만들어서 map[i]에 넣기
      map[i] = new ArrayList<>();
      int total = problems[i][0];
      int testCase = problems[i][1];
      if (testCase == 1) {//testCase가 1인 경우
        map[i].add(new int[]{0, total});
      } else {//testCase가 2인 경우
        int a = 1;
        int b = total - 1;
        while (a <= b) {
          int[] addList;
          if (a != b) {
            addList = new int[]{0, a, b, total};
          } else {
            addList = new int[]{0, a, total};
          }
          map[i].add(addList);
          a++;
          b--;
        }
      }
    }

    //문제 조합 만들기
    answer = 0;
    HashSet<Integer> ans = new HashSet<>();
    ans.add(0);
    bfs(0, ans);
    return answer;
  }

  private static void bfs(int idx, HashSet<Integer> ans) {
    if (idx == n) {
      for(Integer a : ans){

      }
      answer = Math.max(answer, ans.size());
      return;
    }

    for (int i = 0; i < map[idx].size(); i++) {
      ArrayList<Integer> addList = new ArrayList<>();
      for (int score : map[idx].get(i)) {
        for (Integer val : ans) {
          addList.add(val + score);
        }
      }
      HashSet<Integer> clone = (HashSet<Integer>) ans.clone();
      clone.addAll(addList);
      bfs(idx + 1, clone);
    }
  }
}
