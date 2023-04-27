package com.example.programmers;

import java.util.Comparator;
import java.util.PriorityQueue;

public class s142085 {

  public int solution(int n, int k, int[] enemy) {
    int answer = enemy.length;

    PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o));

    for (int i = 0; i < enemy.length; i++) {
      if (queue.size() < k) {
        queue.add(enemy[i]);
      } else {
        queue.add(enemy[i]);
        Integer now = queue.poll();

        if (n >= now) {
          n -= now;
        } else {
          answer = i;
          break;
        }
      }
    }

    return answer;
  }
}
