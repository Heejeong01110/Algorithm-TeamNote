package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q15486 {

  private static int N, M;
  private static int[][] inp;
  private static int[] memo;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    System.out.print(Solution());
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st;
    N = Integer.parseInt(br.readLine());
    inp = new int[N + 2][2];

    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      inp[i][0] = Integer.parseInt(st.nextToken());
      inp[i][1] = Integer.parseInt(st.nextToken());
    }

    br.close();
  }

  private static int Solution() {
    int[] dp = new int[N + 2];
    int max = -1;
    for (int i = 1; i <= N + 1; i++) {
      if (max < dp[i]) {
        max = dp[i];
      }
      int end = i + inp[i][0];
      if (end < N + 2) {
        dp[end] = Math.max(dp[end], max + inp[i][1]);
      }
    }

    return dp[N + 1];
  }
}
