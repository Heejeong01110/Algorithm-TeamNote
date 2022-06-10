package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class q1719 {

  private static int N;
  private static int M;
  private static ArrayList<Node>[] nodes;

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

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    nodes = new ArrayList[N + 1];

    for (int i = 1; i <= N; i++) {
      nodes[i] = new ArrayList<>();
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int one = Integer.parseInt(st.nextToken());
      int two = Integer.parseInt(st.nextToken());
      int three = Integer.parseInt(st.nextToken());
      nodes[one].add(new Node(two, three, -1));
      nodes[two].add(new Node(one, three, -1));
    }

    br.close();
  }

  private static String Solution() {
    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= N; i++) {
      int[] dijkstra = dijkstra(nodes, i);

      for (int j = 1; j < dijkstra.length; j++) {
        if (i == j) {
          sb.append("- ");
        } else {
          sb.append(dijkstra[j] + " ");
        }
      }
      sb.append("\n");
    }
    return sb.toString();
  }

  private static int[] dijkstra(ArrayList<Node>[] nodes, int start) {
    int[] cost = new int[nodes.length];
    int[] memo = new int[nodes.length];

    PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));

    for (int i = 0; i < cost.length; i++) {
      cost[i] = Integer.MAX_VALUE;
    }

    cost[start] = 0;
    queue.add(new Node(start, 0, -1));

    while (!queue.isEmpty()) {
      //1. 최소 비용의 노드 선택
      Node now = queue.poll();

      if (cost[now.index] < now.cost) { //스킵
        continue;
      }

      memo[now.index] = now.firstVisit;

      //2. 기준점 이웃 노드 중 최소값 구하기
      for (int j = 0; j < nodes[now.index].size(); j++) {
        Node next = nodes[now.index].get(j); //커넥트 노드 선택

        if (cost[next.index] > now.cost + next.cost) {
          cost[next.index] = now.cost + next.cost;

          // 갱신된 경우에만 큐에 넣는다.
          if (now.firstVisit == -1) {
            queue.add(new Node(next.index, cost[next.index], next.index));
          } else {
            queue.add(new Node(next.index, cost[next.index], now.firstVisit));
          }
        }
      }
    }

    return memo;
  }

  private static class Node {

    int index;
    int cost;
    int firstVisit;

    public Node(int index, int cost, int firstVisit) {
      this.index = index;
      this.cost = cost;
      this.firstVisit = firstVisit;
    }
  }

}
