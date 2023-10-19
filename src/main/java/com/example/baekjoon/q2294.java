package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q2294 {

  private static int N, K;
  private static int MAX = 100_000_000;
  private static int[] coins;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    System.out.print(Solution());
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    coins = new int[N];

    for (int i = 0; i < N; i++) {
      coins[i] = Integer.parseInt(br.readLine());
    }

    br.close();
  }

  private static int Solution() {

    int[] dp = new int[K + 1];
    Arrays.fill(dp, MAX);

    for (int i = 0; i < N; i++) {
      if (coins[i] <= K) {
        dp[coins[i]] = 1;
      }
    }

    for (int i = 1; i <= K; i++) {
      for (int coin : coins) {
        if (i - coin >= 0) {
          dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
        }
      }
    }

    if (dp[K] == MAX) {
      return -1;
    }
    return dp[K];
  }
}
