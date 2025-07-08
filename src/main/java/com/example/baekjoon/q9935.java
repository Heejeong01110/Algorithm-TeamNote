package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class q9935 {

  private static String raw, bomb;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    System.out.print(Solution());
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    raw = br.readLine();
    bomb = br.readLine();
    br.close();
  }

  private static String Solution() {
    Stack<Character> stack = new Stack<>();
    Stack<Character> temp;
    for (int i = 0; i < raw.length(); i++) {
      char c = raw.charAt(i);
      stack.add(c);
      if (c == bomb.charAt(bomb.length() - 1) && stack.size() >= bomb.length()) {
        //문자열이 일치하는지 확인
        temp = new Stack<>();
        for (int j = bomb.length() - 1; j >= 0; j--) {
          if (stack.peek() == bomb.charAt(j)) {
            temp.add(stack.pop());
          } else {
            break;
          }
        }
        if (temp.size() != bomb.length()) {
          while (!temp.isEmpty()) {
            stack.add(temp.pop());
          }
        }
      }
    }
    if (stack.isEmpty()) {
      return "FRULA";
    }
    StringBuilder sb = new StringBuilder();
    for (Character c : stack) {
      sb.append(c);
    }
    return sb.toString();
  }

}
