package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q15683 {

  private static final int[][] directs = new int[][]{{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
  private static int N;
  private static int M;
  private static int[][] map;
  private static int cctvCnt;
  private static int result;

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
    cctvCnt = 0;

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
        if (map[i][j] != 0 && map[i][j] != 6) {
          cctvCnt++;
        }
      }
    }

    br.close();
  }

  private static int Solution() {
    result = N * M;
    dfs(0, 0, map);

    return result;
  }


  private static void dfs(int idx, int cctvNow, int[][] mapCpy) {
    if (idx == N * M || cctvNow == cctvCnt) {
      int cnt = 0;
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
          if (mapCpy[i][j] == 0) {
            cnt++;
          }
        }
      }
      result = Math.min(result, cnt);
      return;
    }

    int row = idx / M;
    int col = idx % M;

    if (map[row][col] == 0 || map[row][col] == 6) {
      dfs(idx + 1, cctvNow, mapCpy);

    } else if (map[row][col] == 5) {
      int[][] mapClone = getClone(mapCpy);
      for (int i = 0; i < 4; i++) {
        checkDir(mapClone, i, row, col);
      }
      dfs(idx + 1, cctvNow + 1, mapClone);

    } else if (map[row][col] == 4) {
      for (int i = 0; i < 4; i++) {
        int[][] mapClone = getClone(mapCpy);
        for (int j = 0; j < 3; j++) {
          int dir = (i + j) % 4;
          checkDir(mapClone, dir, row, col);
        }
        dfs(idx + 1, cctvNow + 1, mapClone);
      }

    } else if (map[row][col] == 3) {
      for (int i = 0; i < 4; i++) {
        int[][] mapClone = getClone(mapCpy);
        for (int j = 0; j < 2; j++) {
          int dir = (i + j) % 4;
          checkDir(mapClone, dir, row, col);
        }
        dfs(idx + 1, cctvNow + 1, mapClone);
      }

    } else if (map[row][col] == 2) {
      for (int i = 0; i < 2; i++) {
        int[][] mapClone = getClone(mapCpy);
        checkDir(mapClone, i, row, col);
        checkDir(mapClone, i + 2, row, col);
        dfs(idx + 1, cctvNow + 1, mapClone);
      }

    } else if (map[row][col] == 1) {
      for (int i = 0; i < 4; i++) {
        int[][] mapClone = getClone(mapCpy);
        checkDir(mapClone, i, row, col);
        dfs(idx + 1, cctvNow + 1, mapClone);
      }
    }

  }

  private static int[][] getClone(int[][] mapCpy) {
    int[][] newMap = new int[N][M];
    for (int i = 0; i < N; i++) {
      newMap[i] = mapCpy[i].clone();
    }
    return newMap;
  }

  private static void checkDir(int[][] map, int dir, int row, int col) {
    int len = dir % 2 == 0 ? M : N;
    for (int i = 0; i < len; i++) {
      int nr = row + directs[dir][0] * i;
      int nc = col + directs[dir][1] * i;
      if (!isPossible(nr, nc) || map[nr][nc] == 6) {
        break;
      }

      if (map[nr][nc] == 0) {
        map[nr][nc] = -1;
      }
    }
  }

  private static boolean isPossible(int row, int col) {
    return row >= 0 && row < N && col >= 0 && col < M;
  }

}
