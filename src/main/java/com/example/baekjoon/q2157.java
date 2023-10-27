package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q2157 {

  private static int N, M, K;
  private static int[][] map;

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
    K = Integer.parseInt(st.nextToken());
    map = new int[N + 1][N + 1];

    for (int i = 0; i < K; i++) {
      st = new StringTokenizer(br.readLine());
      int o = Integer.parseInt(st.nextToken());
      int p = Integer.parseInt(st.nextToken());
      int q = Integer.parseInt(st.nextToken());
      map[o][p] = Math.max(map[o][p], q);
    }

    br.close();
  }

  private static int Solution() {
    int[][] dp = new int[N + 1][M + 1]; //N번째 도시를 M번 순서에 도착했을 때 최대값

    for (int i = 0; i <= N; i++) {
      Arrays.fill(dp[i], -1);
    }

    dp[1][1] = 0;
    for (int i = 1; i <= N; i++) { //출발지
      for (int j = i + 1; j <= N; j++) { //도착지
        if (map[i][j] == 0) {
          continue;
        }
        for (int k = 2; k <= M; k++) { // 도시 방문횟수
          if (dp[i][k - 1] == -1) {
            continue;
          }
          dp[j][k] = Math.max(dp[j][k], dp[i][k - 1] + map[i][j]);
        }
      }
    }

    int max = 0;
    for (int i = 1; i <= M; i++) {
      max = Math.max(max, dp[N][i]);
    }

    return max;
  }


}
