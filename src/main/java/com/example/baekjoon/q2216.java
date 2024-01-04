package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q2216 {

  private static int A, B, C;
  private static int MIN_SCORE = -100_000_000;
  private static char[] X;
  private static char[] Y;
  private static int[][] dp;


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
    A = Integer.parseInt(st.nextToken());
    B = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    X = br.readLine().toCharArray();
    Y = br.readLine().toCharArray();
    br.close();
  }

  private static int Solution() {
    dp = new int[3001][3001];

    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp.length; j++) {
        dp[i][j] = MIN_SCORE;
      }
    }

    dp[X.length][Y.length] = 0;

    return dp(0, 0);
  }

  private static int dp(int x, int y) {
    if (dp[x][y] != MIN_SCORE) {
      return dp[x][y];
    }

    if (X.length == x) {
      dp[x][y] = (Y.length - y) * B;
      return dp[x][y];
    }
    if (Y.length == y) {
      dp[x][y] = (X.length - x) * B;
      return dp[x][y];
    }

    int res = B + Math.max(dp(x + 1, y), dp(x, y + 1));
    res = Math.max(res, dp(x + 1, y + 1) + (X[x] == Y[y] ? A : C));
    dp[x][y] = res;
    return dp[x][y];
  }

}
