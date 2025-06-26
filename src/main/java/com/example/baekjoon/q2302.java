package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q2302 {

  private static int N, M;
  private static int[] inp;
  private static int[] memo;

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
    M = Integer.parseInt(br.readLine());
    inp = new int[M + 2];

    for (int i = 1; i <= M; i++) {
      inp[i] = Integer.parseInt(br.readLine());
    }
    inp[0] = 0;
    inp[M + 1] = N + 1;

    br.close();
  }

  private static int Solution() {
    memo = new int[N + 2];
    memo[0] = 1;
    memo[1] = 1;
    memo[2] = 2;
    int start, end;
    int ans = 1;

    for (int i = 1; i <= M + 1; i++) {
      start = inp[i - 1] + 1;
      end = inp[i];
      ans *= getNum(end - start);
    }

    return ans;
  }

  private static int getNum(int len) {
    if (len == 0 || memo[len] != 0) {
      return memo[len];
    }
    return getNum(len - 1) + getNum(len - 2);
  }

}
