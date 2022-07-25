package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class q1277 {

  private static int N; //발전소 수
  private static int W; //전선 수
  private static double M; //제한 길이
  private static int[][] map;
  private static Node[] nodes;
  private static ArrayList<Integer>[] connect;

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
    W = Integer.parseInt(st.nextToken());

    M = Double.parseDouble(br.readLine());

    nodes = new Node[N + 1];
    connect = new ArrayList[N + 1];

    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      nodes[i] = new Node(x, y);
    }

    for (int i = 1; i <= N; i++) {
      connect[i] = new ArrayList<>();
    }

    for (int i = 0; i < W; i++) {
      st = new StringTokenizer(br.readLine());
      int one = Integer.parseInt(st.nextToken());
      int two = Integer.parseInt(st.nextToken());
      connect[one].add(two);
      connect[two].add(one);
    }

    br.close();
  }

  private static int Solution() {

    //1. 발전소 간 거리 구하기
    double[][] range = new double[N + 1][N + 1];
    for (int i = 1; i <= N; i++) {
      for (int j = i + 1; j <= N; j++) {
        range[i][j] = Math.sqrt(
            Math.pow(nodes[i].row - nodes[j].row, 2)
                + Math.pow(nodes[i].col - nodes[j].col, 2));
        range[j][i] = range[i][j];
      }
    }

    //2. 최소 거리 구하기
    double[] dijkstra = dijkstra(range, 1);

    return (int)Math.floor(dijkstra[N] * 1000);
  }

  private static double[] dijkstra(double[][] range, int start) {
    double[] cost = new double[N + 1];
    for (int i = 1; i < cost.length; i++) {
      cost[i] = Double.MAX_VALUE;
    }

    PriorityQueue<CNode> queue = new PriorityQueue<>(
        ((o1, o2) -> {

          if (o1.build > o2.build) {
            return 1;
          } else if (o1.build == o2.build) {
            return o2.index - o1.index;
          }
          return -1;
        })
    );

    cost[start] = 0;
    queue.add(new CNode(start, 0));

    while (!queue.isEmpty()) {
      CNode now = queue.poll();

      if (cost[now.index] < now.build) {
        continue;
      }

      for (int i = 1; i <= N; i++) {
        if (i == now.index) {
          continue;
        }

        if (connect[now.index].contains(i)) {
          if (cost[i] > now.build) {
            cost[i] = now.build;
            queue.add(new CNode(i, now.build));
          }
        } else {
          double len = range[now.index][i];
          if (cost[i] > now.build + len && len <= M) {
            cost[i] = now.build + len;
            queue.add(new CNode(i, now.build + len));
          }
        }
      }
    }

    return cost;
  }

  private static class Node {

    int row;
    int col;

    public Node(int row, int col) {
      this.row = row;
      this.col = col;
    }
  }

  private static class CNode {

    int index;
    double build;

    public CNode(int index, double build) {
      this.index = index;
      this.build = build;
    }
  }
}
