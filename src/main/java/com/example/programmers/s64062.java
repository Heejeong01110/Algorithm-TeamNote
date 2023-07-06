package com.example.programmers;

import java.util.Stack;

//징검다리 건너기
public class s64062 {

  public static int solution(int[] stones, int k) {

    Stack<Node> stack = new Stack<>();
    stack.add(new Node(0, stones[0]));
    for (int i = 1; i < stones.length; i++) {
      int now = 0;
      while (!stack.isEmpty()) {
        if (stack.peek().idx < i - k) {
          break;
        }
        Node pre = stack.pop();
        int per = Math.min(stones[i] - now, pre.people);
        now += per;
        if (per < pre.people) {
          stack.add(new Node(pre.idx, pre.people - per));
          break;
        }
      }

      if (i < k) {
        now = stones[i];
      }
      stack.add(new Node(i, now));
    }

    int answer = 0;
    while (!stack.isEmpty()) {
      Node next = stack.pop();
      if (next.idx < stones.length - k) {
        break;
      }
      answer += next.people;
    }
    return answer;
  }

  private static class Node {

    int idx;
    int people;

    public Node(int idx, int people) {
      this.idx = idx;
      this.people = people;
    }
  }

}
