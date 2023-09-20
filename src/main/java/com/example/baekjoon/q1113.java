package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class q1113 {

  private static int N, M, answer;
  private static int[][] map;
  private static int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

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
      String str = br.readLine();
      for (int j = 0; j < M; j++) {
        map[i][j] = Character.getNumericValue(str.charAt(j));
      }
    }

    br.close();
  }

  private static int Solution() {
    boolean[][] visited = new boolean[N][M];
    answer = 0;

    for (int h = 1; h <= 9; h++) {
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
          if (map[i][j] == h && !visited[i][j]) {
            visited[i][j] = true;
            bfs(i, j, h, visited);
          }
        }
      }
    }

    return answer;
  }

  private static void bfs(int row, int col, int height, boolean[][] visited) {
    int min = 9;
    boolean flood = false;

    Queue<Node> queue = new LinkedList<>();
    List<Node> candi = new ArrayList<>();
    queue.add(new Node(row, col));
    candi.add(new Node(row, col));

    while (!queue.isEmpty()) {
      Node now = queue.poll();

      if (now.row == 0 || now.row == N - 1 || now.col == 0 || now.col == M - 1) {
        flood = true;
      }

      for (int d = 0; d < 4; d++) {
        int nr = now.row + dir[d][0];
        int nc = now.col + dir[d][1];
        if (isPossible(nr, nc)) {
          if (!visited[nr][nc] && map[nr][nc] == height) {
            visited[nr][nc] = true;
            queue.add(new Node(nr, nc));
            candi.add(new Node(nr, nc));
          }

          if (map[nr][nc] < height) {
            flood = true;
          }

          if (map[nr][nc] > height) {
            // 나를 둘러싼 벽 중 가장 낮은 높이를 구함
            min = Math.min(min, map[nr][nc]);
          }

        }
      }
    }

    if (!flood) {
      // 물의 양을 더함
      answer += candi.size() * (min - height);
      for (int i = 0; i < candi.size(); i++) {
        Node now = candi.get(i);
        map[now.row][now.col] = min;
        visited[now.row][now.col] = false;
      }
    }
  }

  private static boolean isPossible(int row, int col) {
    return row >= 0 && row < N && col >= 0 && col < M;
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
