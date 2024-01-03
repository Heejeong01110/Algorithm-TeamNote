package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q1947 {

  private static int N;
  private static int INF = 1_000_000_000;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    System.out.print(Solution());
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    br.close();
  }

  private static long Solution() {

    long[] dp = new long[Math.max(3, N + 1)];

    dp[2] = 1;
    dp[3] = 2;
    for (int n = 4; n <= N; n++) {
      dp[n] = (n - 1) * (dp[n - 1] + dp[n - 2]) % INF;
    }

    return dp[N];
  }

}
