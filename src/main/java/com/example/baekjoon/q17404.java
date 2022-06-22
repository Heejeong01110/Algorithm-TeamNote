package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q17404 {

  private static int N;
  private static int[][] costs;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    output(Solution());
  }

  private static void output(int result) {
    System.out.print(result);
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st;
    N = Integer.parseInt(br.readLine());

    costs = new int[N + 1][3];
    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      costs[i][0] = Integer.parseInt(st.nextToken());
      costs[i][1] = Integer.parseInt(st.nextToken());
      costs[i][2] = Integer.parseInt(st.nextToken());
    }

    br.close();
  }

  private static int Solution() {
    int[][] dp;
    int result = 10000000;

    for (int k = 0; k < 3; k++) {
      dp = new int[N + 1][3];
      for (int i = 0; i < 3; i++) {
        dp[1][i] = 10000000;
        if (i == k) {
          dp[1][i] = costs[1][i];
        }
      }

      for (int i = 2; i <= N - 1; i++) {
        dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0];
        dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1];
        dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + costs[i][2];
      }

      for (int i = 0; i < 3; i++) {
        if (i == k) {
          continue;
        }
        dp[N][i] = Math.min(dp[N - 1][(i + 1) % 3], dp[N - 1][(i + 2) % 3]) + costs[N][i];
        result = Math.min(result, dp[N][i]);
      }

    }

    return result;
  }

}
