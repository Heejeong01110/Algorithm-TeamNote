package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q2230 {

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

    for (int i = 0; i < N; i++) {
      inp[i] = Integer.parseInt(br.readLine());
    }

    br.close();
  }

  private static int Solution() {

    return 0;
  }

}
