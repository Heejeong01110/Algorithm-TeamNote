package com.example.programmers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

//합승 택시 요금
public class s72413 {

  private static ArrayList<Node>[] nodes;

  public static int solution(int n, int s, int a, int b, int[][] fares) {
    nodes = new ArrayList[n + 1];
    for (int i = 1; i <= n; i++) {
      nodes[i] = new ArrayList<>();
    }

    for (int i = 0; i < fares.length; i++) {
      nodes[fares[i][0]].add(new Node(fares[i][1], fares[i][2]));
      nodes[fares[i][1]].add(new Node(fares[i][0], fares[i][2]));
    }

    int[] aCosts = dijkstra(a);
    int[] bCosts = dijkstra(b);
    int[] sCosts = dijkstra(s);

    int result = Integer.MAX_VALUE;
    for (int mid = 1; mid <= n; mid++) {
      result = Math.min(result, sCosts[mid] + aCosts[mid] + bCosts[mid]);
    }

    return result;
  }

  private static int[] dijkstra(int start) {
    int[] costs = new int[nodes.length];
    for (int i = 0; i < costs.length; i++) {
      costs[i] = Integer.MAX_VALUE;
    }

    PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
    queue.add(new Node(start, 0));
    costs[start] = 0;

    while (!queue.isEmpty()) {
      Node now = queue.poll();

      for (int i = 0; i < nodes[now.index].size(); i++) {
        Node next = nodes[now.index].get(i);

        if (costs[next.index] > now.cost + next.cost) {
          costs[next.index] = now.cost + next.cost;
          queue.add(new Node(next.index, now.cost + next.cost));
        }
      }
    }

    return costs;
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
