package com.example.programmers;

import java.util.Stack;

public class s77886 {

  public static String[] solution(String[] s) {
    String[] answer = new String[s.length];
    Stack<Character> stack;
    StringBuilder sb;
    int regexCount;

    for (int i = 0; i < s.length; i++) {
      stack = new Stack<>();
      regexCount = 0;

      for (int j = 0; j < s[i].length(); j++) {
        if (stack.size() < 2) {
          stack.push(s[i].charAt(j));
        } else {
          if (s[i].charAt(j) == '0') {
            Character midReg = stack.pop();
            if (midReg.equals('1') && stack.peek().equals('1')) {
              stack.pop();
              regexCount++;
            } else {
              stack.push(midReg);
              stack.push(s[i].charAt(j));
            }
          } else {
            stack.push(s[i].charAt(j));
          }
        }
      }

      sb = new StringBuilder();
      while (!stack.isEmpty()) {
        sb.append(stack.pop());
      }
      sb.reverse();

      int idx = sb.lastIndexOf("0");
      for (int k = 0; k < regexCount; k++) {
        sb.insert(idx + 1, "110");
        idx += 3;
      }

      answer[i] = sb.toString();
    }

    return answer;
  }
}
