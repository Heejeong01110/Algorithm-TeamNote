package com.example.programmers;

import java.util.Arrays;

//징검다리 건너기
public class s64062 {

  public static int solution(int[] stones, int k) {
    int minSum = 200_000_000;

    for (int i = 0; i <= stones.length - k; i++) {
      int max = Arrays.stream(stones, i, i + k).max().getAsInt();
      minSum = Math.min(minSum, max);
    }

    return minSum;
  }
}
