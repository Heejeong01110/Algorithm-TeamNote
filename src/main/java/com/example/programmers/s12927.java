package com.example.programmers;

import java.util.PriorityQueue;

public class s12927 {

  public static long solution(int n, int[] works) {
    long answer = 0;
    PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
    for (int i = 0; i < works.length; i++) {
      queue.add(works[i]);
    }

    while (!queue.isEmpty()) {
      if (n <= 0) {
        //제곱의 합 계산
        long sum = 0;
        while (!queue.isEmpty()) {
          Integer poll = queue.poll();
          sum += (long) poll * poll;
        }
        answer = sum;
        break;
      }

      int now = queue.poll();
      //1. 마지막 work인 경우
      if (queue.isEmpty()) {
        if (now > n) {
          n = 0;
          queue.add(now - n);
        } else {
          n -= now;
        }
        continue;
      }

      int next = queue.peek();

      if (now > next) {
        if (now - next < n) {
          queue.add(next);
          n -= (now - next);
        } else {
          queue.add(now - n);
          n = 0;
        }
      } else {
        if (now > 1) {
          queue.add(now - 1);
          n -= 1;
        } else {
          n -= 1;
        }
      }

    }

    return answer;
  }
}
