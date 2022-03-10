package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q11653 {

  private static int N;
  private static StringBuilder stringBuilder;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    Solution();
    output();
  }

  private static void output() {
    System.out.print(stringBuilder.toString());
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    br.close();
  }

  private static void Solution() {
    stringBuilder = new StringBuilder();
    dfs(N, 2);

  }

  private static void dfs(int num, int start) {
    if (num == 1) {
      return;
    }

    if (num < start) {
      return;
    }

    for (int i = start; i <= num; i++) {
      if (num % i == 0) {
        stringBuilder.append(i + "\n");
        dfs(num / i, i);
        return;
      }
    }
  }

}
