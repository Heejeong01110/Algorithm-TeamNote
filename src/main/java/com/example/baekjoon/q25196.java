package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q25196 {

  private static int[][] inp;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    System.out.print(Solution());
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st;
    inp = new int[3][3];

    for (int i = 0; i < 3; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 3; j++) {
        inp[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    br.close();
  }

  private static long Solution() {

    long[][] memo = new long[3][2];
    for (int i = 0; i < memo.length; i++) {
      memo[i][0] = inp[i][1];
      memo[i][1] = inp[i][2];
    }

    long len = ((long) inp[0][0]) * inp[1][0] * inp[2][0];
    while (memo[0][1] <= len && memo[1][1] <= len && memo[2][1] <= len) {
      long s = Math.max(memo[0][0], Math.max(memo[1][0], memo[2][0]));
      long e = Math.min(memo[0][1], Math.min(memo[1][1], memo[2][1]));
      if (s <= e) {
        return s;
      }

      if (memo[0][1] <= memo[1][1] && memo[0][1] <= memo[2][1]) {
        memo[0][0] += inp[0][0];
        memo[0][1] += inp[0][0];
      } else if (memo[1][1] <= memo[0][1] && memo[1][1] <= memo[2][1]) {
        memo[1][0] += inp[1][0];
        memo[1][1] += inp[1][0];
      } else {
        memo[2][0] += inp[2][0];
        memo[2][1] += inp[2][0];
      }
    }
    return -1;
  }


}
