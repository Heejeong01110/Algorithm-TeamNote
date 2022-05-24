package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q14925 {

  private static int N;
  private static int M;
  private static int[][] map;

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
    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    map = new int[M + 1][N + 1];

    for (int i = 1; i <= M; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    br.close();
  }

  private static int Solution() {

    int[][] dp = new int[M + 1][N + 1];
    dp[1][1] = map[1][1] == 0 ? 1 : 0;

    for (int i = 2; i <= M; i++) {
      dp[i][1] = dp[i - 1][1] + (map[i][1] == 0 ? 1 : 0);
    }
    for (int i = 1; i <= N; i++) {
      dp[1][i] = dp[1][i - 1] + (map[1][i] == 0 ? 1 : 0);
    }

    for (int i = 2; i <= M; i++) {
      for (int j = 2; j <= N; j++) {
        dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + (map[i][j] == 0 ? 1 : 0);
      }
    }

    int size = Math.min(M, N);
    for (int t = size; t >= 1; t--) {

      for (int i = 1; i <= M - t + 1; i++) {
        for (int j = 1; j <= N - t + 1; j++) {
          int count = dp[i + t - 1][j + t - 1]
              - dp[i - 1][j + t - 1] - dp[i + t - 1][j - 1]
              + dp[i - 1][j - 1];

          if (count == t * t) {
            return t;
          }
        }
      }
    }

    return 0;
  }
}
