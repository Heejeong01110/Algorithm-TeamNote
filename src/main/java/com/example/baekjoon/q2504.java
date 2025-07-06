package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class q2504 {

  private static String inp;
  private static HashMap<Character, Integer> map;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    System.out.print(Solution());
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    inp = br.readLine();
    br.close();
  }

  private static int Solution() {
    map = new HashMap<>();
    map.put('(', -2);
    map.put('[', -3);
    map.put(')', -2);
    map.put(']', -3);

    return calc();
  }


  private static int calc() {
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < inp.length(); i++) {
      char now = inp.charAt(i);
      if (isStartValue(now)) {
        stack.push(map.get(now));
        continue;
      }
      if (stack.isEmpty()) {
        return 0;
      }

      int base = (now == ')') ? 2 : 3;
      int open = (now == ')') ? -2 : -3;
      int sum = 0;

      while (!stack.isEmpty()) {
        int top = stack.pop();

        if (top > 0) {
          sum += top;
        } else if (top == open) {
          stack.push(sum == 0 ? base : base * sum);
          break;
        } else {
          return 0;
        }
      }

      if (stack.isEmpty() && inp.charAt(0) != now) {
        return 0;
      }
    }

    int result = 0;
    for (int val : stack) {
      if (val < 0) {
        return 0; // 남아있는 괄호 오류
      }
      result += val;
    }
    return result;
  }

  private static boolean isStartValue(char c) {
    return c == '(' || c == '[';
  }


}
