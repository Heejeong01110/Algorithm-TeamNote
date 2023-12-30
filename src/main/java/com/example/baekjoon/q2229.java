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
    inp = new int[N + 1];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      inp[i] = Integer.parseInt(st.nextToken());
    }

    br.close();
  }

  private static int Solution() {

    int[] dp = new int[N + 1];

    for (int i = 1; i <= N; i++) {
      int min = inp[i];
      int max = inp[i];
      for (int j = i; j > 0; j--) {
        min = Math.min(min, inp[j]);
        max = Math.max(max, inp[j]);
        dp[i] = Math.max(dp[i], max - min + dp[j - 1]);
      }
    }
    return dp[N];
  }

}
