package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q13302 {

  private static int N;
  private static int M;
  private static int[] days;

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
    days = new int[M];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < M; i++) {
      days[i] = Integer.parseInt(st.nextToken());
    }

    br.close();
  }

  private static int Solution() {
    int[] prices = new int[]{10000, 25000, 37000};
    int[] coupon = new int[]{0, 1, 2};

    int[][] dp = new int[N + 1][2];
    int[][] dpC = new int[N + 1][2];
    // 0 : 3+1조합,
    // 1 : 5조합
    Integer daysIndex = 0;

    for (int i = 1; i <= N; i++) {
      if (days[daysIndex] == i) { //안나오는 날
        daysIndex++;
        dp[i] = dp[i - 1];
        dpC[i] = dpC[i - 1];
        continue;
      }

      if (i <= 2) { // 1,2일
        dp[i][0] = dp[i - 1][0] + prices[0];
        dp[i][1] = dp[i - 1][1] + prices[0];
        dpC[i][0] = dpC[i - 1][0];
        dpC[i][1] = dpC[i - 1][1];
      } else if (i <= 4) { // 3,4일 --> 하루 전 + 1 vs 3일전 + 3
        if (dp[i - 1][0] + prices[0] > dp[i - 3][0] + prices[1]) {
          dp[i][0] = dp[i - 3][0] + prices[1];
          dp[i][1] = dp[i - 3][1] + prices[1];
          dpC[i][0] = dpC[i - 3][0] + coupon[1];
          dpC[i][1] = dpC[i - 3][1] + coupon[1];
        } else {
          dp[i][0] = dp[i - 1][0] + prices[0];
          dp[i][1] = dp[i - 1][1] + prices[0];
          dpC[i][0] = dpC[i - 1][0];
          dpC[i][1] = dpC[i - 1][1];
        }
      } else{
        /*
        * 1. dp[i - 1][0] + prices[0] //하루 전 금액 + 1일권
        * 2. dp[i - 3][0] + prices[1] //삼일 전 금액 + 3일권
        * 2. dp[i - 5][0] + prices[2] //5일 전 금액 + 5일권
        * */

      }

    }
    /*
     * dp[1][0] : 금액
     * dp[1][1] : 쿠폰 갯수
     * */

    return 0;
  }

}
