package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q2228 {

  private static int N, M;
  private static int[] inp;

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
    inp = new int[N + 1];

    for (int i = 1; i <= N; i++) {
      inp[i] = Integer.parseInt(br.readLine());
    }

    br.close();
  }

  private static int Solution() {
    int[] sum = new int[N + 1];
    int[][] dp = new int[N + 1][M + 1];

    for (int i = 1; i <= N; i++) {
      sum[i] = sum[i - 1] + inp[i];
    }

    for (int j = 1; j <= M; j++) {
      dp[0][j] = -3276800;
    }

    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= M; j++) {
        dp[i][j] = dp[i - 1][j];
        for (int k = 1; k <= i; k++) {
          if (k >= 2) {
            dp[i][j] = Math.max(dp[i][j], dp[k - 2][j - 1] + sum[i] - sum[k - 1]);
          } else if (k == 1 && j == 1) {
            dp[i][j] = Math.max(dp[i][j], sum[i]);
          }
        }
      }
    }

    return dp[N][M];
  }
}
