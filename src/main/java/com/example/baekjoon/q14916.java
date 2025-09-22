package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q14916 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    br.close();

    if (N == 1 || N == 3) {
      System.out.println(-1);
      return;
    }

    int five = N / 5;
    int rem = N % 5;

    while (five >= 0 && rem % 2 != 0) {
      five--;
      rem += 5;
    }

    if (five < 0) {
      System.out.println(-1);
    } else {
      System.out.println(five + rem / 2);
    }
  }
}
