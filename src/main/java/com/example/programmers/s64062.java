package com.example.programmers;

//징검다리 건너기
public class s64062 {

  public static int solution(int[] stones, int k) {
    int minSum = 600_000_000;
    int idx = 0;
    int[] ary = new int[stones.length];

    ary[0] = stones[0];
    for (int i = 1; i < stones.length; i++) {
      ary[i] = ary[i - 1] + stones[i];
    }

    for (int i = 0; i <= stones.length - k; i++) {
      int sum = ary[i + k - 1] - ary[i];
      if (i == 0) {
        sum = ary[i + k - 1];
      }
      if (minSum > sum) {
        minSum = sum;
        idx = i;
      }
    }

    int result = 0;
    for (int i = 0; i < k; i++) {
      if (result < stones[idx + i]) {
        result = stones[idx + i];
      }
    }

    return result;
  }
}
