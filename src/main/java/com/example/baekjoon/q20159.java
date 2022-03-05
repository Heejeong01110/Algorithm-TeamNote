package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q20159 {

  private static int N;
  private static int[] cards;

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
    cards = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      cards[i] = Integer.parseInt(st.nextToken());
    }

    br.close();
  }

  private static int Solution() {
    int[][] cardSum = new int[N + 1][2];
    cardSum[0][0] = 0;
    cardSum[0][1] = 0;
    cardSum[1][0] = cards[0];
    cardSum[1][1] = cards[1];
    for (int i = 2; i <= N / 2; i++) {
      cardSum[i][0] = cardSum[i - 1][0] + cards[i * 2 - 2];
      cardSum[i][1] = cardSum[i - 1][1] + cards[i * 2 - 1];
    }

    int[] result = new int[N + 1];
    int maxRes = 0;
    for (int i = 1; i <= N; i++) {
      if (i % 2 == 0) {
        result[i] = cardSum[(i + 1) / 2][0] + (cardSum[(N / 2) - 1][1] - cardSum[(i - 1) / 2][1]);
      } else {
        result[i] = cardSum[(i + 1) / 2 - 1][0] + cards[N - 1] + (cardSum[(N / 2) - 1][1] - cardSum[(i - 1) / 2][1]);
      }
      maxRes = Math.max(maxRes, result[i]);
    }

    return maxRes;
  }

}
