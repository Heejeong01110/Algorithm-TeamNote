package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class q2638 {

  private static final int[][] direct = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
  private static int N;
  private static int M;
  private static int[][] map;

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
    map = new int[N][M];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    br.close();
  }

  private static int Solution() {
    Queue<Node> queue = new ArrayDeque<>();
    boolean[][] visited;
    int[][] counts = new int[N][M];
    int count = 0;

    while (!isEnding(counts)) {

      visited = new boolean[N][M];
      counts = new int[N][M];

      queue.add(new Node(0, 0));
      visited[0][0] = true;

      while (!queue.isEmpty()) {
        Node now = queue.poll();
        visited[now.row][now.col] = true;
        int nr, nc;

        for (int i = 0; i < 4; i++) {
          nr = now.row + direct[i][0];
          nc = now.col + direct[i][1];

          if (isPossible(nr, nc)) {
            counts[nr][nc] += 1;

            if (map[nr][nc] == 0 && !visited[nr][nc]) {
              queue.add(new Node(nr, nc));
              visited[nr][nc] = true;
            }
          }
        }
      }
      count++;
    }

    return count;
  }


  private static boolean isPossible(int row, int col) {
    return row >= 0 && row < N && col >= 0 && col < M;
  }

  private static boolean isEnding(int[][] counts) {
    boolean temp = true;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (map[i][j] == 1 && counts[i][j] >= 2) {
          map[i][j] = 0;
        } else if (map[i][j] == 1) {
          temp = false;
        }
      }
    }

    return temp;
  }

  private static class Node {

    int row;
    int col;

    public Node(int row, int col) {
      this.row = row;
      this.col = col;
    }
  }

}
