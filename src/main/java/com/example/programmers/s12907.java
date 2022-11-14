package com.example.programmers;

import java.util.Arrays;

public class s12907 {

  public static int solution(int n, int[] money) {
    int[] dp = new int[n + 1];
    Arrays.sort(money);

    dp[0] = 1;
    for (int i = 1; i <= n; i++) {
      if (i % money[0] == 0) {
        dp[i] += 1;
      }
    }

    for (int m = 1; m < money.length; m++) {
      for (int now = money[m]; now <= n; now++) {
        dp[now] = (dp[now] + dp[now - money[m]]) % 1_000_000_007;
      }
    }

    return dp[n];
  }
}
