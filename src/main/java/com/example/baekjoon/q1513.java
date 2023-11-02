package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1513 {

  private static int N, M, C;
  private static int INF = 1_000_007;
  private static int[][] inp, map;
  private static int[][][][] dp;

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
    inp = new int[C + 1][2];
    dp = new int[51][51][51][51]; //[][][마지막 오락실 번호][방문수] = 이동 횟수
    dp[1][1][0][0] = 1;
    map = new int[N + 1][M + 1];

    for (int i = 1; i <= C; i++) {
      st = new StringTokenizer(br.readLine());
      inp[i][0] = Integer.parseInt(st.nextToken());
      inp[i][1] = Integer.parseInt(st.nextToken());
      if(inp[i][0] == 1 && inp[i][1] == 1){
        dp[1][1][0][0] = 0;
        dp[1][1][i][1] = 1;
      }
      map[inp[i][0]][inp[i][1]] = i;
    }
    br.close();
  }

  private static void Solution() {

    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= M; j++) {
        if (i == 1 && j == 1) {
          continue;
        }

        if((map[i][j] > 0)){
          for(int l = 0 ; l < map[i][j] ; l++){// 방문한 최대 오락실 번호
            for(int k = 0 ; k <= l ; k++){ //방문 횟수
              dp[i][j][map[i][j]][k+1] += dp[i-1][j][l][k] + dp[i][j-1][l][k];
              dp[i][j][map[i][j]][k+1] %= INF;
            }
          }
        }
        else{
          // 오락실이 아니므로 이동
          for(int l = 0 ; l <= C ; l++){
            for(int k = 0 ; k <= l ; k++){
              dp[i][j][l][k] += dp[i-1][j][l][k] + dp[i][j-1][l][k];
              dp[i][j][l][k] %= INF;
            }
          }
        }
      }
    }

    for (int i = 0; i <= C; i++) {
      int sum = 0;
      for (int j = 0; j <= C; j++) {
        sum += dp[N][M][j][i];
      }
      sum %= INF;
      System.out.printf(sum+" ");
    }
  }

}
