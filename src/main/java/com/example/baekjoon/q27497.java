package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class q27497 {

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    System.out.print(Solution());
  }

  private static String Solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    Deque<Character> deque = new ArrayDeque<>();
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < N; i++) {
      String s = br.readLine();
      char type = s.charAt(0);
      if (type == '1') {
        deque.addLast(s.charAt(2));
        stack.add(1);
      } else if (type == '2') {
        deque.addFirst(s.charAt(2));
        stack.add(0);
      } else if (!stack.isEmpty()) {
        Integer pop = stack.pop();
        if (pop == 1) {
          deque.pollLast();
        } else {
          deque.pollFirst();
        }
      }
    }
    if (deque.isEmpty()) {
      return "0";
    }

    StringBuilder sb = new StringBuilder();
    while (!deque.isEmpty()) {
      sb.append(deque.pollFirst());
    }
    br.close();
    return sb.toString();
  }

}
