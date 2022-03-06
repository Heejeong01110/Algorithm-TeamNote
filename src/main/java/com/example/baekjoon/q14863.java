package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q14863 {

  private static int N;
  private static int K;
  private static int[][] map;
  private static int result;
  //0 : 도보 시간
  //1 : 도보 금액
  //2 : 자전거 시간
  //3 : 자전거 금액

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
    K = Integer.parseInt(st.nextToken());
    map = new int[N + 1][4];

    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      map[i][0] = Integer.parseInt(st.nextToken());
      map[i][1] = Integer.parseInt(st.nextToken());
      map[i][2] = Integer.parseInt(st.nextToken());
      map[i][3] = Integer.parseInt(st.nextToken());
    }

    br.close();
  }

  private static int Solution() {
    int[][] dp = new int[N + 1][K + 1];

    for (int i = 1; i <= N; i++) {
      if (i == 1) {
        dp[i][map[1][0]] = map[1][1];
        dp[i][map[1][2]] = Math.max(dp[i][map[1][2]], map[1][3]);
      } else {
        for (int j = 0; j <= K; j++) {
          if (dp[i - 1][j] == 0) {
            continue;
          } else {
            if (j + map[i][0] <= K) {
              dp[i][j + map[i][0]] = Math.max(dp[i][j + map[i][0]],
                  dp[i - 1][j] + map[i][1]);
            }
            if (j + map[i][2] <= K) {
              dp[i][j + map[i][2]] = Math.max(dp[i][j + map[i][2]],
                  dp[i - 1][j] + map[i][3]);
            }
          }
        }
      }

    }

    result = 0;
    for (int i = 1; i <= K; i++) {
      result = Math.max(result, dp[N][i]);
    }

    return result;
  }

}
