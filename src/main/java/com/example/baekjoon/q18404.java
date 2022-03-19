package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class q18404 {

  private static int N;
  private static int M;
  private static Node start;
  private static Node[] end;
  private static Integer[][] moving;
  private static Integer[][] result;

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

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());

    start = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);

    end = new Node[M];
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int row = Integer.parseInt(st.nextToken());
      int col = Integer.parseInt(st.nextToken());
      end[i] = new Node(row, col, 0);
    }

    br.close();
  }

  private static String Solution() {
    StringBuilder sb = new StringBuilder();
    moving = new Integer[][]{{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {+1, -2}, {1, 2}, {2, -1},
        {2, 1}};
    result = new Integer[N + 1][N + 1];

    bfs(start);
    for (int i = 0; i < M; i++) {
      sb.append(result[end[i].row][end[i].col]).append(" ");
    }
    return sb.toString();
  }

  private static void bfs(Node start) {
    Queue<Node> queue = new ArrayDeque<>();

    queue.add(start);
    boolean[][] visited = new boolean[N + 1][N + 1];
    visited[start.row][start.col] = true;

    while (!queue.isEmpty()) {
      Node now = queue.poll();

      for (Integer[] move : moving) {
        int row = now.row + move[0];
        int col = now.col + move[1];

        if (check(row, col) && !visited[row][col]) {
          visited[row][col] = true;
          result[row][col] = now.time + 1;
          queue.add(new Node(row, col, now.time + 1));
        }
      }

    }

  }

  private static boolean check(int row, int col) {
    if (row > 0 && row <= N && col > 0 && col <= N) {
      return true;
    }
    return false;
  }


  private static class Node {
    int row;
    int col;
    int time;

    public Node(int row, int col, int time) {
      this.row = row;
      this.col = col;
      this.time = time;
    }
  }


}
