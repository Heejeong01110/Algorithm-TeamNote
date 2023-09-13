package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class q1939 {

  private static int N, M, start, end, res;
  private static ArrayList<Node>[] map;
  private static int[] costs;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
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
      int one = Integer.parseInt(st.nextToken());
      int two = Integer.parseInt(st.nextToken());
      int thr = Integer.parseInt(st.nextToken());

      map[one].add(new Node(two, thr));
      map[two].add(new Node(one, thr));
    }

    st = new StringTokenizer(br.readLine());
    start = Integer.parseInt(st.nextToken());
    end = Integer.parseInt(st.nextToken());

    br.close();
    Solution();
  }

  private static void Solution() {
    res = 0;
    costs = new int[N + 1];

    PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o2.cost - o1.cost);
    queue.add(new Node(start, Integer.MAX_VALUE));


    while (!queue.isEmpty()) {
      Node now = queue.poll();

      if (now.idx == end) {
        break;
      }

      for (Node node : map[now.idx]) {
        int s = Math.min(now.cost, node.cost);
        if (costs[node.idx] < s) {
          costs[node.idx] = s;
          queue.add(new Node(node.idx, s));
        }
      }
    }

    System.out.print(costs[end]);
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
