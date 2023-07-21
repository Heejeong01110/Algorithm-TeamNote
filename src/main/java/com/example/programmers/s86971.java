package com.example.programmers;

import java.util.ArrayList;

public class s86971 {

  private ArrayList<Integer>[] map;
  private int N, answer;
  private boolean[] visited;

  public int solution(int n, int[][] wires) {
    answer = n;
    N = n;
    visited = new boolean[n + 1];
    map = new ArrayList[n + 1];
    for (int i = 1; i <= n; i++) {
      map[i] = new ArrayList<>();
    }

    for (int[] wire : wires) {
      map[wire[0]].add(wire[1]);
      map[wire[1]].add(wire[0]);
    }
    dfs(1);

    return answer;
  }

  private int dfs(int idx) {
    int sum = 1;
    visited[idx] = true;

    for (int i = 0; i < map[idx].size(); i++) {
      if (!visited[map[idx].get(i)]) {
        visited[map[idx].get(i)] = true;
        sum += dfs(map[idx].get(i));
      }
    }

    answer = Math.min(answer, Math.abs(2 * sum - N));
    return sum;
  }

}
