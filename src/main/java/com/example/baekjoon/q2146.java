package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class q2146 {

  private static final int[][] direct = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
  public static int[][] group;
  private static int N;
  private static int result;
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

    StringTokenizer st;
    N = Integer.parseInt(br.readLine());
    map = new int[N][N];
    group = new int[N][N];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
        group[i][j] = i * 100 + j;
      }
    }

    br.close();
  }

  private static int Solution() {
    //1. 그룹 관계 형성하기
    boolean[][] visited = new boolean[N][N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (map[i][j] == 0 || visited[i][j]) {
          continue;
        }

        Queue<Node> queue = new ArrayDeque<>();
        visited[i][j] = true;
        queue.add(new Node(i, j));

        while (!queue.isEmpty()) {
          Node now = queue.poll();

          for (int d = 0; d < 4; d++) {
            int nr = now.row + direct[d][0];
            int nc = now.col + direct[d][1];

            if (isPossible(nr, nc) && map[nr][nc] == 1 && !visited[nr][nc]) {
              visited[nr][nc] = true;
              queue.add(new Node(nr, nc));
              union(getGroupValue(now.row, now.col), getGroupValue(nr, nc));
            }
          }
        }
      }
    }

    //2. 최단 다리길이 구하기
    result = N * 2;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {

        if (map[i][j] == 0) {
          continue;
        }

        for (int d = 0; d < 4; d++) {
          int nr = i + direct[d][0];
          int nc = j + direct[d][1];

          if (isPossible(nr, nc) && map[nr][nc] == 0) {
            calculate(i, j);
            break;
          }

        }
      }
    }
    return result;
  }

  private static boolean isPossible(int nr, int nc) {
    return nr >= 0 && nr < N && nc >= 0 && nc < N;
  }

  private static int getGroupValue(int row, int col) {
    return row * 100 + col;
  }

  private static int find(int x) {
    int row = x / 100;
    int col = x % 100;
    if (x == group[row][col]) {
      return x;
    } else {
      return group[row][col] = find(group[row][col]);
    }
  }

  private static void union(int x, int y) {
    x = find(x);
    y = find(y); // 같은 부모를 가지고 있지 않을 때
    if (x != y) { // y가 x 보다 크다는 것을 가정한다면 아래와 같이 표현
      int row = y / 100;
      int col = y % 100;
      group[row][col] = x;
    }
  }

  private static void calculate(int row, int col) {

    boolean[][] visited = new boolean[N][N];
    Queue<Node> queue = new ArrayDeque<>();
    int count = 0;

    queue.add(new Node(row, col));
    visited[row][col] = true;

    while (!queue.isEmpty()) {
      if (count > result) {
        return;
      }

      int size = queue.size();

      for (int t = 0; t < size; t++) {
        Node now = queue.poll();

        if (map[now.row][now.col] == 1
            && (now.row != row || now.col != col)
            && group[now.row][now.col] != group[row][col]) {
          result = Math.min(result, count - 1);
          return;
        }

        for (int d = 0; d < 4; d++) {
          int nr = now.row + direct[d][0];
          int nc = now.col + direct[d][1];

          if (isPossible(nr, nc) && !visited[nr][nc] && group[row][col] != group[nr][nc]) {
            queue.add(new Node(nr, nc));
            visited[nr][nc] = true;
          }
        }
      }

      count++;
    }


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
