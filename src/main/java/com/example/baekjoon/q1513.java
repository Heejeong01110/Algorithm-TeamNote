package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1513 {

  private static int N, M, C;
  private static int[][] inp, map, check;
  private static int[][][] dp;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    Solution();
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    inp = new int[C + 2][2];

    for (int i = 1; i <= C; i++) {
      st = new StringTokenizer(br.readLine());
      inp[i][0] = Integer.parseInt(st.nextToken());
      inp[i][1] = Integer.parseInt(st.nextToken());
    }
    inp[C + 1][0] = N;
    inp[C + 1][1] = M;
    br.close();
  }

  private static void Solution() {
    map = new int[N + 1][M + 1];
    for (int i = 1; i <= C + 1; i++) {
      map[inp[i][0]][inp[i][1]] = i;
    }

    check = new int[N + 1][M + 1];
    dp = new int[N + 1][M + 1][C + 2];
    dp[1][1][0] = 1;

    for (int i = 1; i <= N; i++) {
      check[i][1] = 1;
      if (map[i][1] == 0) {
        dp[i][1][0] += dp[i - 1][1][0];
      }
    }
    for (int i = 1; i <= M; i++) {
      check[1][i] = 1;
      if (map[i][1] == 0) {
        dp[1][i][0] += dp[1][i - 1][0];
      }
    }

    for (int i = 2; i <= N; i++) {
      for (int j = 2; j <= M; j++) {
        check[i][j] = check[i - 1][j] + check[i][j - 1];
        if (map[i][j] == 0 || i == N && j == M) {
          dp[i][j][0] += dp[i][j - 1][0] + dp[i - 1][j][0];
        }
      }
    }

    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= M; j++) {
        if (i == 1 && j == 1) {
          continue;
        }
        for (int k = 1; k <= C + 1; k++) {
          if (map[i][j] != 0) {
            dp[i][j][k] += dp[i][j - 1][k - 1] + dp[i - 1][j][k - 1];
          } else {
            dp[i][j][k] += dp[i][j - 1][k] + dp[i - 1][j][k];
          }
        }
      }
    }

    for (int i = 1; i <= C + 1; i++) {
      System.out.print(dp[N][M][i] + " ");
    }
  }

  private static int getCnt(int start, int end, int idx) {
    if (dp[start][end][idx] != -1) {
      return dp[start][end][idx];
    }

    int answer = check[inp[end][0]][inp[end][1]];

    for (int i = inp[start][0]; i <= inp[end][0]; i++) {
      for (int j = inp[start][1]; j <= inp[end][1]; j++) {
        if ((i == inp[end][0] && j == inp[end][1]) || (i == inp[start][0] && j == inp[start][1])
            || map[i][j] == 0) {
          continue;
        }
        answer -= getCnt(start, map[i][j], idx - 1) * getCnt(map[i][j], end, idx - 1);
      }
    }

    dp[start][end][idx] = answer;
    return answer;
  }

}
