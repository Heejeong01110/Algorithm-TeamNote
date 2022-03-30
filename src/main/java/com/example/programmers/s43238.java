package com.example.programmers;

import java.util.Arrays;

public class s43238 {

  public static long solution(int n, int[] times) {
    Arrays.sort(times);
    long answer = 0;

    long start = 0;
    long end = (long) times[times.length - 1] * n; //6
    long mid = 0;

    while (start <= end) {
      mid = (start + end) / 2; //30

      long sum = 0;
      for (long time : times) {
        sum += mid / time; //mid 시간까지 사용한 사람 수
      }

      if (sum >= n) {
        answer = mid;
        end = mid - 1;
      } else {
        start = mid + 1;
      }

    }

    return answer;
  }

}
