package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q2281 {

  private static int n, m;
  private static int[] inp;
  private static int[] dp;

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
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    inp = new int[n];
    for (int i = 0; i < n; i++) {
      inp[i] = Integer.parseInt(br.readLine());
    }

    br.close();
  }

  private static int Solution() {
    dp = new int[n];
    Arrays.fill(dp, Integer.MAX_VALUE);
//    dp[n - 1] = 0;

    return dfs(0);
  }

  private static int dfs(int index) {
    // 남은 칸수가 존재 하는 값
    if (dp[index] < Integer.MAX_VALUE) {
      return dp[index];
    }

    int k = m - inp[index]; // 남은 칸수
    for (int i = index + 1; i <= n && k >= 0; i++) {
      if (i == n) { // 한줄이 다 체워져 있는 경우
        dp[index] = 0;
        break;
      }
      // 이어 붙인 경우와 이어 붙이지 않은 경우의 수중 가장 작은 값을 갱신한다
      dp[index] = Math.min(dp[index], (k * k) + dfs(i));
      // 남은 칸수를 갱신한다
      k -= inp[i] + 1;
    }
    return dp[index];
  }

}
