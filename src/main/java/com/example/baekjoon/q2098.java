package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q2098 {

  private static final int INF = 16_000_000;
  private static int N;
  private static int[][] cost;
  private static int[][] dp;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    cost = new int[N][N];

    StringTokenizer st;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        cost[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    dp = new int[N][1 << N];

    // dp배열 초기화
    for (int i = 0; i < N; i++) {
      Arrays.fill(dp[i], -1);
    }

    System.out.println(dfs(0, 1));
    br.close();
  }

  private static int dfs(int now, int flag) {
    if (flag == (1 << N) - 1) {
      if (cost[now][0] == 0) {
        return INF;
      }
      return cost[now][0];
    }

    if (dp[now][flag] != -1) {
      return dp[now][flag];
    }

    dp[now][flag] = INF;
    for (int i = 0; i < N; i++) {
      if ((flag & (1 << i)) == 0 && cost[now][i] != 0) {
        dp[now][flag] = Math.min(dp[now][flag], cost[now][i] + dfs(i, flag | 1 << i));
      }
    }
    return dp[now][flag];
  }

}
