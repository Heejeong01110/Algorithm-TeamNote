package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class q13701 {

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
    ArrayList<Integer> ary = new ArrayList<>();
    int now;
    int[] bitmap = new int[(1 << 20) + 2];

    while (st.hasMoreTokens()) {
      now = Integer.parseInt(st.nextToken());
      int idx = now / 32;
      int sub = now % 32;
      if ((bitmap[idx] &  (1 << sub)) == 0) {
        bitmap[idx] = bitmap[idx] + (1 << sub);
        sb.append(now + " ");
      }
    }

    System.out.print(sb.substring(0, sb.length() - 1));
    br.close();
  }

}
