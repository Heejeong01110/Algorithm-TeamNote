package com.example.programmers;

//멀리뛰기
public class s12914 {

  public long solution(int n) {
    long answer = 0;
    if (n <= 2) {
      return n;
    }
    int[] dp = new int[n + 1];
    dp[1] = 1;
    dp[2] = 2;

    for (int i = 3; i <= n; i++) {
      dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
    }

    return dp[n] % 1234567;
  }
}
