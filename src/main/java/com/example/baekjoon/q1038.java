package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q1038 {

  private static int N;
  private static long[] memo;

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
    memo = new long[1024];
    br.close();
  }

  private static long Solution() {
    if (N < 10) {
      return N;
    }

    for (int a = 0; a <= 9; a++) {
      memo[a] = a;
    }

    int start = 0;
    int end = 10;
    while (end <= N) {
      int cnt = 0;

      for (int i = start; i < end; i++) {
        for (int j = 0; j <= 9; j++) {
          if (memo[i] % 10 <= j) {
            break;
          }
          long num = memo[i] * 10 + j;
          memo[end + cnt] = num;
          if (end + cnt == N) {
            return memo[end + cnt];
          }
          cnt++;
        }
      }
      if (cnt == 0) {
        return -1;
      }
      start = end + 1;
      end += cnt;
    }

    return -1;
  }

}
