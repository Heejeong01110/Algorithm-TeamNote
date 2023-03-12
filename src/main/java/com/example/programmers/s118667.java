package com.example.programmers;

import java.util.ArrayDeque;
import java.util.Queue;

public class s118667 {

  public int solution(int[] queue1, int[] queue2) {
    Queue<Integer> deque1 = new ArrayDeque<>();
    Queue<Integer> deque2 = new ArrayDeque<>();

    long sum1 = 0, sum2 = 0, sum = 0;
    for (int i = 0; i < queue1.length; i++) {
      deque1.add(queue1[i]);
      deque2.add(queue2[i]);
      sum1 += queue1[i];
      sum2 += queue2[i];
    }

    sum = sum1 + sum2;
    if (sum % 2 != 0) {
      return -1;
    }
    sum /= 2;

    int q1 = 0, q2 = 0;
    while (q1 <= queue1.length*2 && q2 <= queue1.length*2) {
      if (sum1 == sum) {
        return q1 + q2;
      }

      if (sum1 > sum) {
        sum1 -= deque1.peek();
        sum2 += deque1.peek();
        deque2.add(deque1.poll());
        q1++;
      } else {
        sum2 -= deque2.peek();
        sum1 += deque2.peek();
        deque1.add(deque2.poll());
        q2++;

      }
    }

    return -1;
  }
}
