package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class q10026 {

  private static final int[][] direct = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
  private static int N;
  private static Character[][] map;
  private static boolean[][] visited;

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

    N = Integer.parseInt(br.readLine());
    map = new Character[N][N];

    for (int i = 0; i < N; i++) {
      String str = br.readLine();
      for (int j = 0; j < N; j++) {
        map[i][j] = str.charAt(j);
      }
    }

    br.close();
  }

  private static String Solution() {
    StringBuilder sb = new StringBuilder();
    visited = new boolean[N][N];

    int normal = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (visited[i][j]) {
          continue;
        }
        bfs(new Node(i,j));
        normal++;
      }
    }
    sb.append(normal).append(" ");

    normal = 0;
    visited = new boolean[N][N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (map[i][j] == 'R') {
          map[i][j] = 'G';
        }
      }
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (visited[i][j]) {
          continue;
        }
        bfs(new Node(i,j));
        normal++;
      }
    }
    sb.append(normal).append(" ");

    return sb.toString();
  }

  private static void bfs( Node start) {
    Queue<Node> queue = new ArrayDeque<>();
    queue.add(start);
    while (!queue.isEmpty()) {
      Node now = queue.poll();

      for (int i = 0; i < 4; i++) {
        int nr = now.row + direct[i][0];
        int nc = now.col + direct[i][1];

        if (isPossible(nr, nc) && !visited[nr][nc] && map[nr][nc] == map[now.row][now.col]) {
          queue.add(new Node(nr, nc));
          visited[nr][nc] = true;
        }
      }
    }
  }


  private static boolean isPossible(int nx, int ny) {
    return nx >= 0 && nx < N && ny >= 0 && ny < N;
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
