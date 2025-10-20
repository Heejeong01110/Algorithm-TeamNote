package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q2193 {

  private static int N;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    br.close();

    long[] answer = new long[N + 1];

    answer[0] = 0;
    answer[1] = 1;

    for (int i = 2; i <= N; i++) {
      answer[i] = answer[i - 1] + answer[i - 2];
    }

    System.out.println(answer[N]);
  }

}
