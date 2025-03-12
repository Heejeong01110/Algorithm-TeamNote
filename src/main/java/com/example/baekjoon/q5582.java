package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q5582 {

  private static StringBuilder N, M;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    System.out.print(Solution());
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = new StringBuilder(br.readLine());
    M = new StringBuilder(br.readLine());

    br.close();
  }

  private static int Solution() {

    int[][] dp = new int[N.length() + 1][M.length() + 1];
    int max = 0;

    for (int i = 1; i <= N.length(); i++) {
      for (int j = 1; j <= M.length(); j++) {
        if (N.charAt(i - 1) == M.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
          max = Math.max(max, dp[i][j]);
        }
      }
    }

    return max;
  }

}
