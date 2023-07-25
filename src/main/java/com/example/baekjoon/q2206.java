package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class q2206 {

  private static int N;
  private static int M;
  private static boolean[][] map;
  private static int[][] dir = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

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
    M = Integer.parseInt(st.nextToken());
    map = new boolean[N][M];

    for (int i = 0; i < N; i++) {
      String str = br.readLine();
      for (int j = 0; j < M; j++) {
        map[i][j] = str.charAt(j) == '0';
      }
    }

    br.close();
  }

  private static int Solution() {

    int answer = -1;
    PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
    int[][][] costs = new int[N][M][2];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        costs[i][j][0] = Integer.MAX_VALUE;
        costs[i][j][1] = Integer.MAX_VALUE;
      }
    }

    queue.add(new Node(0, 0, 1, 0));
    costs[0][0][0] = 1;

    while (!queue.isEmpty()) {
      Node now = queue.poll();

      if (now.row == N - 1 && now.col == M - 1) {
        answer = now.cost;
        break;
      }

      for (int i = 0; i < 4; i++) {
        int nr = now.row + dir[i][0];
        int nc = now.col + dir[i][1];

        if (!isPossible(nr, nc)) {
          continue;
        }
        if (map[nr][nc] && costs[nr][nc][now.wall] > now.cost + 1) {
          //1. 벽이 없을 때
          costs[nr][nc][now.wall] = now.cost + 1;
          queue.add(new Node(nr, nc, now.cost + 1, now.wall));
        } else if (!map[nr][nc] && now.wall == 0 && costs[nr][nc][now.wall + 1] > now.cost + 1) {
          //2. 벽이 있고 부술 수 있을 때
          costs[nr][nc][now.wall + 1] = now.cost + 1;
          queue.add(new Node(nr, nc, now.cost + 1, now.wall + 1));
        }

      }

    }

    return answer;
  }

  private static boolean isPossible(int row, int col) {
    return row >= 0 && row < N && col >= 0 && col < M;
  }

  private static class Node {

    int row;
    int col;
    int cost;
    int wall;

    public Node(int row, int col, int cost, int wall) {
      this.row = row;
      this.col = col;
      this.cost = cost;
      this.wall = wall;
    }
  }

}
