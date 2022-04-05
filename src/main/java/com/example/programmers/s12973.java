package com.example.programmers;

import java.util.Stack;

//짝지어 제거하기
public class s12973 {

  public static int solution(String s) {
    Stack<Character> stack = new Stack<>();

    stack.add(s.charAt(0));
    for (int i = 1; i < s.length(); i++) {
      if (stack.isEmpty()) {
        stack.add(s.charAt(i));
      } else if (stack.peek() == s.charAt(i)) {
        stack.pop();
      } else {
        stack.add(s.charAt(i));
      }
    }
    int answer = stack.size() == 0 ? 1 : 0;
    return answer;
  }

}
