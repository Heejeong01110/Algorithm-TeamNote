package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class q13975 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());
    for (int t = 0; t < T; t++) {
      int K = Integer.parseInt(br.readLine());
      PriorityQueue<Long> queue = new PriorityQueue<>();

      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int i = 0; i < K; i++) {
        queue.add(Long.parseLong(st.nextToken()));
      }

      long res = 0;
      while (queue.size() >= 2) {
        Long one = queue.poll();
        Long two = queue.poll();
        res += one + two;
        queue.add(one + two);
      }
      System.out.print(res + "\n");
    }

    br.close();
  }

}
