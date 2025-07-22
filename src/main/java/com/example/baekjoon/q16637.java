package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q16637 {

  private static int N;
  private static String inp;
  private static long res;

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
      return Long.parseLong(inp);
    }
    res = Long.MIN_VALUE;
    dfs(3, calc(getNum(0), inp.charAt(1), getNum(2)), getNum(0), false);
    return res;
  }

  private static void dfs(int idx, long nowSum, long preSum, boolean tmp) {
    if (idx >= N - 1) {
      res = Math.max(res, nowSum);
      return;
    }

    long ans;
    //1. 괄호
    if (!tmp) {//이전 연산에서 괄호를 사용하지 않은 경우
      //괄호 O
      ans = calc(preSum, inp.charAt(idx - 2),
          calc(getNum(idx - 1), inp.charAt(idx), getNum(idx + 1)));
      dfs(idx + 2, ans, nowSum, true);
    }
    // 괄호 X
    ans = calc(nowSum, inp.charAt(idx), getNum(idx + 1));
    dfs(idx + 2, ans, nowSum, false);
  }

  private static long calc(long one, char operator, long two) {
    return switch (operator) {
      case '+' -> one + two;
      case '-' -> one - two;
      case '*' -> one * two;
      default -> 0L;
    };
  }

  private static long getNum(int idx) {
    return Long.parseLong(inp.substring(idx, idx + 1));
  }
}
