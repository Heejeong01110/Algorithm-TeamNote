package com.example.algorithm.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

//최소 스패닝 트리
//주어진 그래프의 모든 정점들을 연결하는 부분 그래프 중에서 그 가중치의 합이 최소인 트리
public class MST {

  //prim
  private static HashMap<Integer, ArrayList<CustomVextor>> nodes;

  //kruskal
  private static int parents[];
  private static int N;
  private static Edge[] edgeList;

  public static void main(String[] args) {
    int[][] fares = new int[][]{{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24},
        {4, 6, 50},
        {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
    int allNode = 6; //노드 갯수
    N = 6;

    runPrim(fares, allNode);
    runKruskal(fares);
  }

  private static void runKruskal(int[][] fares) {

    edgeList = new Edge[fares.length];
    parents = new int[N + 1];

    for (int i = 0; i < fares.length; i++) {
      edgeList[i] = new Edge(fares[i][0], fares[i][1], fares[i][2]);
    }

    System.out.println(kruskal());
  }

  //간선이 적을 경우 kruskal
  private static int kruskal() {
    int res = 0, cnt = 0;

    // 간선 가중치 기준 오름차순 정렬
    Arrays.sort(edgeList, (Comparator.comparingInt(o -> o.cost)));

    // 정점 초기화
    for (int i = 1; i <= N; i++) {
      parents[i] = i;
    }

    // 주어진 간선을 이어보면서
    for (Edge edge : edgeList) {
      if (union(edge.start, edge.end)) {// 부모가 다를 경우
        res += edge.cost;
        cnt++;

        if (cnt == N - 1) { //모두 이어져 있을 경우 종료
          return res;
        }
      }
    }

    return res;
  }

  private static boolean union(int a, int b) {
    int aRoot = find(a);
    int bRoot = find(b);

    if (aRoot == bRoot) {
      return false;
    }
    parents[aRoot] = bRoot;
    return true;
  }

  private static int find(int a) {
    if (a == parents[a]) {
      return a;
    }
    return parents[a] = find(parents[a]);
  }


  //간선이 많을수록 프림
  private static void runPrim(int[][] fares, int allNode) {
    nodes = new HashMap<>();
    for (int i = 1; i <= allNode; i++) {
      nodes.put(i, new ArrayList<>());
    }

    for (int i = 0; i < fares.length; i++) {
      nodes.get(fares[i][0]).add(new CustomVextor(fares[i][1], fares[i][2]));
      nodes.get(fares[i][1]).add(new CustomVextor(fares[i][0], fares[i][2]));
    }

    System.out.println(prim());
  }

  private static long prim() {

    boolean[] visited = new boolean[nodes.size() + 1];
    PriorityQueue<CustomVextor> queue = new PriorityQueue<>(
        Comparator.comparingInt(o -> o.cost));

    // 1번 노드부터 출발
    queue.add(new CustomVextor(1, 0));

    long result = 0;
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

  private static class Edge {

    int start;
    int end;
    int cost;

    public Edge(int start, int end, int cost) {
      this.start = start;
      this.end = end;
      this.cost = cost;
    }
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
