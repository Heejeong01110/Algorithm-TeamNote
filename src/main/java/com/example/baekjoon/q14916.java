package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class q14916 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    br.close();

    int[] dp = new int[100001];
    Arrays.fill(dp, -1);

    dp[2] = 1;
    dp[4] = 2;
    dp[5] = 1;

    for (int i = 6; i <= N; i++) {
      int r = Integer.MAX_VALUE;
      if (dp[i - 5] != -1) {
        r = dp[i - 5] + 1;
      }
      if (dp[i - 2] != -1) {
        r = Math.min(r, dp[i - 2] + 1);
      }
      if (r != Integer.MAX_VALUE) {
        dp[i] = r;
      }
    }
    System.out.print(dp[N]);
  }
}
