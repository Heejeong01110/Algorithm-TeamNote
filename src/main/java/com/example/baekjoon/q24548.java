package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q24548 {

  private static int N;
  private static char[] str;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    System.out.print(Solution());
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    str = br.readLine().toCharArray();
    br.close();
  }

  private static int Solution() {
    int ans = 0;
    int[][][][] dp = new int[3][3][3][3];
    dp[0][0][0][0] = 1;

    int t = 0, g = 0, f = 0, p = 0;

    for (int i = 0; i < N; i++) {
      if (str[i] == 'T') {
        t = (t + 1) % 3;
      } else if (str[i] == 'G') {
        g = (g + 1) % 3;
      } else if (str[i] == 'F') {
        f = (f + 1) % 3;
      } else if (str[i] == 'P') {
        p = (p + 1) % 3;
      }
      ans += dp[t][g][f][p];
      dp[t][g][f][p] += 1;
    }

    return ans;
  }

}
