package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q2306 {

  private static String inp;
  private static char[] ch;
  private static char[][] DNA = new char[][]{{'a', 't'}, {'g', 'c'}};
  private static int[][] dp;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    System.out.print(Solution());
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    inp = br.readLine();
    ch = inp.toCharArray();

    br.close();
  }

  private static int Solution() {
    int length = inp.length();
    dp = new int[length][length];

    for (int i = 0; i < length; i++) {
      for (int j = 0; j < length; j++) {
        dp[i][j] = -1;
      }
    }
    int dfs = dfs(0, length - 1);
    return dfs;
  }

  private static int dfs(int start, int end) {
    if (start >= end) {
      return 0;
    }
    if (dp[start][end] != -1) {
      return dp[start][end];
    }

    int res = 0;
    for (int i = start; i < end; i++) {
      res = Math.max(res, dfs(start, i) + dfs(i + 1, end));
    }

    if (ch[start] == DNA[0][0] && ch[end] == DNA[0][1]
        || ch[start] == DNA[1][0] && ch[end] == DNA[1][1]) {
      res = Math.max(res, dfs(start + 1, end - 1) + 2);
    }
    return dp[start][end] = res;
  }


}
