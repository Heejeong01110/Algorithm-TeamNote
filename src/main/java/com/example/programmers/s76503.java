package com.example.programmers;

import java.util.ArrayList;
import java.util.List;

public class s76503 {

  private static List<Integer>[] nodes;
  private static long[] costs;
  private static long answer;
  private static boolean[] visited;


  public static long solution(int[] a, int[][] edges) {
    nodes = new ArrayList[a.length];
    costs = new long[a.length];
    visited = new boolean[a.length];
    answer = 0;
    long sum = 0;

    for (int i = 0; i < a.length; i++) {
      nodes[i] = new ArrayList<>();
      costs[i] = a[i];
      sum += a[i];
    }

    if (sum != 0) {
      return -1;
    }

    for (int[] edge : edges) {
      nodes[edge[0]].add(edge[1]);
      nodes[edge[1]].add(edge[0]);
    }

    dfs(0);

    return answer;
  }

  private static long dfs(Integer now) {

    visited[now] = true;

    for (Integer near : nodes[now]) {
      if (visited[near]) {
        continue;
      }
      costs[now] += dfs(near);
    }
    answer += Math.abs(costs[now]);
    return costs[now];
  }
}
