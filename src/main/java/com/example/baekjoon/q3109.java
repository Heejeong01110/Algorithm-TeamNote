package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class q3109 {

  private static int R, C;
  private static int[][] map;
  private static boolean[][] connedted;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    boolean[][] visited = new boolean[R][C];
    connedted = new boolean[R][C];
    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        visited[i][j] = map[i][j] == 1;
        connedted[i][j] = true;
      }
    }

    int cnt = 0;
    for (int i = 0; i < R; i++) {
      visited[i][0] = true;
      if (dfs(i, 0, visited)) {
        cnt++;
      }
      visited[i][0] = false;
    }

    System.out.print(cnt);

  }


  private static boolean dfs(int row, int col, boolean[][] visited) {
    if (col == C - 2) {
      for (int i = 0; i < R; i++) {
        for (int j = 0; j < C - 2; j++) {
          map[i][j] = visited[i][j] ? 1 : map[i][j];
        }
      }
      return true;
    }

    boolean result = false;
    if (row - 1 >= 0 && map[row - 1][col + 1] == 0 && connedted[row - 1][col + 1]) {
      visited[row - 1][col + 1] = true;
      result = dfs(row - 1, col + 1, visited);
      visited[row - 1][col + 1] = false;
    }
    if (map[row][col + 1] == 0 && connedted[row][col + 1]) {
      visited[row][col + 1] = true;
      result = result || dfs(row, col + 1, visited);
      visited[row][col + 1] = false;
    }
    if (row + 1 < R && map[row + 1][col + 1] == 0 && connedted[row + 1][col + 1]) {
      visited[row + 1][col + 1] = true;
      result = result || dfs(row + 1, col + 1, visited);
      visited[row + 1][col + 1] = false;
    }
    connedted[row][col] = false;
    return result;
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    map = new int[R][C];

    for (int i = 0; i < R; i++) {
      String str = br.readLine();
      for (int j = 0; j < C; j++) {
        map[i][j] = (str.charAt(j) == '.' ? 0 : 1);
      }
    }

    br.close();
  }

}
