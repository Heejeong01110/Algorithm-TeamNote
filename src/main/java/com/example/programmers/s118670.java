package com.example.programmers;

public class s118670 {

  private static int N, M;

  public static int[][] solution(int[][] rc, String[] operations) {
    N = rc.length;
    M = rc[0].length;

    int start = 0;
    int stack = 0;
    for (String operation : operations) {
      if (operation.equals("ShiftRow")) {
        if (stack != 0) {
          rc = rotate(rc, start, stack);
          stack = 0;
        }
        start = (start + N - 1) % rc.length;
      } else if (operation.equals("Rotate")) {
        stack += 1;
      }
    }

    if (stack != 0) {
      rc = rotate(rc, start, stack);
    }

    int[][] answer = new int[N][M];
    for (int i = 0; i < N; i++) {
      int r = (start + i) % N;
      for (int c = 0; c < M; c++) {
        answer[i][c] = rc[r][c];
      }
    }

    return answer;
  }

  private static int[][] rotate(int[][] rc, int start, int stack) {
    int[][] cl = new int[N][M];
    for (int i = 0; i < N; i++) {
      cl[i] = rc[i].clone();
    }

    int[] now = new int[]{start, 0};
    boolean tmp = false;
    while (now[0] != start || now[1] != 0 || !tmp) {
      tmp = true;
      int[] copy = getLoc(now, start, stack);
      rc[now[0]][now[1]] = cl[copy[0]][copy[1]];

      now = getLoc(now, start, 1);
    }

    return rc;
  }

  private static int[] getLoc(int[] now, int start, int length) {
    length = length % ((N + M) * 2 - 4); //한바퀴 미만인 갯수로만 돌기
    int start_max_row = (start + N - 1) % N;
    int row = now[0];
    int col = now[1];

    while (length != 0) {
      if (col == 0 && row != start_max_row) {
        int move = Math.min(length, (start_max_row + N - row) % N);
        row = (row + move) % N;
        length -= move;
      } else if (row == start_max_row && col != M - 1) {
        int move = Math.min(length, M - 1 - col);
        col += move;
        length -= move;
      } else if (col == M - 1 && row != start) {
        int move = Math.min(length, (row + N - start) % N);//윗쪽으로 구해야 함
        row = (row + N - move) % N;
        length -= move;

      } else if (row == start) {
        int move = Math.min(length, col);
        col -= move;
        length -= move;
      }
    }
    return new int[]{row, col};
  }
}
