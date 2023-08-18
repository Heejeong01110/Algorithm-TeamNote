package com.example.programmers;

import java.util.Stack;

public class s131704 {

  public static int solution(int[] order) {
    Stack<Integer> stack = new Stack<>();

    int boxIdx = 1;
    int truckNowIdx = 0;

    while (truckNowIdx < order.length) {
      if (boxIdx == order[truckNowIdx]) {
        truckNowIdx++;
        boxIdx++;
        continue;
      }

      if (!stack.isEmpty() && stack.peek() == order[truckNowIdx]) {
        truckNowIdx++;
        stack.pop();
        continue;
      }


      if(boxIdx >order.length){
        break;
      }
      stack.add(boxIdx);
      boxIdx++;
    }

    return truckNowIdx;
  }
}
