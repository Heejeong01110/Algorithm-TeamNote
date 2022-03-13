package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//오답
public class q20543 {

  private static int N;
  private static int M;
  private static int[][] map;
  private static int[][] bomb;
  private static int[][] result;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    output(Solution());
  }

  private static void output(StringBuilder result) {
    System.out.print(result.toString());
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new int[N][N];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    br.close();
  }

  private static StringBuilder Solution() {
    result = new int[N][N];

    for (int i = M / 2; i < N - M / 2; i++) {
      for (int j = M / 2; j < N - M / 2; j++) {
        calc(i, j);
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        sb.append(result[i][j] + " ");
      }
      sb.append("\n");
    }

    return sb;
  }

  private static void calc(int row, int col) {
    Integer count = -map[row - M / 2][col - M / 2];

    if (count == 0) {
      return;
    }

    result[row][col] = count;
    for (int i = -M / 2; i <= M / 2; i++) {
      for (int j = -M / 2; j <= M / 2; j++) {
        map[row + i][col + j] += count;
      }
    }

  }

}
