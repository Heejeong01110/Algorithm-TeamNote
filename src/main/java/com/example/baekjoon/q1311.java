package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1311 {

  private static final int INF = 99999999;
  private static int N;
  private static int res;
  private static int[][] cost;
  private static int[][] dp;


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

    StringTokenizer st;
    N = Integer.parseInt(br.readLine());
    cost = new int[N][N];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        cost[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    br.close();
  }

  private static int Solution() {
    dp = new int[N][1 << N];//0:현재 보고있는 사람 1:이전까지 방문한 기록
    return dfs(0, 0);
  }

  private static int dfs(int now, int visited) {
    if (now == N) {
      return 0;
    }
    if (dp[now][visited] != 0) {
      return dp[now][visited];
    }

    int result = INF;
    for (int i = 0; i < N; i++) {
      if ((visited & (1 << i)) == 0) {
        result = Math.min(result, cost[now][i] + dfs(now + 1, visited | (1 << i)));
      }
    }
    dp[now][visited] = result;
    return dp[now][visited];
  }

}
