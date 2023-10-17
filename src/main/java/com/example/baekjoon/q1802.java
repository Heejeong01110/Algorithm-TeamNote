package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1802 {

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int T = Integer.parseInt(st.nextToken());

    for (int t = 0; t < T; t++) {
      System.out.println(Solution(br.readLine()));
    }
    br.close();
  }

  private static String Solution(String inp) {
    StringBuilder sb = new StringBuilder(inp);
    while (sb.length() > 1) {
      int idx = 0;
      while (idx + 2 < sb.length()) {
        if (sb.codePointAt(idx) == sb.codePointAt(idx + 2)) {
          return "NO";
        }
        sb.replace(idx, idx + 1, "");
        idx++;
      }
      sb.replace(idx, idx + 1, "");
    }

    return "YES";
  }

}
