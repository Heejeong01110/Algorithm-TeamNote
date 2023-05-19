package com.example.baekjoon;

import java.io.IOException;
import java.util.Scanner;

public class q17144 {

  private static int R, C, T;

  private static int[][] clean;
  private static int[][] map;
  private static int[][] directs = new int[][]{{0, 1}, {-1, 0}, {0, -1}, {1, 0}};


  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    Scanner sc = new Scanner(System.in);

    R = sc.nextInt();
    C = sc.nextInt();
    T = sc.nextInt();

    map = new int[R][C];
    clean = new int[2][2];
    int cnt = 0;
    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        map[i][j] = sc.nextInt();
        if (map[i][j] == -1) {
          clean[cnt][0] = i;
          clean[cnt][1] = j;
          cnt++;
        }
      }
    }

    for (int t = 0; t < T; t++) {
      //1. 미세먼지 확산
      int[][] moveDusts = new int[R][C];
      for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
          if (map[i][j] == 0 || map[i][j] == -1) {
            continue;
          }

          for (int d = 0; d < 4; d++) {
            int nr = i + directs[d][0];
            int nc = j + directs[d][1];
            if (isPossible(nr, nc) && map[nr][nc] != -1) {
              moveDusts[nr][nc] += map[i][j] / 5;
              moveDusts[i][j] -= map[i][j] / 5;
            }
          }

        }
      }

      for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
          map[i][j] += moveDusts[i][j];
        }
      }

      //2. 공기청정기 작동
      turnCleaning(clean[0], new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}}, 0, clean[0][0]);//반시계
      turnCleaning(clean[1], new int[][]{{0, -1}, {1, 0}, {0, 1}, {-1, 0}}, clean[1][0], R - 1);//시계
    }

    int sum = 0;
    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        if (map[i][j] != -1) {
          sum += map[i][j];
        }
      }
    }

    System.out.print(sum);
  }

  private static void turnCleaning(int[] start, int[][] turnDirs, int sr, int er) {
    int d = start[1] == 0 ? 1 : 0;
    int row = start[0] + turnDirs[d][0];
    int col = start[1] + turnDirs[d][1];

    while (map[row][col] != -1) {
      int nr = row + turnDirs[d][0];
      int nc = col + turnDirs[d][1];

      if (!isPossible(nr, nc) || nr < sr || nr > er) {
        d = (d + 1) % 4; //다음 방향으로 바꿔서 계속 탐색
        continue;
      }
      if (map[nr][nc] == -1) {
        map[row][col] = 0;
      } else if (map[row][col] != -1) {
        map[row][col] = map[nr][nc];
      }
      row = nr;
      col = nc;
    }
  }

  private static boolean isPossible(int row, int col) {
    return row >= 0 && row < R && col >= 0 && col < C;
  }
}
