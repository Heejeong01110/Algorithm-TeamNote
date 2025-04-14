package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1103 {

  private static final int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
  private static int N, M;
  private static int[][] map;
  private static int answer;
  private static int[][] memo;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    System.out.print(Solution());
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new int[N][M];

    for (int i = 0; i < N; i++) {
      String str = br.readLine();
      for (int j = 0; j < M; j++) {
        if (str.charAt(j) == 'H') {
          map[i][j] = 0;
        } else {
          map[i][j] = Integer.parseInt(str.substring(j, j + 1));
        }
      }
    }

    br.close();
  }

  private static int Solution() {
    memo = new int[N][M];
    boolean[][] visited = new boolean[N][M];
    visited[0][0] = true;
    return dfs(0, 0, visited);
  }

  private static int dfs(int row, int col, boolean[][] visited) {
    if (memo[row][col] != 0) {
      return memo[row][col];
    }

    int tmp = 0;

    for (int d = 0; d < 4; d++) {
      int nr = row + dir[d][0] * map[row][col];
      int nc = col + dir[d][1] * map[row][col];
      if (nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == 0) {
        continue;
      }

      if (visited[nr][nc] || memo[nr][nc] == -1) {
        map[row][col] = -1;
        return map[row][col];
      }

      if (memo[nr][nc] > 0) {
        tmp = Math.max(tmp, memo[nr][nc]);
        continue;
      }
      visited[row][col] = true;
      int res = dfs(nr, nc, visited);
      visited[row][col] = false;

      if (res == -1) {
        map[row][col] = -1;
        return map[row][col];
      }
      tmp = Math.max(tmp, res);
    }
    memo[row][col] = tmp + 1;
    return memo[row][col];
  }

}
