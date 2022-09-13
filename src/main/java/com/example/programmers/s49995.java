package com.example.programmers;

public class s49995 {

  public static int solution(int[] cookie) {
    int answer = 0;

    int size = cookie.length;
    int[] dp = new int[size + 1];

    dp[0] = 0;
    for (int i = 1; i <= size; i++) {
      dp[i] = dp[i - 1] + cookie[i - 1];
    }

    int left, right;
    int start, end;

    for (int i = 1; i < size; i++) {
      start = i - 1;
      end = i + 1;

      while (start >= 0 && end <= size) {
        left = dp[i] - dp[start];
        right = dp[end] - dp[i];

        if (left == right) {
          answer = Math.max(answer, left);

          if (start == 0 && end < size) {
            end++;
          } else {
            start--;
          }
        } else if (left < right) {
          start--;
        }else {
          end++;
        }
      }

    }

    return answer;
  }
}
