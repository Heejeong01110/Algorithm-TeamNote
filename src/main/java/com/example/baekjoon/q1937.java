package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1937 {

  private static final int[][] dir = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
  private static int N;
  private static int[][] map, memo;

  public static void main(String[] args) throws IOException {
    inputData();
    System.out.print(Solution());
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st;
    N = Integer.parseInt(br.readLine());
    map = new int[N][N];
    memo = new int[N][N];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    br.close();
  }

  private static int Solution() {
    int res = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        res = Math.max(res, dfs(i, j));
      }
    }
    return res;
  }

  private static int dfs(int r, int c) {
    if (memo[r][c] != 0) {
      return memo[r][c];
    }
    int max = 0;
    for (int d = 0; d < 4; d++) {
      int nr = r + dir[d][0];
      int nc = c + dir[d][1];

      if (isPossible(nr, nc) && map[r][c] < map[nr][nc]) {
        max = Math.max(max, dfs(nr, nc));
      }
    }
    memo[r][c] = max + 1;
    return memo[r][c];
  }

  private static boolean isPossible(int r, int c) {
    return r >= 0 && r < N && c >= 0 && c < N;
  }
}
