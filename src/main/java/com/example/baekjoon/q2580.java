package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q2580 {

  private static int[][] map;
  private static StringBuilder sb;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    Solution();
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st;
    map = new int[9][9];

    for (int i = 0; i < 9; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 9; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    br.close();
  }

  private static void Solution() {
    sb = new StringBuilder();
    calc(0, 0);
  }

  private static void calc(int row, int col) {
    if (col == 9) {
      calc(row + 1, 0);
      return;
    }

    if (row == 9) {
      for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
          sb.append(map[i][j]).append(" ");
        }
        sb.append("\n");
      }

      System.out.print(sb);
      System.exit(0);
    }

    if (map[row][col] == 0) {

      for (int i = 1; i <= 9; i++) {
        if (isPossible(row, col, i)) {
          map[row][col] = i;
          calc(row, col + 1);
        }
      }


      map[row][col] = 0;
      return;
    }

    calc(row, col + 1);
  }


  private static boolean isPossible(int row, int col, int number) {
    for (int i = 0; i < 9; i++) {
      if (map[row][i] == number || map[i][col] == number) {
        return false;
      }
    }

    int sr = (row / 3) * 3;
    int sc = (col / 3) * 3;

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (map[sr + i][sc + j] == number) {
          return false;
        }
      }
    }
    return true;
  }

}
