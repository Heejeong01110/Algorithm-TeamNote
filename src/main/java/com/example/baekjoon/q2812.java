package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class q2812 {

  private static int N;
  private static int M;
  private static int[] nums;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    output(Solution());
  }

  private static void output(String result) {
    System.out.print(result);
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    nums = new int[N];

    String str = br.readLine();
    for (int i = 0; i < N; i++) {
      nums[i] = Integer.parseInt(str.substring(i, i + 1));
    }

    br.close();
  }

  private static String Solution() {
    Deque<Integer> queue = new ArrayDeque<>();
    int count = 0;

    for (int i = 0; i < N; i++) {
      while (M > 0 && !queue.isEmpty() && queue.getLast() < nums[i]) {
        queue.removeLast();
        M--;
      }
      queue.addLast(nums[i]);
    }

    StringBuilder sb = new StringBuilder();
    while (queue.size() > M) {
      sb.append(queue.removeFirst());
    }

    return sb.toString();
  }
}
