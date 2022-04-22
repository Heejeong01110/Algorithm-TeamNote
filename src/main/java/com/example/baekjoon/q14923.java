package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class q14923 {

  private static final int[][] direct = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

  private static int N;
  private static int M;
  private static Node start;
  private static Node end;
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

    st = new StringTokenizer(br.readLine());
    int s1 = Integer.parseInt(st.nextToken());
    int s2 = Integer.parseInt(st.nextToken());
    start = new Node(s1, s2, 0);

    st = new StringTokenizer(br.readLine());
    s1 = Integer.parseInt(st.nextToken());
    s2 = Integer.parseInt(st.nextToken());
    end = new Node(s1, s2, 0);

    map = new int[N + 1][M + 1];

    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    br.close();
  }

  private static int Solution() {
    Queue<Node> queue = new ArrayDeque<>();
    boolean[][][] visited = new boolean[N+1][M+1][2];

    queue.add(new Node(start.row, start.col, 0));
    visited[start.row][start.col][0] = true;
    visited[start.row][start.col][1] = true;
    int count = 0;

    while (!queue.isEmpty()) {
      int size = queue.size();

      for (int s = 0; s < size; s++) {
        Node now = queue.poll();

        if (now.row == end.row && now.col == end.col) {
          return count;
        }

        for (int i = 0; i < 4; i++) {
          int nr = now.row + direct[i][0];
          int nc = now.col + direct[i][1];

          if (isPossible(nr, nc)) {
            if (map[nr][nc] == 0 && !visited[nr][nc][now.breakWall]) {
              queue.add(new Node(nr, nc, now.breakWall));
              visited[nr][nc][now.breakWall] = true;
            }

            if (!visited[nr][nc][1] && map[nr][nc] == 1 && now.breakWall == 0) {
              queue.add(new Node(nr, nc, 1));
              visited[nr][nc][1] = true;
            }
          }

        }

      }

      count++;
    }
    return -1;
  }

  private static boolean isPossible(int row, int col) {
    return row > 0 && row <= N && col > 0 && col <= M;
  }

  private static class Node {

    int row;
    int col;
    int breakWall;

    public Node(int row, int col, int breakWall) {
      this.row = row;
      this.col = col;
      this.breakWall = breakWall;
    }
  }

}
