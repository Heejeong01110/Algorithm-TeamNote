package com.example.programmers;

import java.util.ArrayList;

public class s42891 {

  private static int N;

  public static int solution(int[] food_times, long k) {
    int answer = 0;
    N = food_times.length;
    ArrayList<Node> nodes = new ArrayList<>();
    ArrayList<Integer> exist = new ArrayList<>();

    for (int i = 1; i <= N; i++) {
      nodes.add(new Node(i, food_times[i - 1]));
      exist.add(i);
    }

    nodes.sort((o1, o2) -> o1.time == o2.time ? o1.idx - o2.idx : o1.time - o2.time);

    int count = 0; //몇바퀴 돌았는지 기록
    int idx = 0; //이번 인덱스까지 체크함
    long sec = 0; //초 기록

    for (int i = 0; i < nodes.size(); i++) {
      Node now = nodes.get(i); //이번 까지 먹어야 함(0이 될 때 까지)

      long plus = 0;
      //1. 첫번째 바퀴에서 now.idx 까지 이동
      if (idx < now.idx) {
        plus += exist.indexOf(now.idx) - exist.indexOf(idx + 1) + 1;
      } else if (idx > now.idx) {
        plus += (exist.size() - exist.indexOf(idx)) + exist.indexOf(now.idx);
      }
      //2. 전체를 도는 활동을 now.time - 1 만큼 돌기
      plus += (long) exist.size() * (now.time - 1 - count);

      //이번 차례에 k를 넘을 때 -> 어느 부분에서 끝나는지 체크해야 함.
      if (sec + plus == k) {//깔끔하게 끝날 경우 -> 가장 가까운 다음 인덱스
        if (i < nodes.size() - 1) {
          int lastEat = nodes.get(i).idx;
          int index = exist.indexOf(lastEat) + 1 >= exist.size() ? 0 : exist.indexOf(lastEat) + 1;
          return exist.get(index);
        }
        break;
      } else if (sec + plus > k) {//하나씩 비교해야 함.
        //1. N까지 가는 중에 끝나는지 확인
        int start = exist.indexOf(now.idx);
        for (int j = 0; j < exist.size(); j++) {
          int nowIndex = (j + start) + ((j + start) >= exist.size() ? -exist.size() : 0);
          plus += 1;
          if (sec + plus > k) {
            return exist.get(nowIndex);
          }
        }
        break;
      }
      //3. 이번 인덱스는 더이상 방문하지 않으므로 삭제
      exist.remove((Integer) now.idx);

      count = now.time - 1;
      idx = now.idx;
      sec += plus;
    }

    return -1;
  }


  private static class Node {

    int idx;
    int time;

    public Node(int idx, int time) {
      this.idx = idx;
      this.time = time;
    }
  }
}
