package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q17070 {

  private static int N;
  private static int[][] map;
  private static int[][][] dp;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();

    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= N; j++) {
        Arrays.fill(dp[i][j], -1);
      }
    }
    for (int i = 2; i <= N; i++) {
      dp[1][i][0] = 1;
    }

    System.out.print(dfs(1, 2, 0));
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st;
    N = Integer.parseInt(br.readLine());
    map = new int[N + 1][N + 1];
    dp = new int[N + 1][N + 1][3];

    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= N; j++) {
        Arrays.fill(dp[i][j], -1);
      }
    }

    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    br.close();
  }

  private static int dfs(int r, int c, int type) {
    if (r == N && c == N) {
      return 1;
    }
    if (dp[r][c][type] != -1) {
      return dp[r][c][type];
    }

    int cnt = 0;
    if (type == 0) { //가로
      if (c + 1 <= N && map[r][c + 1] == 0) {
        cnt += dfs(r, c + 1, 0);
      }

      if (r + 1 <= N && c + 1 <= N && map[r + 1][c] == 0 && map[r][c + 1] == 0
          && map[r + 1][c + 1] == 0) {
        cnt += dfs(r + 1, c + 1, 2);
      }
    } else if (type == 1) { //세로
      if (r + 1 <= N && map[r + 1][c] == 0) {
        cnt += dfs(r + 1, c, 1);
      }

      if (r + 1 <= N && c + 1 <= N && map[r + 1][c] == 0 && map[r][c + 1] == 0
          && map[r + 1][c + 1] == 0) {
        cnt += dfs(r + 1, c + 1, 2);
      }
    } else if (type == 2) { //대각선
      if (c + 1 <= N && map[r][c + 1] == 0) {
        cnt += dfs(r, c + 1, 0);
      }

      if (r + 1 <= N && map[r + 1][c] == 0) {
        cnt += dfs(r + 1, c, 1);
      }

      if (r + 1 <= N && c + 1 <= N && map[r + 1][c] == 0 && map[r][c + 1] == 0
          && map[r + 1][c + 1] == 0) {
        cnt += dfs(r + 1, c + 1, 2);
      }
    }
    return dp[r][c][type] = cnt;
  }

}
