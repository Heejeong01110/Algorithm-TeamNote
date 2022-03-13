package com.example.programmers;

// 2 x n 타일링
public class s12900 {

  public static int solution(int n) {
    int[] dp = new int[n + 1];

    if (n <= 2) {
      return n;
    }

    dp[1] = 1;
    dp[2] = 2;
    for (int i = 3; i <= n; i++) {
      dp[i] = (dp[i - 2] + dp[i - 1]) % 1_000_000_007;
    }
    return dp[n];
  }
}
