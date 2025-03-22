package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class q1863 {

  private static int N;
  private static int[][] inp;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    System.out.print(Solution());
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    inp = new int[N][2];

    StringTokenizer st;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      inp[i][0] = Integer.parseInt(st.nextToken());
      inp[i][1] = Integer.parseInt(st.nextToken());
    }

    br.close();
  }

  private static int Solution() {
    int answer = 0;
    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < N; i++) {
      while (!stack.isEmpty() && stack.peek() > inp[i][1]) {
        answer++;
        stack.pop();
      }
      if (!stack.isEmpty() && stack.peek() == inp[i][1]) {
        continue;
      }
      stack.push(inp[i][1]);
    }

    while (!stack.isEmpty()) {
      if (stack.peek() > 0) {
        answer++;
      }
      stack.pop();
    }
    return answer;
  }

}
