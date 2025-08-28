package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q1436 {

  private static int N;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    br.close();

    int num = 666;
    int count = 1;

    while (count != N) {
      num++;
      if (String.valueOf(num).contains("666")) {
        count++;
      }
    }
    System.out.println(num);
  }
}
