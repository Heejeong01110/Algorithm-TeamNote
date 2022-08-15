package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class q12912 {

  private static int N;
  private static ArrayList<Node>[] nodes;
  private static Edge[] edges;
  private static int dfsLen;
  private static int dfsNode;

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

    nodes = new ArrayList[N];
    edges = new Edge[N - 1];
    for (int i = 0; i < N; i++) {
      nodes[i] = new ArrayList<>();
    }

    for (int i = 0; i < N - 1; i++) {
      st = new StringTokenizer(br.readLine());
      int one = Integer.parseInt(st.nextToken());
      int two = Integer.parseInt(st.nextToken());
      int three = Integer.parseInt(st.nextToken());
      nodes[one].add(new Node(two, three));
      nodes[two].add(new Node(one, three));

      edges[i] = new Edge(one, two, three);
    }

    br.close();
  }

  private static int Solution() {
    int result = 0;

    for (int i = 0; i < N - 1; i++) {
      result = Math.max(result, calc(i));
    }

    return result;
  }

  private static int calc(int exclude) {
    int max1 = getDiameter(edges[exclude].start, exclude);
    int max2 = getDiameter(edges[exclude].end, exclude);
    return max1 + max2 + edges[exclude].cost;
  }

  private static int getDiameter(int start, int exclude) {
    dfsLen = -1;
    dfsNode = start;
    dfs(start, edges[exclude], 0, new boolean[N + 1]);

    dfsLen = -1;
    dfs(dfsNode, edges[exclude], 0, new boolean[N + 1]);

    return dfsLen;
  }

  private static void dfs(int now, Edge exclude, int len, boolean[] visited) {
    if (visited[now]) {
      return;
    }

    visited[now] = true;
    if (dfsLen < len) {
      dfsLen = len;
      dfsNode = now;
    }
    for (int i = 0; i < nodes[now].size(); i++) {
      Node next = nodes[now].get(i);

      if (exclude.cost == next.cost &&
          (exclude.start == now && exclude.end == next.index
              || exclude.end == now && exclude.start == next.index)) {
        continue;
      }
      dfs(next.index, exclude, len + next.cost, visited);
    }
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

  private static class Node {

    int index; //이어진 index
    int cost; //요금

    public Node(int index, int cost) {
      this.index = index;
      this.cost = cost;
    }
  }

}
