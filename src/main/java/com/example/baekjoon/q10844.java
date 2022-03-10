package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q10844 {

  private static int N;

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
    N = Integer.parseInt(br.readLine());

    br.close();
  }

  private static int Solution() {
    int[][] dp = new int[N + 1][10];

    for (int i = 0; i <= 9; i++) {
      dp[1][i] = 1;
    }

    for (int i = 2; i <= N; i++) {
      dp[i][0] = dp[i - 1][1];
      dp[i][9] = dp[i - 1][8];
      for (int j = 1; j <= 8; j++) {
        dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1_000_000_000;
      }
    }

    Integer result = 0;
    for (int i = 1; i <= 9; i++) {
      result = (result + dp[N][i]) % 1_000_000_000;
    }

    return result;
  }

}
