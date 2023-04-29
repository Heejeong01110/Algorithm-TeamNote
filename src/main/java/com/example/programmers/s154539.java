package com.example.programmers;

import java.util.Arrays;
import java.util.Stack;

public class s154539 {

  public int[] solution(int[] numbers) {
    int[] answer = new int[numbers.length];
    Arrays.fill(answer, -1);

    Stack<Integer> stack = new Stack<>();

    answer[numbers.length - 1] = -1;
    stack.add(numbers[numbers.length - 1]);

    for (int i = numbers.length - 2; i >= 0; i--) {
      while (true) {
        if (stack.isEmpty()) {
          answer[i] = -1;
          stack.add(numbers[i]);
          break;
        }

        if (stack.peek() <= numbers[i]) {
          stack.pop();
        } else {
          answer[i] = stack.peek();
          stack.add(numbers[i]);
          break;
        }
      }
    }

    return answer;
  }
}
