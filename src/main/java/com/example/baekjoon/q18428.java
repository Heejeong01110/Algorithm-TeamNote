package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q18428 {

  private static int N;
  private static boolean result;
  private static String[][] map;
  private static int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

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
    map = new String[N][N];

    StringTokenizer st;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        map[i][j] = st.nextToken();
      }
    }

    br.close();
  }

  private static String Solution() {
    result = false;
    dfs(0, 0, 0, map);
    if (result) {
      return "YES";
    }
    return "NO";
  }

  private static void dfs(int row, int col, int cnt, String[][] map) {
    if (result) {
      return;
    }
    if (cnt == 3) {
      if (bfs(map)) {
        result = true;
      }
      return;
    }
    if (row == N) {
      return;
    }

    if (map[row][col].equals("X")) {
      map[row][col] = "O";
      dfs(row + (col == N - 1 ? 1 : 0), (col == N - 1 ? 0 : col + 1), cnt + 1, map);
      map[row][col] = "X";
    }
    dfs(row + (col == N - 1 ? 1 : 0), (col == N - 1 ? 0 : col + 1), cnt, map);
  }

  private static boolean bfs(String[][] map) {
    Queue<Node> queue = new LinkedList<>();

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (map[i][j].equals("T")) {
          queue.add(new Node(i, j));
        }
      }
    }

    while (!queue.isEmpty()) {
      Node now = queue.poll();

      int nr, nc;
      for (int i = 0; i < 4; i++) {
        nr = now.row + dir[i][0];
        nc = now.col + dir[i][1];

        while (isPossible(nr, nc)) {
          if (map[nr][nc].equals("O")) {
            break;
          } else if (map[nr][nc].equals("S")) {
            return false;
          }

          nr += dir[i][0];
          nc += dir[i][1];
        }
      }
    }
    return true;
  }

  private static boolean isPossible(int row, int col) {
    return row >= 0 && row < N && col >= 0 && col < N;
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
