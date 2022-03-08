package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class q13164 {

  private static int N;
  private static int K;
  private static int[] list;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    output(Solution());
  }

  private static void output(int result) {
    System.out.print(result);
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    list = new int[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      list[i] = Integer.parseInt(st.nextToken());
    }

    br.close();
  }

  private static int Solution() {
    Integer result = 0;
    PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
    for (int i = 0; i < N - 1; i++) {
      queue.add(list[i + 1] - list[i]);
      result += (list[i + 1] - list[i]);
    }

    for (int i = 0; i < K - 1; i++) {
      result -= queue.poll();
    }

    return result;
  }

}
