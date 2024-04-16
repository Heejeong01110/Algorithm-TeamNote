package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class q20926 {

  private static int W, H;
  private static char[][] map;
  private static int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    System.out.print(Solution());
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    W = Integer.parseInt(st.nextToken());
    H = Integer.parseInt(st.nextToken());

    map = new char[H][W];

    for (int i = 0; i < H; i++) {
      String str = br.readLine();
      map[i] = str.toCharArray();
    }

    br.close();
  }

  private static int Solution() {

    PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.value));
    int[][] visited = new int[H][W];

    Node tera = new Node(-1, -1, 0);
    Node end = new Node(-1, -1, 0);

    for (int i = 0; i < H; i++) {
      for (int j = 0; j < W; j++) {
        visited[i][j] = Integer.MAX_VALUE;
        if (map[i][j] == 'T') {
          tera = new Node(i, j, 0);
        }
        if (map[i][j] == 'E') {
          end = new Node(i, j, 0);
        }

      }
    }

    queue.add(new Node(tera.row, tera.col, 0));
    visited[tera.row][tera.col] = 0;

    while (!queue.isEmpty()) {
      Node now = queue.poll();

      if (now.row == end.row && now.col == end.col) {
        return visited[now.row][now.col];
      }

      for (int d = 0; d < dir.length; d++) {
        Node next = getNext(now, d);
        if (next.row == -1 || now.row == next.row && now.col == next.col) { //이동하지 않은 경우
          continue;
        }

        if (visited[next.row][next.col] > next.value) {
          queue.add(new Node(next.row, next.col, next.value));
          visited[next.row][next.col] = next.value;
        }
      }
    }

    return -1;
  }

  private static Node getNext(Node now, int d) {
    int nr = now.row + dir[d][0];
    int nc = now.col + dir[d][1];
    Node next = new Node(nr, nc, now.value);

    while (true) {
      if (!isPossible(next.row, next.col) || map[next.row][next.col] == 'H') { //절벽 혹은 구멍
        next.row = -1;
        break;
      }

      if (map[next.row][next.col] == 'E') { //출구
        break;
      }

      if (map[next.row][next.col] == 'R') { //바위
        next.row -= dir[d][0];
        next.col -= dir[d][1];
        break;
      }

      if (map[next.row][next.col] != 'T') {
        next.value += map[next.row][next.col] - '0';
      }

      next.row += dir[d][0];
      next.col += dir[d][1];
    }

    return next;
  }

  private static boolean isPossible(int row, int col) {
    return row >= 0 && row < H && col >= 0 && col < W;
  }

  private static class Node {

    int row;
    int col;
    int value;

    public Node(int row, int col, int value) {
      this.row = row;
      this.col = col;
      this.value = value;
    }

  }

}
