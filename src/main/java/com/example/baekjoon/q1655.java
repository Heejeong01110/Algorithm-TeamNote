package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class q1655 {

  private static int N;
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

    N = Integer.parseInt(br.readLine());
    nums = new int[N];

    for (int i = 0; i < N; i++) {
      nums[i] = Integer.parseInt(br.readLine());
    }

    br.close();
  }

  private static String Solution() {
    StringBuilder sb = new StringBuilder();

    PriorityQueue<Integer> right = new PriorityQueue<>((o1, o2) -> o1 - o2);
    PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2) -> o2 - o1);
    int count = 0;

    while (count < N) {
      if (left.size() <= right.size()) {
        left.add(nums[count]);
      } else {
        right.add(nums[count]);
      }

      if (!left.isEmpty() && !right.isEmpty()) {
        if (right.peek() < left.peek()) {
          Integer temp = right.poll();
          right.add(left.poll());
          left.add(temp);
        }
      }

      sb.append(left.peek()).append("\n");
      count++;
    }

    return sb.toString();
  }

}
