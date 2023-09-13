package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class q16639 {

  private static int[][] max, min;
  private static int N;
  private static String fx;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    Solution();
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    fx = br.readLine();
    br.close();
  }

  private static void Solution() {
    max = new int[N][N];
    min = new int[N][N];

    for (int i = 0; i < N; i++) {
      Arrays.fill(max[i], Integer.MIN_VALUE);
      Arrays.fill(min[i], Integer.MAX_VALUE);
    }

    for (int i = 0; i < N; i++) {
      if (Character.isDigit(fx.charAt(i))) {
        max[i][i] = min[i][i] = fx.charAt(i) - '0';
      }
    }

    for (int j = 2; j < N; j += 2) {
      for (int i = 0; i < N - j; i += 2) {
        for (int k = 2; k <= j; k += 2) {
          int[] tmp = new int[4];
          tmp[0] = calc(min[i][i + k - 2], fx.charAt(i + k - 1), min[i + k][i + j]);
          tmp[1] = calc(min[i][i + k - 2], fx.charAt(i + k - 1), max[i + k][i + j]);
          tmp[2] = calc(max[i][i + k - 2], fx.charAt(i + k - 1), min[i + k][i + j]);
          tmp[3] = calc(max[i][i + k - 2], fx.charAt(i + k - 1), max[i + k][i + j]);

          Arrays.sort(tmp);

          min[i][i + j] = Math.min(min[i][i + j], tmp[0]);
          max[i][i + j] = Math.max(max[i][i + j], tmp[3]);
        }
      }
    }

    System.out.print(max[0][N - 1]);
  }


  public static int calc(int num1, char formula, int num2) {
    switch (formula) {
      case '+':
        return num1 + num2;
      case '-':
        return num1 - num2;
      case '*':
        return num1 * num2;
    }
    return 0;
  }

}
