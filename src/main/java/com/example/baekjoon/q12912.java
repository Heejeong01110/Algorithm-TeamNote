package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class q12912 {

  private static int N;
  private static ArrayList<Node>[] nodes;
  private static Edge[] edges;

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
    int[] getFarNode = dijkstra(start, edges[exclude]);
    int max = Integer.MIN_VALUE;
    int maxIdx = 0;
    for (int i = 0; i < getFarNode.length; i++) {
      if (getFarNode[i] != Integer.MAX_VALUE && max < getFarNode[i]) {
        max = getFarNode[i];
        maxIdx = i;
      }
    }

    int[] diameter = dijkstra(maxIdx, edges[exclude]);
    max = Integer.MIN_VALUE;
    for (int i = 0; i < diameter.length; i++) {
      if (diameter[i] != Integer.MAX_VALUE && diameter[i] > max) {
        max = diameter[i];
      }
    }
    return max;
  }

  private static int[] dijkstra(int start, Edge exclude) {
    int[] costs = new int[N];
    PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));

    Arrays.fill(costs, Integer.MAX_VALUE);

    costs[start] = 0;
    queue.add(new Node(start, 0));

    while (!queue.isEmpty()) {
      Node now = queue.poll();

      if (costs[now.index] < now.cost) {
        continue;
      }

      for (int i = 0; i < nodes[now.index].size(); i++) {
        Node next = nodes[now.index].get(i);

        if (exclude.cost == next.cost &&
            (exclude.start == now.index && exclude.end == next.index
                || exclude.end == now.index && exclude.start == next.index)) {
          continue;
        }

        if (costs[next.index] > now.cost + next.cost) {
          costs[next.index] = now.cost + next.cost;
          queue.add(new Node(next.index, costs[next.index]));
        }
      }
    }

    return costs;
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
