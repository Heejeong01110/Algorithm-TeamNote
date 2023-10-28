package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q2159 {

  private static int N;
  private static int[][] inp;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    System.out.print(Solution());
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st;
    N = Integer.parseInt(br.readLine());
    inp = new int[N + 1][2];

    for (int i = 0; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      inp[i][0] = Integer.parseInt(st.nextToken());
      inp[i][1] = Integer.parseInt(st.nextToken());
    }

    br.close();
  }

  private static long Solution() {
    int[][] dir = new int[][]{{0, 0}, {1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    long[][] dp = new long[N + 1][5];
    int nx, ny, px, py;

    for (int i = 0; i <= N; i++) {
      Arrays.fill(dp[i], Long.MAX_VALUE);
    }

    for (int d = 0; d < dir.length; d++) {
      nx = inp[1][0] + dir[d][0];
      ny = inp[1][1] + dir[d][1];

      dp[1][d] = Math.abs(inp[0][0] - nx) + Math.abs(inp[0][1] - ny);
    }

    for (int i = 2; i <= N; i++) {

      for (int pd = 0; pd < dir.length; pd++) {
        px = inp[i - 1][0] + dir[pd][0];
        py = inp[i - 1][1] + dir[pd][1];
        for (int nd = 0; nd < dir.length; nd++) {
          nx = inp[i][0] + dir[nd][0];
          ny = inp[i][1] + dir[nd][1];

          dp[i][nd] = Math.min(dp[i][nd], dp[i - 1][pd] + Math.abs(px - nx) + Math.abs(py - ny));
        }
      }
    }

    long res = Long.MAX_VALUE;
    for (int d = 0; d < dir.length; d++) {
      res = Math.min(res, dp[N][d]);
    }
    return res;
  }

}
