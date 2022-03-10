package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q11048 {

  private static int N;
  private static int M;
  private static int[][] ary;

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

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    ary = new int[N + 1][M + 1];

    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= M; j++) {
        ary[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    br.close();
  }

  private static int Solution() {
    int[][] dp = new int[N + 1][M + 1];

    dp[1][1] = ary[1][1];
    for (int i = 2; i <= M; i++) {
      dp[1][i] = dp[1][i - 1] + ary[1][i];
    }
    for (int i = 2; i <= N; i++) {
      dp[i][1] = dp[i - 1][1] + ary[i][1];
    }

    for (int i = 2; i <= N; i++) {
      for (int j = 2; j <= M; j++) {
        dp[i][j] = Math.max(dp[i - 1][j], Math.max(dp[i][j - 1], dp[i - 1][j - 1])) + ary[i][j];
      }
    }

    return dp[N][M];
  }

}
