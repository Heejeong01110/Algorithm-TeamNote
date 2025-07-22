package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q16637 {

  private static int N;
  private static String inp;

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
    inp = br.readLine();
    br.close();
  }

  private static long Solution() {
    if (N == 1) {
      return Long.parseLong(inp.substring(0, 1));
    }

    long[][] dp = new long[N + 1][2];
    dp[1][0] = calc(getNum(0), inp.charAt(1), getNum(2));
    dp[1][1] = dp[1][0];
    if (N == 3) {
      return dp[1][0];
    }
    dp[3][0] = calc(dp[1][0], inp.charAt(3), getNum(4));
    dp[3][1] = Math.max(dp[3][0],
        calc(getNum(0), inp.charAt(1), calc(getNum(2), inp.charAt(3), getNum(4))));

    for (int i = 5; i < inp.length(); i += 2) {
      dp[i][0] = Math.max(
          calc(dp[i - 2][0], inp.charAt(i), getNum(i + 1)),
          calc(dp[i - 2][1], inp.charAt(i), getNum(i + 1)));
      long calc = calc(getNum(i - 1), inp.charAt(i), getNum(i + 1));
      dp[i][1] = Math.max(
          calc(dp[i - 4][0], inp.charAt(i - 2), calc),
          calc(dp[i - 4][1], inp.charAt(i - 2), calc));
    }

    return Math.max(dp[N - 2][0], dp[N - 2][1]);
  }

  private static long calc(long one, char operator, long two) {
    return switch (operator) {
      case '+' -> one + two;
      case '-' -> one - two;
      case '*' -> one * two;
      case '/' -> one / two;
      default -> 0L;
    };
  }

  private static long getNum(int idx) {
    return Long.parseLong(inp.substring(idx, idx + 1));
  }
}
