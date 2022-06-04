package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q1727 {

  private static int N;
  private static int M;
  private static int[] male;
  private static int[] female;

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
    male = new int[N + 1];
    female = new int[M + 1];

    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      male[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= M; i++) {
      female[i] = Integer.parseInt(st.nextToken());
    }

    br.close();
  }

  private static int Solution() {

    Arrays.sort(male);
    Arrays.sort(female);

    int[][] dp = new int[N + 1][M + 1];

    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= M; j++) {

        dp[i][j] = dp[i - 1][j - 1] + Math.abs(male[i] - female[j]);
        if (i < j) {
          dp[i][j] = Math.min(dp[i][j], dp[i][j - 1]);
        } else if (i > j) {
          dp[i][j] = Math.min(dp[i][j], dp[i - 1][j]);
        }
      }
    }
    return dp[N][M];
  }

}
