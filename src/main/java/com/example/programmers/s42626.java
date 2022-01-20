package com.example.programmers;

import java.util.PriorityQueue;

public class s42626 {

  public static int solution(int[] scoville, int K) {
    int answer = 0;
    PriorityQueue<Integer> food = new PriorityQueue<>();

    for (int scov : scoville) {
      food.add(scov);
    }

    Integer first;
    Integer twice;

    while (food.peek() < K) {
      if (food.size() == 1) {
        return -1;
      }

      first = food.poll();
      twice = food.poll();
      food.add(first + twice * 2);

      answer += 1;
    }

    return answer;
  }
}
