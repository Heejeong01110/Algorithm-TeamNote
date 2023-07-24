package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1027 {

  private static int N;
  private static int[] lens;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    output(Solution());
  }

  private static void output(int result) {
    System.out.print(result);
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());

    lens = new int[N + 1];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      lens[i] = Integer.parseInt(st.nextToken());
    }

    br.close();
  }

  private static int Solution() {

    int[][] map = new int[N + 1][N + 1];
    for (int i = 1; i <= N; i++) {
      double maxInc = -1_000_000_001;
      for (int j = i + 1; j <= N; j++) {
        double inc = (1.0) * (lens[j] - lens[i]) / (1.0 * (j - i));
        if (maxInc < inc) {
          maxInc = inc;
          map[i][j] += 1;
          map[j][i] += 1;
        }
      }
    }

    int res = 0;
    for (int i = 1; i <= N; i++) {
      int sum = 0;
      for (int j = 1; j <= N; j++) {
        sum += map[i][j];
      }
      res = Math.max(res, sum);
    }
    return res;
  }

}
