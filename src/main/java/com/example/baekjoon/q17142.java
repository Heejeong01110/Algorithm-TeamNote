package com.example.baekjoon;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class q17142 {

  private static int N, M;
  private static int[][] map;
  private static ArrayList<Node> virus;
  private static int[][] directs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
  private static int emptyCnt, resultMinTime;

  public static void main(String[] args) {
    run();
  }

  public static void run() {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    M = sc.nextInt();

    map = new int[N][N];
    virus = new ArrayList<>();
    emptyCnt = 0;
    resultMinTime = Integer.MAX_VALUE;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        map[i][j] = sc.nextInt();

        if (map[i][j] == 0) {
          emptyCnt++;
        } else if (map[i][j] == 2) {
          virus.add(new Node(i, j, 0));
        }
      }
    }

    if (emptyCnt == 0) {
      System.out.print("0");
      return;
    }

    dfs(0, 0, new Node[M]);
    System.out.print(resultMinTime == Integer.MAX_VALUE ? -1 : resultMinTime);
  }

  private static void dfs(int idx, int cnt, Node[] nodes) {
    if (cnt == M) {
      getVirusCnt(nodes, emptyCnt);
      return;
    }

    for (int i = idx; i < virus.size(); i++) {
      nodes[cnt] = virus.get(i);
      dfs(i + 1, cnt + 1, nodes);
    }
  }

  private static void getVirusCnt(Node[] nodes, int empty) {
    PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
    boolean[][] visited = new boolean[N][N];

    for (Node n : nodes) {
      queue.add(new Node(n.row, n.col, 0));
      visited[n.row][n.col] = true;
    }

    while (!queue.isEmpty()) {
      Node now = queue.poll();

      for (int i = 0; i < 4; i++) {
        int nr = now.row + directs[i][0];
        int nc = now.col + directs[i][1];

        if (isPossible(nr, nc) && !visited[nr][nc] && map[nr][nc] != 1) {
          if (map[nr][nc] == 0) {
            empty--;
          }

          if (empty == 0) {
            resultMinTime = Math.min(resultMinTime, now.cost + 1);
            return;
          }

          queue.add(new Node(nr, nc, now.cost + 1));
          visited[nr][nc] = true;
        }
      }
    }
  }

  private static boolean isPossible(int row, int col) {
    return row >= 0 && row < N && col >= 0 && col < N;
  }

  private static class Node {

    int row;
    int col;
    int cost;

    public Node(int row, int col, int cost) {
      this.row = row;
      this.col = col;
      this.cost = cost;
    }
  }
}
