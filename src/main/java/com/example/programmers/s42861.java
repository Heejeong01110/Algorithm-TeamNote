package com.example.programmers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class s42861 {

  private static HashMap<Integer, ArrayList<CustomVextor>> nodes;

  public static int solution(int n, int[][] costs) {
    int answer = 0;

    nodes = new HashMap<>();
    for (int i = 0; i < n; i++) {
      nodes.put(i, new ArrayList<>());
    }

    for (int i = 0; i < costs.length; i++) {
      nodes.get(costs[i][0]).add(new CustomVextor(costs[i][1], costs[i][2]));
      nodes.get(costs[i][1]).add(new CustomVextor(costs[i][0], costs[i][2]));
    }
    return prim();
  }

  private static int prim() {

    boolean[] visited = new boolean[nodes.size() + 1];
    PriorityQueue<CustomVextor> queue = new PriorityQueue<>(
        Comparator.comparingInt(o -> o.cost));

    // 1번 노드부터 출발
    queue.add(new CustomVextor(1, 0));

    int result = 0;
    int cnt = 0;
    while (!queue.isEmpty()) {

      CustomVextor now = queue.poll();
      // 이미 확인한 정점이면 pass
      if (visited[now.index]) {
        continue;
      }

      result += now.cost;
      visited[now.index] = true;
      // 모든 노드를 방문했다면 return
      if (++cnt == nodes.size()) {
        return result;
      }

      for (int i = 0; i < nodes.get(now.index).size(); i++) {
        // 연결된 노드들 중 방문하지 않은 노드 찾기
        CustomVextor next = nodes.get(now.index).get(i);
        if (visited[next.index]) {
          continue;
        }

        queue.add(next);
      }
    }

    return result;
  }

  private static class CustomVextor {

    int index; //이어진 index
    int cost; //요금

    public CustomVextor(int index, int cost) {
      this.index = index;
      this.cost = cost;
    }
  }
}
