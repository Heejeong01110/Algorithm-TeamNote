package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1915 {

  private static int N, M;
  private static int[][] map;

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
    M = Integer.parseInt(st.nextToken());
    map = new int[N][M];

    for (int i = 0; i < N; i++) {
      String str = br.readLine();
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(str.substring(j, j + 1));
      }
    }

    br.close();
  }

  private static int Solution() {

    int[][] dp = new int[N][M];

    int max = map[0][0];
    dp[0][0] = map[0][0];
    for (int i = 1; i < M; i++) {
      dp[0][i] = map[0][i];
      max = Math.max(max, dp[0][i]);
    }

    for (int i = 1; i < N; i++) {
      dp[i][0] = map[i][0];
      max = Math.max(max, dp[i][0]);
    }

    for (int i = 1; i < N; i++) {
      for (int j = 1; j < M; j++) {
        if (map[i][j] == 0) {
          continue;
        }
        int now = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1]));
        dp[i][j] = now + 1;
        max = Math.max(max, dp[i][j]);
      }
    }

    return max * max;
  }

}
