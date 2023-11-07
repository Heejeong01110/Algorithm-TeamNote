package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q2473 {

  private static int N;
  private static long[] inp;

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
    inp = new long[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      inp[i] = Long.parseLong(st.nextToken());
    }

    br.close();
  }

  private static void Solution() {
    Arrays.sort(inp);
    long answer = 3_000_000_001L;
    int[] list = new int[3];

    for (int i = 0; i < N - 2; i++) {
      int left = i + 1;
      int right = N - 1;

      while (left < right) {
        long sum = inp[i] + inp[left] + inp[right];
        if (Math.abs(sum) < answer) {
          answer = Math.abs(sum);
          list[0] = i;
          list[1] = left;
          list[2] = right;
        }

        if (sum < 0) {
          left += 1;
        } else {
          right -= 1;
        }
      }
    }

    for (int i = 0; i < 3; i++) {
      System.out.print(inp[list[i]] + " ");
    }
  }

}
