package com.example.programmers;

import java.util.Arrays;

public class s12938 {

  public static int[] solution(int n, int s) {
    if (s < n) {
      return new int[]{-1};
    }

    int[] answer = new int[n];
    int avg = s / n;

    Arrays.fill(answer, avg);
    for (int i = 1; i <= s % n; i++) {
      answer[n - i] += 1;
    }
    return answer;
  }
}
