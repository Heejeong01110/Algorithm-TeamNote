package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q2229 {

  private static int N;
  private static int[] inp;
  private static int[][] dp;
  private static int[][][] scores;

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
    inp = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      inp[i] = Integer.parseInt(st.nextToken());
    }

    br.close();
  }

  private static int Solution() {

    scores = new int[N][N][2];
    for (int i = 0; i < N; i++) {
      int min = inp[i];
      int max = inp[i];
      for (int j = i + 1; j < N; j++) {
        scores[i][j][0] = min = Math.min(min, inp[j]);
        scores[i][j][1] = max = Math.max(max, inp[j]);
      }
    }

    dp = new int[N][N]; // [i] 부터 [j]까지 점수의 최대값
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        dp[i][j] = -1;
        if (i == j) {
          dp[i][j] = 0;
        }
      }
    }

    return dp(0, N - 1);
  }

  private static int dp(int start, int end) {
    if (dp[start][end] != -1) {
      return dp[start][end];
    }

    int res = scores[start][end][1] - scores[start][end][0];
    for (int i = start; i < end; i++) {
      int dp1 = dp(start, i);
      int dp2 = dp(i + 1, end);
      res = Math.max(res, dp1 + dp2);
    }

    dp[start][end] = res;
    return dp[start][end];
  }

}
