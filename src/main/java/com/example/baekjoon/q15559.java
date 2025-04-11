package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class q15559 {

  private static final char[] cmd = new char[]{'S', 'E', 'N', 'W'};
  private static final int[][] dir = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
  private static int N, M;
  private static char[][] map;
  private static int[][] visited;

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
    map = new char[N][M];

    for (int i = 0; i < N; i++) {
      map[i] = br.readLine().toCharArray();
    }

    br.close();
  }

  private static int Solution() {
    visited = new int[N][M];

    int idx = 1;

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (visited[i][j] == 0) {
          if (sol(i, j, idx)) {
            idx++;
          }
        }
      }
    }
    return idx - 1;
  }

  private static boolean sol(int r, int c, int idx) {
    Queue<int[]> queue = new ArrayDeque<>();
    Queue<int[]> save = new ArrayDeque<>();
    queue.add(new int[]{r, c});
    save.add(new int[]{r, c});

    while (!queue.isEmpty()) {
      int[] now = queue.poll();
      visited[now[0]][now[1]] = idx;

      for (int d = 0; d < 4; d++) {
        int nr = now[0] + dir[d][0];
        int nc = now[1] + dir[d][1];
        if (nr >= 0 && nr < N && nc >= 0 && nc < M
            && map[now[0]][now[1]] == cmd[d]) {
          if (visited[nr][nc] == 0) {
            queue.add(new int[]{nr, nc});
            save.add(new int[]{nr, nc});
          } else if (visited[nr][nc] != idx) {
            while (!save.isEmpty()) {
              int[] s = save.poll();
              visited[s[0]][s[1]] = visited[nr][nc];
            }
            return false;
          }
        }
      }
    }
    return true;
  }
}
