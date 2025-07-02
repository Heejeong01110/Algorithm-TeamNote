package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q2477 {

  private static final int[][] dir = new int[][]{{0, 0}, {0, 1}, {0, -1}, {1, 0}, {-1, 0}};
  private static int K;
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

    K = Integer.parseInt(br.readLine());
    inp = new int[6][2];

    for (int i = 0; i < 6; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      inp[i][0] = Integer.parseInt(st.nextToken());
      inp[i][1] = Integer.parseInt(st.nextToken());
    }

    br.close();
  }

  private static int Solution() {
    //1. 큰 사각형 넓이
    int[] bigLens = new int[2];
    int[] bigIndexes = new int[2];
    for (int i = 0; i < 6; i++) {
      if (i % 2 == 0) {
        if (bigLens[0] < inp[i][1]) {
          bigLens[0] = inp[i][1];
          bigIndexes[0] = i;
        }
      } else {
        if (bigLens[1] < inp[i][1]) {
          bigLens[1] = inp[i][1];
          bigIndexes[1] = i;
        }
      }
    }

    //2. 작은 사각형 넓이
    int[] smallIndexes = new int[2];
    Arrays.sort(bigIndexes);
    smallIndexes[0] = (bigIndexes[0] + 3) % 6;
    smallIndexes[1] = (bigIndexes[1] + 3) % 6;

    return (bigLens[0] * bigLens[1] - inp[smallIndexes[0]][1] * inp[smallIndexes[1]][1]) * K;
  }

}
