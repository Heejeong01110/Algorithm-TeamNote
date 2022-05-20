package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class q17396 {

  private static int N; //분기점 수
  private static int M; //길의 수
  private static int[] enemyView;
  private static ArrayList<Node>[] nodes;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    output(Solution());
  }

  private static void output(long result) {
    System.out.print(result);
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    enemyView = new int[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      enemyView[i] = Integer.parseInt(st.nextToken());
    }
    enemyView[N - 1] = 0;

    nodes = new ArrayList[N];
    for (int i = 0; i < N; i++) {
      nodes[i] = new ArrayList<>();
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int one = Integer.parseInt(st.nextToken());
      int two = Integer.parseInt(st.nextToken());
      int three = Integer.parseInt(st.nextToken());
      nodes[one].add(new Node(two, three));
      nodes[two].add(new Node(one, three));
    }

    br.close();
  }

  private static long Solution() {
    long[] cost = new long[N];
    boolean[] visited = new boolean[N];
    Arrays.fill(cost, Long.MAX_VALUE);
    cost[0] = 0;

    PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.cost > o2.cost ? 1 : -1);
    queue.add(new Node(0, 0));

    while (!queue.isEmpty()) {
      Node now = queue.poll();

      if (visited[now.index]) {
        continue;
      }
      visited[now.index] = true;

      for (int i = 0; i < nodes[now.index].size(); i++) {
        Node next = nodes[now.index].get(i);

        if (enemyView[next.index] == 1) {
          continue;
        }

        if (cost[next.index] > cost[now.index] + next.cost) {
          cost[next.index] = cost[now.index] + next.cost;
          queue.add(new Node(next.index, cost[now.index] + next.cost));
        }
      }
    }

    if (cost[N - 1] == Long.MAX_VALUE) {
      return -1;
    }
    return cost[N - 1];
  }

  private static class Node {

    int index;
    long cost;

    public Node(int index, long cost) {
      this.index = index;
      this.cost = cost;
    }
  }

}
