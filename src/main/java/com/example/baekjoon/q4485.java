package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class q4485 {

  private static final int[][] direct = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine());
    int index = 1;
    while (N != 0) {
      int[][] map = new int[N][N];

      for (int i = 0; i < N; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < N; j++) {
          map[i][j] = Integer.parseInt(st.nextToken());
        }
      }

      int result = dijkstra(map, N);

      sb.append("Problem ").append(index).append(": ").append(result).append("\n");
      index++;
      N = Integer.parseInt(br.readLine());
    }
    System.out.print(sb.toString());
    br.close();
  }


  private static int dijkstra(int[][] map, int N) {
    int[][] cost = new int[N][N];
    PriorityQueue<Vector> minCostQueue = new PriorityQueue<>(
        Comparator.comparingInt(o -> o.cost));

    for (int i = 0; i < N; i++) {
      Arrays.fill(cost[i], Integer.MAX_VALUE);
    }

    cost[0][0] = map[0][0];
    minCostQueue.add(new Vector(new int[]{0, 0}, map[0][0]));

    while (!minCostQueue.isEmpty()) {
      Vector now = minCostQueue.poll();

      if (now.node[0] == N - 1 && now.node[1] == N - 1) {
        return cost[N - 1][N - 1];
      }

      if (cost[now.node[0]][now.node[1]] < now.cost) { //스킵
        continue;
      }

      for (int i = 0; i < 4; i++) {
        int nr = now.node[0] + direct[i][0];
        int nc = now.node[1] + direct[i][1];

        if (isPossible(nr, nc, N) && cost[nr][nc] > now.cost + map[nr][nc]) {
          cost[nr][nc] = now.cost + map[nr][nc];
          minCostQueue.add(new Vector(new int[]{nr, nc}, cost[nr][nc]));
        }
      }

    }

    return cost[N - 1][N - 1];
  }


  private static boolean isPossible(int row, int col, int N) {
    return row >= 0 && row < N && col >= 0 && col < N;
  }

  private static class Vector {

    int[] node;
    int cost;

    public Vector(int[] node, int cost) {
      this.node = node;
      this.cost = cost;
    }
  }

}
