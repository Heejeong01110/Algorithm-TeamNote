package com.example.programmers.exam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class ss2 {

  public static int solution(int[][] relationships, int target, int limit) {
    int reward = 0;
    int newFriends = 0;

    HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    for (int[] rel : relationships) {
      ArrayList<Integer> one = map.getOrDefault(rel[0], new ArrayList<>());
      if(!one.contains(rel[1])){
        one.add(rel[1]);
      }
      ArrayList<Integer> two = map.getOrDefault(rel[1], new ArrayList<>());
      if(!two.contains(rel[0])){
        two.add(rel[0]);
      }
      map.put(rel[0],one);
      map.put(rel[1],two);
    }

    PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.depth - o2.depth);
    boolean[] visited = new boolean[101];

    queue.add(new Node(target, 0));
    visited[target] = true;

    while (!queue.isEmpty()) {
      Node now = queue.poll();
      if (now.depth >= limit) {
        break;
      }

      for (int next : map.get(now.idx)) {
        if (!visited[next]) {
          visited[next] = true;
          queue.add(new Node(next, now.depth + 1));
          reward += now.depth == 0 ? 5 : 10;
          newFriends += now.depth == 0 ? 0 : 1;
        }
      }
    }

    return reward + newFriends;
  }

  private static class Node {

    int idx;
    int depth;

    public Node(int idx, int depth) {
      this.idx = idx;
      this.depth = depth;
    }
  }
}
