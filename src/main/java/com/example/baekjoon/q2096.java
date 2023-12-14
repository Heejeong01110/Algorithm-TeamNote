package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q2096 {

  private static int N;
  private static int[][] inp;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    Solution();
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    inp = new int[N][3];

    StringTokenizer st;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      inp[i][0] = Integer.parseInt(st.nextToken());
      inp[i][1] = Integer.parseInt(st.nextToken());
      inp[i][2] = Integer.parseInt(st.nextToken());
    }

    br.close();
  }

  private static void Solution() {
    int[][][] dp = new int[N][3][2];
    dp[0][0][0] = inp[0][0];
    dp[0][1][0] = inp[0][1];
    dp[0][2][0] = inp[0][2];
    dp[0][0][1] = inp[0][0];
    dp[0][1][1] = inp[0][1];
    dp[0][2][1] = inp[0][2];

    for (int i = 1; i < N; i++) {
      dp[i][0][0] = Math.max(dp[i - 1][0][0], dp[i - 1][1][0]) + inp[i][0];
      dp[i][1][0] = Math.max(dp[i - 1][0][0],
          Math.max(dp[i - 1][1][0], dp[i - 1][2][0])) + inp[i][1];
      dp[i][2][0] = Math.max(dp[i - 1][1][0], dp[i - 1][2][0]) + inp[i][2];

      dp[i][0][1] = Math.min(dp[i - 1][0][1], dp[i - 1][1][1]) + inp[i][0];
      dp[i][1][1] = Math.min(dp[i - 1][0][1],
          Math.min(dp[i - 1][1][1], dp[i - 1][2][1])) + inp[i][1];
      dp[i][2][1] = Math.min(dp[i - 1][1][1], dp[i - 1][2][1]) + inp[i][2];
    }
    System.out.print(Math.max(dp[N - 1][0][0], Math.max(dp[N - 1][1][0], dp[N - 1][2][0])) + " "
        + Math.min(dp[N - 1][0][1], Math.min(dp[N - 1][1][1], dp[N - 1][2][1])));
  }

}
