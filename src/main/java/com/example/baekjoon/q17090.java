package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q17090 {

  private static int N, M;
  private static char[][] map;
  private static boolean[][] visited, isPossible;
  private static int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
  private static char[] dirAlp = new char[]{'U', 'D', 'L', 'R'};

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
    map = new char[N][M];

    for (int i = 0; i < N; i++) {
      String str = br.readLine();
      for (int j = 0; j < M; j++) {
        map[i] = str.toCharArray();
      }
    }

    br.close();
  }

  private static int Solution() {
    visited = new boolean[N][M];
    isPossible = new boolean[N][M];

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (!visited[i][j]) {
          dfs(i, j);
        }
      }
    }

    int sum = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (isPossible[i][j]) {
          sum++;
        }
      }
    }
    return sum;
  }

  private static boolean dfs(int r, int c) {
    if (visited[r][c]) {
      return isPossible[r][c];
    }
    visited[r][c] = true;

    for (int d = 0; d < 4; d++) {
      if (map[r][c] == dirAlp[d]) {
        int nr = r + dir[d][0];
        int nc = c + dir[d][1];
        if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
          isPossible[r][c] = dfs(nr, nc);
        } else {
          isPossible[r][c] = true;
        }
        break;
      }
    }
    return isPossible[r][c];
  }

}
