package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q17141 {

  private static int N, M, res;
  private static int[][] map;
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
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new int[N][N];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    br.close();
  }

  private static int Solution() {
    int[][] visited = new int[N][N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        visited[i][j] = -1;
      }
    }
    res = Integer.MAX_VALUE;
    select(0, visited, 0);
    if (res == Integer.MAX_VALUE) {
      return -1;
    }
    return res;
  }

  private static void select(int loc, int[][] visited, int cnt) {
    if (cnt == M) {
      bfs(visited);
      return;
    }

    for (int i = loc; i < N * N; i++) {
      int row = i / N;
      int col = i % N;

      if (map[row][col] == 2) {
        visited[row][col] = 0;
        select(i + 1, visited, cnt + 1);
        visited[row][col] = -1;
        select(i + 1, visited, cnt);
        break;
      }
    }

  }

  private static void bfs(int[][] v) {

    Queue<int[]> queue = new LinkedList<>();
    int[][] visited = new int[N][N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        visited[i][j] = v[i][j];
        if (visited[i][j] == 0) {
          queue.add(new int[]{i, j, 0});
        }
      }
    }

    int max = 0;
    while (!queue.isEmpty()) {
      int[] now = queue.poll();

      for (int d = 0; d < 4; d++) {
        int nr = now[0] + dir[d][0];
        int nc = now[1] + dir[d][1];

        if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
          if ((map[nr][nc] != 1) && visited[nr][nc] == -1) {
            int cnt = now[2] + 1;
            if (cnt >= res) {
              return;
            }

            visited[nr][nc] = cnt;
            queue.add(new int[]{nr, nc, cnt});
            max = Math.max(max, cnt);
          }
        }
      }

    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if ((map[i][j] == 0 || map[i][j] == 2) && visited[i][j] == -1) {
          return;
        }
      }
    }
    res = Math.min(res, max);
  }

}
