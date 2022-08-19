package com.example.programmers;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class s62050 {

  private static final int[][] direct = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
  private static boolean[][] visited;
  private static int[][] parts;
  private static int N;
  private static int M;

  public static int solution(int[][] land, int height) {
    visited = new boolean[land.length][land[0].length];
    parts = new int[land.length][land[0].length];
    N = land.length;
    M = land[0].length;

    //같은 지형 체크
    int count = 1;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (!visited[i][j]) {
          bfs(land, height, i, j, count);
          count++;
        }
      }
    }

    //연결 edge 목록 생성
    PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {

        if (isPossible(i, j + 1) && Math.abs(land[i][j] - land[i][j + 1]) > height) {
          Edge edge = new Edge(0, Math.abs(land[i][j] - land[i][j + 1]),
              new Node(i, j),
              new Node(i, j + 1));
          queue.add(edge);
        }
        if (isPossible(i + 1, j) && Math.abs(land[i][j] - land[i + 1][j]) > height) {
          Edge edge = new Edge(1, Math.abs(land[i][j] - land[i + 1][j]),
              new Node(i, j),
              new Node(i + 1, j));
          queue.add(edge);
        }
      }
    }
    
    int cost = 0;
    while (!queue.isEmpty()) {
      Edge now = queue.poll();

      if (parts[now.start.row][now.start.col] != parts[now.end.row][now.end.col]) {
        cost += now.cost;
        changePart(now.end.row, now.end.col, parts[now.start.row][now.start.col]);
      }

    }

    return cost;
  }

  private static void changePart(int row, int col, int changeNum) {
    int stand = parts[row][col];
    Queue<Node> queue = new ArrayDeque<>();
    queue.add(new Node(row, col));
    parts[row][col] = changeNum;

    while (!queue.isEmpty()) {
      Node now = queue.poll();

      for (int i = 0; i < 4; i++) {
        int nr = now.row + direct[i][0];
        int nc = now.col + direct[i][1];

        if (!isPossible(nr, nc) || parts[nr][nc] != stand) {
          continue;
        }
        parts[nr][nc] = changeNum;
        queue.add(new Node(nr, nc));
      }

    }
  }

  private static void bfs(int[][] land, int height, int row, int col, int count) {
    Queue<Node> queue = new ArrayDeque<>();
    queue.add(new Node(row, col));
    visited[row][col] = true;
    parts[row][col] = count;

    while (!queue.isEmpty()) {
      Node now = queue.poll();

      for (int i = 0; i < 4; i++) {
        int nr = now.row + direct[i][0];
        int nc = now.col + direct[i][1];

        if (!isPossible(nr, nc) || parts[nr][nc] == count) {
          continue;
        }

        int bet = Math.abs(land[now.row][now.col] - land[nr][nc]);
        if (bet > height) {
          continue;
        }
        visited[nr][nc] = true;
        parts[nr][nc] = count;
        queue.add(new Node(nr, nc));
      }

    }
  }

  private static boolean isPossible(int row, int col) {
    return row >= 0 && row < N && col >= 0 && col < M;
  }

  private static class Node {

    int row;
    int col;

    public Node(int row, int col) {
      this.row = row;
      this.col = col;
    }
  }

  private static class Edge {

    int dir;
    int cost;
    Node start;
    Node end;

    public Edge(int dir, int cost, Node start, Node end) {
      this.dir = dir;
      this.cost = cost;
      this.start = start;
      this.end = end;
    }
  }
}
