package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q2805 {

  private static int N, M;
  private static int[] inp;

  public static void main(String[] args) throws IOException {
    inputData();
    System.out.print(Solution());
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    inp = new int[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      inp[i] = Integer.parseInt(st.nextToken());
    }

    br.close();
  }

  private static long Solution() {
    Arrays.sort(inp);
    long start = 0, end = inp[N - 1], res = 0;

    while (start <= end) {
      long mid = (start + end) / 2;
      long cal = calc(mid);
      if (cal < M) {
        end = mid - 1;
      } else {
        start = mid + 1;
        res = mid;
      }
    }
    return res;
  }

  private static long calc(long height) {
    long sum = 0;
    for (int h : inp) {
      if (h > height) {
        sum += (h - height);
      }
    }
    return sum;
  }

}
