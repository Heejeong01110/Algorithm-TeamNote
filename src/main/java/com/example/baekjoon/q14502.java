package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class q14502 {

  private static int N;
  private static int M;
  private static int result;
  private static int[][] map;
  private static int[][] directs = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

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
    result = N * M;
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

    boolean[] visited = new boolean[N * M];
    int wallCnt = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (map[i][j] != 0) {
          int idx = i * M + j;
          visited[idx] = true;
        }
        if (map[i][j] == 1) {
          wallCnt++;
        }
      }
    }

    dfs(0, visited, map, 0);
    int answer = N * M - result - wallCnt-3;
    return answer;
  }

  private static void dfs(int idx, boolean[] visited, int[][] map, int cnt) {
    if (cnt == 3) {
      result = Math.min(result, bfs(map));
      return;
    }

    if (idx == visited.length) {
      return;
    }

    for (int i = idx; i < visited.length; i++) {
      if (!visited[i]) {
        int row = i / M;
        int col = i % M;

        visited[i] = true;
        map[row][col] = 1;

        dfs(i + 1, visited, map, cnt + 1);

        visited[i] = false;
        map[row][col] = 0;
      }
    }
  }

  private static int bfs(int[][] map) {
    boolean[][] visited = new boolean[N][M];
    Queue<int[]> queue = new ArrayDeque<>();

    int cnt = 0;

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (map[i][j] == 2) {
          visited[i][j] = true;
          queue.add(new int[]{i, j});
        }
      }
    }

    while (!queue.isEmpty()) {

      if (cnt >= result) {
        return cnt;
      }

      int[] now = queue.poll();
      cnt++;

      for (int i = 0; i < 4; i++) {
        int nr = now[0] + directs[i][0];
        int nc = now[1] + directs[i][1];

        if (isPossible(nr, nc) && map[nr][nc] == 0 && !visited[nr][nc]) {
          visited[nr][nc] = true;
          queue.add(new int[]{nr, nc});
        }
      }
    }

    return cnt;
  }

  private static boolean isPossible(int row, int col) {
    return row >= 0 && row < N && col >= 0 && col < M;
  }

}
