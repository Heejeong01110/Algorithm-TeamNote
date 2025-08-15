package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class q2075 {

  private static int N;
  private static int[] inp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st;
    N = Integer.parseInt(br.readLine());
    PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        queue.add(Integer.parseInt(st.nextToken()));
      }
    }

    for (int i = 0; i < N - 1; i++) {
      queue.poll();
    }

    br.close();
    System.out.print(queue.peek());
  }
}
