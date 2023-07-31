package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q2169 {

  private static int N;
  private static int M;
  private static int[][] map;
  private static int[][] costs;
  private static int[][] dir = new int[][]{{1, 0}, {0, -1}, {0, 1}};
  private static int max;

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

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new int[N + 1][M + 1];

    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    br.close();
  }

  private static int Solution() {

    int[][] rowSum = new int[N + 1][M + 1]; //가로 누적합
    int[][] dp = new int[N + 1][M + 1];

    for (int i = 1; i <= N; i++) {
      rowSum[i][1] = map[i][1];
      Arrays.fill(dp[i], Integer.MIN_VALUE);
      for (int j = 2; j <= M; j++) {
        rowSum[i][j] = map[i][j] + rowSum[i][j - 1];
      }
    }

    for (int i = 0; i <= M; i++) {
      dp[1][i] = rowSum[1][i];
    }

    for (int i = 2; i <= N; i++) {

      for (int minC = 1; minC <= M; minC++) {
        for (int maxC = minC; maxC <= M; maxC++) {
          int temp = rowSum[i][maxC] - rowSum[i][minC - 1];
          dp[i][minC] = Math.max(dp[i][minC], dp[i - 1][maxC] + temp);
          dp[i][maxC] = Math.max(dp[i][maxC], dp[i - 1][minC] + temp);
        }
      }

    }

    return dp[N][M];
  }


}
