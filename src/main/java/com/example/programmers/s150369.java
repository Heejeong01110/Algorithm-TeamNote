package com.example.programmers;

import java.util.Stack;

public class s150369 {

  public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
    long answer = 0;
    Stack<Integer> deliveryStack = new Stack<>();
    Stack<Integer> pickStack = new Stack<>();
    for (int i = 0; i < n; i++) {
      deliveryStack.push(deliveries[i]);
      pickStack.push(pickups[i]);
    }

    int truck;
    while (!deliveryStack.isEmpty() || !pickStack.isEmpty()) {
      while (!deliveryStack.isEmpty() && deliveryStack.peek() == 0) {
        deliveryStack.pop();
      }
      while (!pickStack.isEmpty() && pickStack.peek() == 0) {
        pickStack.pop();
      }
      if (deliveryStack.isEmpty() && pickStack.isEmpty()) {
        break;
      }

      answer += Math.max(deliveryStack.size(), pickStack.size()) * 2L;
      truck = 0;
      while (!deliveryStack.isEmpty()) { //배달 박스 계산
        Integer nowDel = deliveryStack.pop();
        truck += nowDel;
        if (truck >= cap) {
          deliveryStack.push(truck - cap);
          break;
        }
      }

      truck = 0;
      while (!pickStack.isEmpty()) { //수거 박스 계산
        Integer nowPickup = pickStack.pop();
        truck += nowPickup;
        if (truck >= cap) {
          pickStack.push(truck - cap);
          break;
        }
      }
    }

    return answer;
  }
}
