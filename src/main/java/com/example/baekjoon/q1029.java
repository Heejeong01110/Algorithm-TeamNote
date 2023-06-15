package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1029 {

  private static final int INF = 10_000_000;
  private static int N;
  private static int res;
  private static int[][] cost;
  private static int[][][] dp;

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
    cost = new int[N][N];

    for (int i = 0; i < N; i++) {
      String str = br.readLine();
      for (int j = 0; j < N; j++) {
        cost[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
      }
    }
    br.close();
  }

  private static int Solution() {
    res = 0;
    dp = new int[N][1 << N][10];
    return dfs(0, 1, 0);
  }

  private static int dfs(int now, int flag, int prePrice) {
    if (flag == (1 << N) - 1) {
      dp[now][flag][prePrice] = 1;
      return 1;
    }

    if (dp[now][flag][prePrice] != 0) {
      return dp[now][flag][prePrice];
    }

    dp[now][flag][prePrice] = 1;

    for (int i = 0; i < N; i++) {
      if ((flag & (1 << i)) == 0 && now != i) {
        if (prePrice <= cost[now][i]) {
          dp[now][flag][prePrice] = Math.max(dp[now][flag][prePrice],
              1 + dfs(i, flag | 1 << i, cost[now][i]));
        }

      }
    }
    return dp[now][flag][prePrice];
  }

}
