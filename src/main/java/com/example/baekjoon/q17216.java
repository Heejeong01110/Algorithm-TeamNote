package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q17216 {

  private static int N;
  private static int[] nums;

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

    N = Integer.parseInt(br.readLine());
    nums = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      nums[i] = Integer.parseInt(st.nextToken());
    }

    br.close();
  }

  private static int Solution() {
    int[] dp = new int[N]; // 0 : 합

    dp[0] = nums[0];
    for (int i = 1; i < N; i++) {
      dp[i] = nums[i];

      for (int j = 0; j <= i; j++) {
        if (nums[i] < nums[j]) {
          dp[i] = Math.max(dp[j] + nums[i], dp[i]);
        }
      }
    }

    Integer max = 0;
    for (int i = 0; i < N; i++) {
      max = Math.max(max, dp[i]);
    }
    return max;
  }

}
