package com.example.programmers;

import java.util.ArrayList;

public class s86971 {

  private ArrayList<Integer>[] map;
  private int N;

  public int solution(int n, int[][] wires) {
    int answer = n;
    N = n;
    map = new ArrayList[n + 1];
    for (int i = 1; i <= n; i++) {
      map[i] = new ArrayList<>();
    }

    for (int[] wire : wires) {
      map[wire[0]].add(wire[1]);
      map[wire[1]].add(wire[0]);
    }

    for (int[] wire : wires) {
      answer = Math.min(answer, getCost(wire[0], wire[1]));
    }

    return answer;
  }

  private int getCost(int s, int e) {
    boolean[] visited = new boolean[N + 1];
    visited[s] = true;
    visited[e] = true;
    return Math.abs(2 * dfs(visited, s) - N);
  }

  private int dfs(boolean[] visited, int idx) {
    int answer = 1;
    for (int i = 0; i < map[idx].size(); i++) {
      if (!visited[map[idx].get(i)]) {
        visited[map[idx].get(i)] = true;
        answer += dfs(visited, map[idx].get(i));
      }
    }
    return answer;
  }
}
