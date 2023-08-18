package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class q17182 {

  private static int N, K, ans;
  private static int[][] moves, costMap;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    output(Solution());
  }

  private static void output(int result) {
    System.out.print(result);
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    moves = new int[N][N];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        moves[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    br.close();
  }

  private static int Solution() {
    costMap = new int[N][N];
    for (int i = 0; i < N; i++) {
      costMap[i] = dijkstra(i);
    }

    boolean[] visited = new boolean[N];
    visited[K] = true;
    ans = Integer.MAX_VALUE;
    dfs(1, K, visited, 0);
    return ans;
  }

  private static int[] dijkstra(int start) {
    PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
    int[] cost = new int[N];
    Arrays.fill(cost, Integer.MAX_VALUE);

    queue.add(new Node(start, 0));
    cost[start] = 0;

    while (!queue.isEmpty()) {
      Node now = queue.poll();

      for (int i = 0; i < N; i++) {
        if (now.idx != i && cost[i] > now.cost + moves[now.idx][i]) {
          cost[i] = now.cost + moves[now.idx][i];
          queue.add(new Node(i, cost[i]));
        }
      }
    }
    return cost;
  }

  private static void dfs(int depth, int now, boolean[] visited, int cost) {
    if (cost > ans) {
      return;
    }
    if (depth == N) {
      ans = cost;
      return;
    }

    for (int i = 0; i < N; i++) {
      if (!visited[i]) {
        visited[i] = true;
        dfs(depth + 1, i, visited, cost + costMap[now][i]);
        visited[i] = false;
      }
    }
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
