package com.example.algorithm.BfsDfs;

import java.util.ArrayDeque;
import java.util.Queue;

public class DFS {

  private static int N;
  private static int M;
  private static boolean[][] nodes;
  private static boolean[] visited;

  public static void main(String[] args) {
    N = 6; //정점의 갯수
    M = 5; //간선의 갯수
    nodes = new boolean[][]{
        {false, false, false, false, false, false, false},
        {false, false, true, false, false, true, false},
        {false, true, false, false, false, true, false},
        {false, false, false, false, true, false, false},
        {false, false, false, true, false, false, true},
        {false, true, true, false, false, false, false},
        {false, false, false, false, true, false, false}};

    visited = new boolean[N + 1];

    for (int i = 1; i <= N; i++) {
      if (!visited[i]) {
        bfs(i);
      }
    }

  }

  private static void bfs(int start) {
    Queue<Integer> queue = new ArrayDeque<>();
    queue.add(start);
    visited[start] = true;

    while (!queue.isEmpty()) {
      Integer now = queue.poll();

      for (int i = 1; i <= N; i++) {
        if (!visited[i] && nodes[now][i]) {
          queue.add(i);
          visited[i] = true;
        }
      }
    }
  }
}
