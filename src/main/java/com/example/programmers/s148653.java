package com.example.programmers;

import java.util.HashMap;
import java.util.PriorityQueue;

public class s148653 {

  public int solution(int storey) {
    int answer = 0;

    HashMap<Integer, Integer> memo = new HashMap<>();
    PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
    queue.add(new Node(storey, 0, 0));

    while (!queue.isEmpty()) {
      Node now = queue.poll();

      if (now.num == 0) {
        answer = now.cost;
        break;
      }

      int mul = (int) Math.pow(10, now.idx);
      int nowIdxNum = now.num % (mul * 10) / mul;
      queue.add(new Node(now.num - nowIdxNum * mul, now.cost + nowIdxNum, now.idx + 1));
      queue.add(
          new Node(now.num + (10 - nowIdxNum) * mul, now.cost + (10 - nowIdxNum), now.idx + 1));

    }

    return answer;
  }

  private class Node {

    int num;
    int cost;
    int idx;

    public Node(int num, int cost, int idx) {
      this.num = num;
      this.cost = cost;
      this.idx = idx;
    }
  }
}
