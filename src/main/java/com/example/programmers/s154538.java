package com.example.programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class s154538 {

  public static int solution(int x, int y, int n) {
    int[] memo = new int[1_000_001];
    Arrays.fill(memo, Integer.MAX_VALUE);

    PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.cnt));
    queue.add(new Node(x, 0));

    while (!queue.isEmpty()) {
      Node now = queue.poll();

      if (now.num == y) {
        return now.cnt;
      }

      int[] list = new int[]{n, now.num, now.num * 2};
      for (int i : list) {
        if (now.num + i <= 1_000_000 && memo[now.num + i] > now.cnt + 1) {
          queue.add(new Node(now.num + i, now.cnt + 1));
          memo[now.num + i] = now.cnt + 1;
        }
      }


    }

    return -1;
  }

  static class Node {

    int num;
    int cnt;

    public Node(int num, int cnt) {
      this.num = num;
      this.cnt = cnt;
    }
  }
}
