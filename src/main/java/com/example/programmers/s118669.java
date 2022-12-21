package com.example.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class s118669 {

  public static int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
    ArrayList<Node>[] map = new ArrayList[n + 1];
    for (int i = 0; i < map.length; i++) {
      map[i] = new ArrayList<>();
    }

    for (int[] path : paths) {
      map[path[0]].add(new Node(path[1], path[2]));
      map[path[1]].add(new Node(path[0], path[2]));
    }

    ArrayList<Integer> summitList = new ArrayList<>();
    ArrayList<Integer> gateList = new ArrayList<>();
    for (int summit : summits) {
      summitList.add(summit);
    }
    for (int gate : gates) {
      gateList.add(gate);
    }
    summitList.sort(Comparator.naturalOrder());
    return dijkstra2(map, summitList, gateList);
  }


  private static int[] dijkstra2(ArrayList<Node>[] nodes, ArrayList<Integer> summits,
      ArrayList<Integer> gates) {
    int[] answer = {-1, Integer.MAX_VALUE};
    int[] cost = new int[nodes.length];
    Arrays.fill(cost, Integer.MAX_VALUE);

    PriorityQueue<Node> queue = new PriorityQueue<>(((o1, o2) -> {
      if (o1.cost == o2.cost) {
        return o1.idx - o2.idx;
      }
      return o1.cost - o2.cost;
    }));

    for (Integer gate : gates) {
      queue.add(new Node(gate, 0));
      cost[gate] = 0;
    }

    while (!queue.isEmpty()) {
      Node now = queue.poll();

      if (cost[now.idx] < now.cost || answer[1] < now.cost) {
        continue;
      }

      if (summits.contains(now.idx)) {
        if (answer[1] > cost[now.idx]) {
          answer[0] = now.idx;
          answer[1] = cost[now.idx];
        } else if (cost[now.idx] == answer[1] && now.idx < answer[0]) {
          answer[0] = now.idx;
        }
        continue;
      }

      for (int j = 0; j < nodes[now.idx].size(); j++) {
        Node next = nodes[now.idx].get(j);

        int max = Math.max(now.cost, next.cost);
        if (cost[next.idx] > max && answer[1] >= max) {
          cost[next.idx] = max;
          queue.add(new Node(next.idx, cost[next.idx]));
        }
      }
    }

    return answer;
  }

  private static class Node {

    int idx;
    int cost;

    public Node(int idx, int cost) {
      this.idx = idx;
      this.cost = cost;
    }
  }
}
