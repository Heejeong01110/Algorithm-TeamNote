package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q17136 {

  private static int result;
  private static int[][] map;
  private static int[] paper;

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
    map = new int[10][10];

    for (int i = 0; i < 10; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 10; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    br.close();
  }

  private static int Solution() {
    result = Integer.MAX_VALUE;
    paper = new int[]{0, 5, 5, 5, 5, 5};

    dfs(0,0,0);
    if(result == Integer.MAX_VALUE){
      return -1;
    }
    return result;
  }

  private static void dfs(int row, int col, int count) {
    if (row > 9) {
      result = Math.min(result, count);
      return;
    }

    if (result <= count) {
      return;
    }

    if (col > 9) {
      dfs(row + 1, 0, count);
      return;
    }

    if (map[row][col] == 1) {
      for (int i = 5; i >= 1; i--) {
        if (paper[i] > 0 && isAttach(row, col, i)) {
          attach(row, col, i, 0); // 색종이를 붙임.
          paper[i]--;
          dfs(row, col + 1, count + 1);
          attach(row, col, i, 1); // 색종이를 다시 뗌.
          paper[i]++;
        }
      }
    } else {
      dfs(row, col + 1, count);
    }
  }

  private static boolean isAttach(int x, int y, int size) {
    for (int i = x; i < x + size; i++) {
      for (int j = y; j < y + size; j++) {
        if (i < 0 || i >= 10 || j < 0 || j >= 10) {
          return false;
        }

        if (map[i][j] != 1) {
          return false;
        }
      }
    }
    return true;
  }

  public static void attach(int x, int y, int size, int state) {
    for (int i = x; i < x + size; i++) {
      for (int j = y; j < y + size; j++) {
        map[i][j] = state;
      }
    }
  }


}
