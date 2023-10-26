package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q2225 {

  private static int N, K;
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

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    br.close();
  }

  private static int Solution() {
    int[][] dp = new int[N + 1][K + 1];

    for (int i = 0; i <= N; i++) {
      dp[i][1] = 1;
    }

    for (int k = 1; k < K; k++) {
      for (int n = 0; n <= N; n++) {
        for (int i = 0; i <= N; i++) {
          if (n + i > N) {
            break;
          }
          dp[n + i][k + 1] = (dp[n + i][k + 1] + dp[n][k]) % INF;
        }

      }
    }

    return dp[N][K];
  }
}
