package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class q6086 {

  private static final int INF = 987654321;
  private static final int V = 52;
  private static int n;
  private static int[][] flow, capacity;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    System.out.print(Solution());
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    flow = new int[V][V];
    capacity = new int[V][V];

    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = atoi(st.nextToken().charAt(0));
      int b = atoi(st.nextToken().charAt(0));
      int cost = Integer.parseInt(st.nextToken());

      capacity[a][b] += cost;
      capacity[b][a] += cost;
    }

    br.close();
  }

  private static int Solution() {
    int src = 0;
    int sink = 25;
    int totalFlow = 0;
    int[] parent = new int[V];
    Queue<Integer> queue;
    while (true) {
      Arrays.fill(parent, -1);
      queue = new ArrayDeque<>();

      parent[src] = src;
      queue.add(src);

      while (!queue.isEmpty() && parent[sink] == -1) {
        int cur = queue.poll();
        for (int next = 0; next < V; next++) {
          // 잔여 용량이 남아 있는 간선을 따라 탐색한다.
          if (capacity[cur][next] - flow[cur][next] > 0 && parent[next] == -1) {
            queue.add(next);
            parent[next] = cur;
          }
        }
      }

      // 더이상 증가 경로가 없으면 종료
      if (parent[sink] == -1) {
        break;
      }

      // 증가 경로를 통해 유량을 얼마나 보낼지 결정한다.
      int amount = Integer.MAX_VALUE;
      for (int i = sink; i != src; i = parent[i]) {
        amount = Math.min(capacity[parent[i]][i] - flow[parent[i]][i], amount);
      }

      // 증가 경로를 통해 유량을 보낸다.
      for (int i = sink; i != src; i = parent[i]) {
        flow[parent[i]][i] += amount;
        flow[i][parent[i]] -= amount;
      }

      totalFlow += amount;
    }
    return totalFlow;
  }


  private static int atoi(char c) {
    if ('A' <= c && c <= 'Z') {
      return c - 'A';
    } else if ('a' <= c && c <= 'z') {
      return c - 'A' - 6;
    }
    return -1;
  }
}
