package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q1622 {

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    output(Solution());
  }

  private static void output(StringBuilder solution) {
    System.out.print(solution.toString());
  }

  private static StringBuilder Solution() throws IOException {
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String a;
    String b;

    while (true) {
      a = br.readLine();
      if (a == null) {
        break;
      }
      b = br.readLine();

      int[] A = new int['z' - 'a' + 1];
      int[] B = new int['z' - 'a' + 1];

      for (int i = 0; i < a.length(); i++) {
        A[a.charAt(i) - 'a']++;
      }
      for (int i = 0; i < b.length(); i++) {
        B[b.charAt(i) - 'a']++;
      }

      for (int i = 0; i < A.length; i++) {
        for (int j = 0; j < Math.min(A[i], B[i]); j++) {
          sb.append((char) ('a' + i));
        }
      }

      sb.append("\n");
    }

    br.close();
    return sb;
  }

}
