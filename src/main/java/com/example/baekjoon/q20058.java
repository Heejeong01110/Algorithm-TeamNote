package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class q20058 {

  private static int N, Q, len;
  private static int[][] map;
  private static boolean[][] visited;

  private static int[] L;

  private static int[][] direct = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    Solution();
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    Q = Integer.parseInt(st.nextToken());
    len = (int) Math.pow(2, N);
    map = new int[len][len];
    L = new int[Q];

    for (int i = 0; i < len; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < len; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < Q; i++) {
      L[i] = Integer.parseInt(st.nextToken());
    }
    br.close();
  }

  private static void Solution() {

    for (int q = 0; q < Q; q++) {
      //1. 부분격자를 시계방향으로 90도 회전시키기
      int partCnt = len / (int) Math.pow(2, L[q]);
      int partLen = len / partCnt;
      for (int i = 0; i < partCnt; i++) {
        for (int j = 0; j < partCnt; j++) {
          turnPart(i, j, partLen);
        }
      }
      //2. 얼음 양 1칸 줄이기
      List<int[]> melt = new LinkedList<>();
      for (int i = 0; i < len; i++) {
        for (int j = 0; j < len; j++) {
          if (!isPossible(i, j)) {
            melt.add(new int[]{i, j});
          }
        }
      }

      for (int[] m : melt) {
        if (map[m[0]][m[1]] > 0) {
          map[m[0]][m[1]] -= 1;
        }
      }
    }

    int sum = 0;
    int max = 0;
    visited = new boolean[len][len];
    for (int i = 0; i < len; i++) {
      for (int j = 0; j < len; j++) {
        sum += map[i][j];
        if (!visited[i][j] && map[i][j] > 0) {
          max = Math.max(max, getCnt(i, j));
        }
      }
    }

    System.out.print(sum + "\n" + max + "\n");
  }

  private static int getCnt(int row, int col) {
    Queue<int[]> queue = new LinkedList<>();
    int cnt = 0;

    queue.add(new int[]{row, col, 1});
    visited[row][col] = true;
    cnt += 1;

    while (!queue.isEmpty()) {
      int[] now = queue.poll();

      for (int d = 0; d < 4; d++) {
        int nr = now[0] + direct[d][0];
        int nc = now[1] + direct[d][1];

        if (nr >= 0 && nc >= 0 && nr < len && nc < len && map[nr][nc] > 0 && !visited[nr][nc]) {
          queue.add(new int[]{nr, nc, now[2] + 1});
          visited[nr][nc] = true;
          cnt += 1;
        }
      }
    }
    return cnt;
  }

  private static boolean isPossible(int row, int col) {
    int cnt = 0;
    for (int d = 0; d < 4; d++) {
      int nr = row + direct[d][0];
      int nc = col + direct[d][1];
      if (nr >= 0 && nc >= 0 && nr < len && nc < len && map[nr][nc] > 0) {
        cnt += 1;
      }
    }
    return cnt >= 3;
  }

  private static void turnPart(int row, int col, int len) {
    int tmp;
    int sr = row * len;
    int sc = col * len;
    for (int i = 0; i < len / 2; i++) {
      for (int j = i; j < len - i - 1; j++) {
        tmp = map[sr + i][sc + j];
        map[sr + i][sc + j] = map[sr + len - 1 - j][sc + i];
        map[sr + len - 1 - j][sc + i] = map[sr + len - 1 - i][sc + len - 1 - j];
        map[sr + len - 1 - i][sc + len - 1 - j] = map[sr + j][sc + len - 1 - i];
        map[sr + j][sc + len - 1 - i] = tmp;
      }
    }
  }
}
