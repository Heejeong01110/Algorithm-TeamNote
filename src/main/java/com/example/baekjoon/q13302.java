package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q13302 {

  private static int N;
  private static int M;
  private static boolean[] days;
  private static int[][] dp;

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
    days = new boolean[N + 1];

    if(M>0){
      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < M; i++) {
        days[Integer.parseInt(st.nextToken())] = true;
      }
    }

    br.close();
  }

  private static int Solution() {
    dp = new int[N + 1][N + 1];

    for (int i = 1; i <= N; i++) {
      Arrays.fill(dp[i], -1);
    }

    Integer result = solve(1, 0);

    return result;
  }

  private static Integer solve(int day, int coupon) {
    if (day > N) {
      return 0;
    }

    if (dp[day][coupon] != -1) {
      return dp[day][coupon];
    }

    dp[day][coupon] = Integer.MAX_VALUE;

    if (days[day]) {//쉬는 날
      dp[day][coupon] = Math.min(dp[day][coupon], solve(day + 1, coupon));
      return dp[day][coupon];
    } else {
      if (coupon >= 3) {
        dp[day][coupon] = Math.min(dp[day][coupon], solve(day + 1, coupon - 3));
      }
      dp[day][coupon] = Math.min(dp[day][coupon], solve(day + 1, coupon) + 10000);
      dp[day][coupon] = Math.min(dp[day][coupon], solve(day + 3, coupon + 1) + 25000);
      dp[day][coupon] = Math.min(dp[day][coupon], solve(day + 5, coupon + 2) + 37000);
    }
    return dp[day][coupon];
  }

}
