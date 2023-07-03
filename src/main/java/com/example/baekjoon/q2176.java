package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class q2176 {

  private static final int S = 1, T = 2;


  private static int N;
  private static int M;
  private static ArrayList<Node>[] map;
  private static int[] dp;
  private static boolean[] visited;

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
    M = Integer.parseInt(st.nextToken());

    map = new ArrayList[N + 1];
    for (int i = 1; i <= N; i++) {
      map[i] = new ArrayList<>();
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int o = Integer.parseInt(st.nextToken());
      int t = Integer.parseInt(st.nextToken());
      int h = Integer.parseInt(st.nextToken());

      map[o].add(new Node(t, h));
      map[t].add(new Node(o, h));
    }

    br.close();
  }

  private static int Solution() {
    dp = new int[N + 1];
    visited = new boolean[N + 1];

    visited[S] = true;
    dfs(S);

    return dp[S];
  }

  //  1 - - 4
  //  |     |
  //  3 - - 2
  private static int dfs(int now) {
    if (now == T) {
      dp[now] = 1;
    }

    if (dp[now] != 0) {
      return dp[now];
    }

    for (Node node : map[now]) {
      if (visited[node.idx]) {
        continue;
      }
      visited[node.idx] = true;
      ;
      dp[now] += dfs(node.idx);
      visited[node.idx] = false;
    }

    return dp[now];

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
