package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class q14442 {

  private static final int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
  private static int N;
  private static int M;
  private static int K;
  private static int[][] ary;

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
    K = Integer.parseInt(st.nextToken());
    ary = new int[N][M];

    String str;
    for (int i = 0; i < N; i++) {
      str = br.readLine();
      for (int j = 0; j < M; j++) {
        ary[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
      }
    }

    br.close();
  }

  private static int Solution() {
    boolean[][][] visited = new boolean[N][M][K + 1];
    Queue<Node> queue = new ArrayDeque<>();
    queue.add(new Node(0, 0, 0));
    visited[0][0][0] = true;
    int count = 1;

    while (!queue.isEmpty()) {
      int size = queue.size();

      for (int i = 0; i < size; i++) {
        Node now = queue.poll();

        if (now.row == N - 1 && now.col == M - 1) {
          return count;
        } else if (count > N * M) {
          return -1;
        }
        for (int[] direct : dir) {
          int mr = now.row + direct[0];
          int mc = now.col + direct[1];

          if (!isPossible(mr, mc)) {
            continue;
          }

          if (ary[mr][mc] == 0 && !visited[mr][mc][now.breakCount]) {
            queue.add(new Node(mr, mc, now.breakCount));
            visited[mr][mc][now.breakCount] = true;
          } else if (now.breakCount < K && !visited[mr][mc][now.breakCount + 1]) {
            queue.add(new Node(mr, mc, now.breakCount + 1));
            visited[mr][mc][now.breakCount + 1] = true;
          }

        }
      }

      count++;

    }

    return -1;
  }

  private static boolean isPossible(int row, int col) {
    return row >= 0 && row < N && col >= 0 && col < M;
  }

  private static class Node {

    int row;
    int col;
    int breakCount;

    public Node(int row, int col, int breakCount) {
      this.row = row;
      this.col = col;
      this.breakCount = breakCount;
    }
  }

}
