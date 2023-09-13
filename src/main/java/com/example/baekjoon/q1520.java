package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class q1520 {

  private static int N;
  private static int M;
  private static int[][] map;
  private static int[][] memo;
  private static int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

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
    map = new int[N][M];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    br.close();
  }

  private static long Solution() {
    memo = new int[N][M];

    memo[0][0] = 1;
    ArrayList<Node> nodes = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        nodes.add(new Node(i, j, map[i][j]));
      }
    }

    nodes.sort((o1, o2) -> o2.height - o1.height);

    for (Node node : nodes) {
      for (int i = 0; i < 4; i++) {
        int nr = node.row + dir[i][0];
        int nc = node.col + dir[i][1];
        if (isPossible(nr, nc) && map[node.row][node.col] < map[nr][nc]) {
          memo[node.row][node.col] += memo[nr][nc];
        }
      }

      if (node.row == N - 1 && node.col == M - 1) {
        break;
      }

    }

    return memo[N - 1][M - 1];
  }


  private static boolean isPossible(int row, int col) {
    return row >= 0 && row < N && col >= 0 && col < M;
  }

  private static class Node {

    int row;
    int col;
    int height;

    public Node(int row, int col, int height) {
      this.row = row;
      this.col = col;
      this.height = height;
    }
  }

}
