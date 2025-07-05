package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class q31863 {

  private static final int[][] earthQuake = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
  private static int N, M;
  private static char[][] map;

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
      String s = br.readLine();
      for (int j = 0; j < M; j++) {
        map[i][j] = s.charAt(j);
      }
    }

    br.close();
  }

  private static String Solution() {

    int total = 0;
    Queue<int[]> queue = new ArrayDeque<>();

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (map[i][j] == '@') {
          queue.add(new int[]{i, j});
        }
        if (map[i][j] == '*' || map[i][j] == '#') {
          total += 1;
        }
      }
    }

    int[][] visited = new int[N][M];
    int cnt = 0;
    while (!queue.isEmpty()) {
      int[] now = queue.poll();
      int type = 0;
      if (map[now[0]][now[1]] == '@') {
        type = 2;
      } else if (map[now[0]][now[1]] == '*' || map[now[0]][now[1]] == '#') {
        type = 1;
      }

      for (int d = 0; d < 4; d++) {
        for (int t = 1; t <= type; t++) {
          int nr = now[0] + earthQuake[d][0] * t;
          int nc = now[1] + earthQuake[d][1] * t;
          if (!isPossible(nr, nc) || map[nr][nc] == '|') {
            break;
          }
          visited[nr][nc] += 1;
          if (map[nr][nc] == '*' && visited[nr][nc] == 1
              || map[nr][nc] == '#' && visited[nr][nc] == 2) {
            queue.add(new int[]{nr, nc});
            cnt += 1;
          }
        }
      }
    }

    return cnt + " " + (total - cnt);
  }

  private static boolean isPossible(int r, int c) {
    return r >= 0 && r < N && c >= 0 && c < M;
  }

}
