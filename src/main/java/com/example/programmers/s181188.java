package com.example.programmers;

import java.util.Arrays;

public class s181188 {

  public int solution(int[][] targets) {
    int answer = 0;
    Arrays.sort(targets, (o1, o2) -> {
      if (o1[0] == o2[0]) {
        return o1[1] - o2[1];
      }
      return o1[0] - o2[0];
    });

    int start = targets[0][0];
    int end = targets[0][1];
    int count = 1;
    for (int i = 1; i < targets.length; i++) {
      if (end <= targets[i][0]) {//하나도 겹치지 않을 때
        count++;
        start = targets[i][0];
        end = targets[i][1];
      } else if (end < targets[i][1]) { //엇갈려 겹칠 때
        start = Math.max(start, targets[i][0]);
      } else { //완전히 속할 때
        start = Math.max(start, targets[i][0]);
        end = Math.min(end, targets[i][1]);
      }

    }
    return count;
  }
}
