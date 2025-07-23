package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q12904 {

  private static String S, T;
  private static boolean ans;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    System.out.print(Solution());
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    S = br.readLine();
    T = br.readLine();
    br.close();
  }

  private static int Solution() {
    StringBuilder sb = new StringBuilder(T);
    while (sb.toString().length() != S.length()) {
      if (sb.charAt(sb.toString().length() - 1) == 'A') {
        sb.delete(sb.length() - 1, sb.length());
      } else {
        sb.delete(sb.length() - 1, sb.length()).reverse();
      }
    }
    if (sb.toString().equals(S)) {
      return 1;
    }
    return 0;
  }
}
