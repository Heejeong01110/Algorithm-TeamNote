package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q3109 {

  private static int R, C;
  private static char[][] map;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();

    int cnt = 0;
    for (int i = 0; i < R; i++) {
      if (dfs(i, 0)) {
        cnt++;
      }
    }

    System.out.print(cnt);

  }


  private static boolean dfs(int row, int col) {
    map[row][col] = '-';

    if (col == C - 1) {
      return true;
    }

    if (row - 1 >= 0 && map[row - 1][col + 1] == '.') {
      if (dfs(row - 1, col + 1)) {
        return true;
      }
    }
    if (map[row][col + 1] == '.') {
      if (dfs(row, col + 1)) {
        return true;
      }
    }
    if (row + 1 < R && map[row + 1][col + 1] == '.') {
      if (dfs(row + 1, col + 1)) {
        return true;
      }
    }
    return false;
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    map = new char[R][C];

    for (int i = 0; i < R; i++) {
      map[i] = br.readLine().toCharArray();
    }

    br.close();
  }

}
