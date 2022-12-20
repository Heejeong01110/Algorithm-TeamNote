package com.example.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class s132266 {

  public static int[] solution(int n, int[][] roads, int[] sources, int destination) {
    int[] answer = {};
    HashMap<Integer, ArrayList<Integer>> nodes = new HashMap<>();
    for (int i = 1; i <= n; i++) {
      nodes.put(i, new ArrayList<>());
    }
    for (int[] road : roads) {
      nodes.get(road[0]).add(road[1]);
      nodes.get(road[1]).add(road[0]);
    }

    int[] dijkstra = dijkstra(nodes, n, destination);
    answer = new int[sources.length];
    for (int i = 0; i < answer.length; i++) {
      answer[i] = dijkstra[sources[i]] == Integer.MAX_VALUE ? -1 : dijkstra[sources[i]];
    }

    return answer;
  }

  private static int[] dijkstra(HashMap<Integer, ArrayList<Integer>> nodes, int size, int X) {
    int[] cost = new int[size + 1];
    Arrays.fill(cost, Integer.MAX_VALUE);
    cost[X] = 0;

    PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
    queue.add(new Node(X, 0));

    while (!queue.isEmpty()) {
      Node now = queue.poll();
      if (cost[now.index] < now.cost) {
        continue;
      }

      for (int j = 0; j < nodes.get(now.index).size(); j++) {
        Integer next = nodes.get(now.index).get(j); //커넥트 노드 선택

        if (cost[next] > now.cost + 1) {
          cost[next] = now.cost + 1;
          queue.add(new Node(next, cost[next]));
        }
      }
    }

    return cost;
  }

  private static class Node {

    int index;
    int cost;

    public Node(int index, int cost) {
      this.index = index;
      this.cost = cost;
    }
  }
}
