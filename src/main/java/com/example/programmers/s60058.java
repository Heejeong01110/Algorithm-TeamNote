package com.example.programmers;

import java.util.Stack;

//괄호 변환
public class s60058 {

  public static String solution(String p) {
    String answer = "";
    if (p.isBlank()) {
      return p;
    }

    answer = dfs(p);

    return answer;
  }

  private static String dfs(String p) {
    if (p.length() == 0) {
      return p;
    }
    String answer = "";
    Stack<Character> stack = new Stack<>();
    stack.push(p.charAt(0));

    int index = 1;
    for (int i = 1; i < p.length(); i++) {
      if (stack.isEmpty()) {
        break;
      }

      index++;
      if (stack.peek() == p.charAt(i)) {
        stack.push(p.charAt(i));
      } else {
        stack.pop();
      }
    }

    String u = p.substring(0, index);
    String v = p.substring(index);

    if (check(u)) {
      answer = u + dfs(v);
    } else {
      answer = "(" + dfs(v) + ")" + change(u);
    }

    return answer;
  }

  private static String change(String u) {
    String subS = "";
    for (int i = 1; i < u.length() - 1; i++) {
      subS += u.charAt(i) == ')' ? '(' : ')';
    }
    return subS;
  }

  private static boolean check(String str) {
    if (str.charAt(0) != '(') {
      return false;
    }

    return true;
  }
}
