package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q11066 {

  private static int[][] dp;
  private static int[] nums;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    Solution();
  }

  private static void Solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int T = Integer.parseInt(br.readLine());
    for (int t = 0; t < T; t++) {
      int K = Integer.parseInt(br.readLine());
      nums = new int[K + 1];
      dp = new int[K + 1][K + 1];
      int[] subTotal = new int[K + 1];

      st = new StringTokenizer(br.readLine());
      for (int i = 1; i <= K; i++) {
        nums[i] = Integer.parseInt(st.nextToken());
        subTotal[i] = subTotal[i - 1] + nums[i];
      }

      for (int gap = 1; gap < K; gap++) {
        for (int start = 1; start <= K - gap; start++) {
          int end = start + gap;
          dp[start][end] = Integer.MAX_VALUE;

          for (int mid = start; mid < end; mid++) {
            dp[start][end] = Math.min(dp[start][end],
                dp[start][mid] + dp[mid + 1][end] + subTotal[end] - subTotal[start - 1]);
          }
        }
      }
      System.out.print(dp[1][K] + "\n");
    }
    br.close();
  }
}
