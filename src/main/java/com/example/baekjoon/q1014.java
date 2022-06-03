package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1014 {

  private static final int[][] direct = new int[][]{{0, 1}, {0, -1}, {-1, -1}, {-1, 1}};
  private static int result;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());

    for (int t = 0; t < T; t++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());
      String[][] map = new String[N][M];

      for (int i = 0; i < N; i++) {
        String str = br.readLine();
        for (int j = 0; j < M; j++) {
          map[i][j] = str.substring(j, j + 1);
        }
      }

      result = 0;
      dfs(0, 0, new boolean[N][M], 0, N, M, map);
      System.out.println(result);
    }

    br.close();
  }

  private static void dfs(int row, int col, boolean[][] seats, int count, int N, int M,
      String[][] map) {
    if (row >= N) {
      result = Math.max(result, count);
      return;
    }

    if (col >= M) {
      dfs(row + 1, 0, seats, count, N, M, map);
      return;
    }

    if (map[row][col].equals("x")) {
      dfs(row, col + 1, seats, count, N, M, map);
      return;
    }

    //앉을 수 있는 자리인 경우
    if (isPossible(row, col, seats, N, M) && !seats[row][col]) {
      seats[row][col] = true;
      dfs(row, col + 1, seats, count + 1, N, M, map);
      seats[row][col] = false;
    }
    dfs(row, col + 1, seats, count, N, M, map);

  }

  private static boolean isPossible(int row, int col, boolean[][] seats, int N, int M) {
    for (int i = 0; i < direct.length; i++) {
      int nr = row + direct[i][0];
      int nc = col + direct[i][1];
      if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
        if (seats[nr][nc]) {
          return false;
        }
      }
    }
    return true;
  }

}
