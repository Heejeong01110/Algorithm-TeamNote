package com.example.programmers;

import java.util.ArrayList;

public class s92343 {

  private static int result;

  public static int solution(int[] info, int[][] edges) {
    int answer = 0;
    result = Integer.MIN_VALUE;

    Node[] nodes = new Node[info.length];
    for (int i = 0; i < info.length; i++) {
      nodes[i] = new Node(i, info[i], -1, new ArrayList<>());
    }

    for (int i = 0; i < edges.length; i++) {
      nodes[edges[i][0]].children.add(edges[i][1]);
      nodes[edges[i][1]].parent = edges[i][0];
    }
    boolean[] visited = new boolean[info.length];
    visited[0] = true;

    boolean[] isNear = new boolean[info.length];
    for (int j = 0; j < nodes[0].children.size(); j++) {
      isNear[nodes[0].children.get(j)] = true;
    }

    dfs(nodes, 0, visited, nodes[0].type == 0 ? 1 : 0, nodes[0].type == 1 ? 1 : 0, isNear);

    return result;
  }

  private static void dfs(Node[] nodes, int now, boolean[] visited, int sheeps, int wolfs,
      boolean[] isNear) {
    if (sheeps <= wolfs) {
      return;
    }

    result = Math.max(result, sheeps);

    for (int i = 0; i < isNear.length; i++) {
      int next = i;
      if (next == now || visited[next] || !isNear[i]) {
        continue;
      }

      for (int j = 0; j < nodes[next].children.size(); j++) {
        isNear[nodes[next].children.get(j)] = true;
      }
      visited[next] = true;

      dfs(nodes, next, visited, nodes[next].type == 0 ? sheeps + 1 : sheeps,
          nodes[next].type == 1 ? wolfs + 1 : wolfs, isNear);

      visited[next] = false;
      for (int j = 0; j < nodes[next].children.size(); j++) {
        isNear[nodes[next].children.get(j)] = false;
      }

    }


  }

  private static class Node {

    int index;
    int type;
    int parent;
    ArrayList<Integer> children;

    public Node(int index, int type, int parent, ArrayList<Integer> children) {
      this.index = index;
      this.type = type;
      this.parent = parent;
      this.children = children;
    }

  }
}
