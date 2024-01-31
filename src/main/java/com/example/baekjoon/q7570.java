package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q7570 {

  private static int N;
  private static int[] inp;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    System.out.print(Solution());
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    inp = new int[N + 1];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      inp[Integer.parseInt(st.nextToken())] = i;
    }

    br.close();
  }

  private static int Solution() {

    int max = 1;
    int cnt = 0;

    for (int i = 1; i <= N; i++) {
      if (inp[i] > inp[i - 1]) {
        if (++cnt > max) {
          max = cnt;
        }
      } else {
        cnt = 1;
      }
    }

    return N - max;
  }

}
