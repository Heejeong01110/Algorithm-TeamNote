package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q16947 {

  private static int N;
  private static ArrayList<Integer>[] nodes;
  private static boolean[] visited;
  private static boolean[] cycle;
  private static boolean isCycle;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    output(Solution());
  }

  private static void output(String result) {
    System.out.print(result);
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    nodes = new ArrayList[N + 1];
    for (int i = 1; i <= N; i++) {
      nodes[i] = new ArrayList<>();
    }

    StringTokenizer st;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int one = Integer.parseInt(st.nextToken());
      int two = Integer.parseInt(st.nextToken());
      nodes[one].add(two);
      nodes[two].add(one);
    }

    br.close();
  }

  private static String Solution() {
    cycle = new boolean[N + 1];
    //1. 순환선, 비순환선 구분
    for (int i = 1; i <= N; i++) {
      visited = new boolean[N + 1];
      isCycle = false;
      dfs(i, i, 0);
    }

    //2. 비순환선의 거리 계산
    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= N; i++) {
      if (cycle[i]) {
        sb.append("0 ");
        continue;
      }
      sb.append(bfs(i)).append(" ");
    }

    return sb.toString();
  }

  private static Integer bfs(int index) {
    visited = new boolean[N + 1];
    Queue<Node> queue = new ArrayDeque<>();

    queue.add(new Node(index, 0));
    visited[index] = true;

    while (!queue.isEmpty()) {
      Node now = queue.poll();

      if (cycle[now.index]) {
        return now.count;
      }

      for (int i = 0; i < nodes[now.index].size(); i++) {
        if (!visited[nodes[now.index].get(i)]) {
          queue.add(new Node(nodes[now.index].get(i), now.count + 1));
          visited[nodes[now.index].get(i)] = true;
        }
      }
    }

    return 0;
  }

  private static void dfs(int target, int now, int count) {
    if (target == now && count >= 2) {
      cycle[now] = true;
      isCycle = true;
      return;
    }
    visited[now] = true;

    for (int i = 0; i < nodes[now].size(); i++) {
      int next = nodes[now].get(i);

      if (!visited[next]) {
        dfs(target, next, count + 1);
      } else if (target == next && count >= 2) {
        dfs(target, next, count);
      }
      if (isCycle) {
        return;
      }

    }
  }

  private static class Node {

    int index;
    int count;

    public Node(int index, int count) {
      this.index = index;
      this.count = count;
    }
  }
}
