package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q14391 {

  private static int N, M;
  private static int[][] map;
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
        map[i][j] = Integer.parseInt(str.substring(j, j + 1));
      }
    }

    br.close();
  }

  private static int Solution() {
    memo = new int[N * M][N * M];

    for (int i = 0; i < N * M; i++) {
      Arrays.fill(memo[i], -1);
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        memo[i * M + j][i * M + j] = map[i][j];
      }
    }

    return calc(0, N * M - 1);
  }

  private static int calc(int start, int end) {
    int sr = start / M;
    int sc = start % M;

    int er = end / M;
    int ec = end % M;

    if (sr > er || sc > ec) {
      return 0;
    }
    if (memo[start][end] != -1) {
      return memo[start][end];
    }

    if (sr == er) {
      int sum = 0;
      for (int i = sc; i <= ec; i++) {
        sum = sum * 10 + map[sr][i];
      }
      memo[start][end] = sum;
      return memo[start][end];
    }

    if (sc == ec) {
      int sum = 0;
      for (int i = sr; i <= er; i++) {
        sum = sum * 10 + map[i][sc];
      }
      memo[start][end] = sum;
      return memo[start][end];
    }

    int max = 0;
    for (int i = sr; i <= er; i++) {
      int sum = calc(toInt(i, sc), toInt(i, ec));
      if (i != sr) {
        sum += calc(toInt(sr, sc), toInt(i - 1, ec));
      }
      if (i != er) {
        sum += calc(toInt(i + 1, sc), toInt(er, ec));
      }

      max = Math.max(max, sum);
    }

    for (int i = sc; i <= ec; i++) {
      int sum = calc(toInt(sr, i), toInt(er, i));
      if (i != sc) {
        sum += calc(toInt(sr, sc), toInt(er, i - 1));
      }
      if (i != ec) {
        sum += calc(toInt(sr, i + 1), toInt(er, ec));
      }
      max = Math.max(max, sum);
    }

    memo[start][end] = max;
    return memo[start][end];
  }

  private static int toInt(int row, int col) {
    return row * M + col;
  }

}
