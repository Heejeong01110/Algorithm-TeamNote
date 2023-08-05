package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class q2631 {

  private static int N, answer;
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

    for (int i = 0; i < N; i++) {
      nums[i] = Integer.parseInt(br.readLine());
    }

    br.close();
  }

  private static int Solution() {
    answer = 0;
    int[] dp = new int[N];
    dp[0] = 1;

    int ans = 0;
    for(int i=1;i<N;i++){
      dp[i] = 1;
      for(int j=0;j<i;j++){
        if(nums[i]>nums[j]) dp[i] = Math.max(dp[i], dp[j]+1);
      }
      ans = Math.max(ans, dp[i]);
    }
    return N-ans;
  }

}
