package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q1670 {

  private static int N;
  private static int INF = 987654321;

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

    long[] dp = new long[N + 1];
    dp[0] = 1;
    dp[2] = 1;

    for (int i = 4; i <= N; i += 2) {
      for (int j = 0; j <= i - 2; j += 2) {
        dp[i] = (dp[i] + dp[j] * dp[(i - 2) - j]) % INF;
      }
    }

    return dp[N];
  }
}
