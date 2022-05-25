package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q7579 {

  private static int N;
  private static int M;
  private static int[] activates;
  private static int[] costs;

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
    activates = new int[N];
    costs = new int[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      activates[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      costs[i] = Integer.parseInt(st.nextToken());
    }

    br.close();
  }

  private static int Solution() {
    int result = Integer.MAX_VALUE;
    int[][] dp = new int[N][100001];

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < 100001; j++) {

        if (i == 0) {
          if (j >= costs[i]) {
            dp[i][j] = activates[i];
          }
        }else{
          if (j >= costs[i]) {
            dp[i][j] = Math.max(dp[i - 1][j - costs[i]] + activates[i], dp[i - 1][j]);
          } else {
            dp[i][j] = dp[i - 1][j];
          }
        }

        if (dp[i][j] >= M) {
          result = Math.min(result, j);
        }
      }
    }
    return result;
  }
}
