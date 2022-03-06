package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q5569 {

  final private static int[][] dir = {{0, 1}, {1, 0}};
  private static int N;
  private static int M;
  private static int result;

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

    br.close();
  }

  private static int Solution() {
    result = 0;

    int[][][][] dp = new int[N + 1][M + 1][2][2];

    for (int i = 2; i <= N; i++) {
      dp[i][1][0][0] = 1;
    }
    for (int i = 2; i <= M; i++) {
      dp[1][i][1][0] = 1;
    }

    for (int i = 2; i <= N; i++) {
      for (int j = 2; j <= M; j++) {
        dp[i][j][0][0] = (dp[i - 1][j][0][0] + dp[i - 1][j][0][1]) % 100000; //아래에서 옴. 직진
        dp[i][j][0][1] = dp[i - 1][j][1][0]; //아래에서 옴. 커브
        dp[i][j][1][0] = (dp[i][j - 1][1][0] + dp[i][j - 1][1][1]) % 100000; //왼쪽에서 옴. 직진
        dp[i][j][1][1] = dp[i][j - 1][0][0]; //왼쪽에서 옴. 커브
      }
    }
    result = dp[N][M][0][0] + dp[N][M][0][1] + dp[N][M][1][0] + dp[N][M][1][1];
    return result % 100000;
  }

}
