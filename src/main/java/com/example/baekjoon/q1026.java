package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class q1026 {

  private static int N;
  private static Integer[] A, B;

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
    N = Integer.parseInt(br.readLine());
    A = new Integer[N];
    B = new Integer[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      B[i] = Integer.parseInt(st.nextToken());
    }

    br.close();
  }

  private static int Solution() {
    Arrays.sort(A);
    Arrays.sort(B, Comparator.reverseOrder());

    int sum = 0;
    for (int i = 0; i < N; i++) {
      sum += (A[i] * B[i]);
    }

    return sum;
  }

}
