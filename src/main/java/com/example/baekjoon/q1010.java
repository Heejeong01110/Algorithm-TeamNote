package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1010 {

  private static int[][] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    dp = new int[30][30];

    int T = Integer.parseInt(br.readLine());
    for (int t = 0; t < T; t++) {
      st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());
      System.out.print(comb(M, N));

    }

    br.close();
  }

  private static int comb(int n, int r) {

    if (dp[n][r] > 0) {
      return dp[n][r];
    }

    if (n == r || r == 0) {
      return dp[n][r] = 1;
    }
    return comb(n - 1, r - 1) + comb(n - 1, r);
  }
}
