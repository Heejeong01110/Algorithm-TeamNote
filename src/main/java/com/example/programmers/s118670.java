package com.example.programmers;

public class s118670 {

  private static int N, M;

  public static int[][] solution(int[][] rc, String[] operations) {
    N = rc.length;
    M = rc[0].length;
    int start = 0;
    for (String operation : operations) {
      if (operation.equals("ShiftRow")) {
        start = (start + N - 1) % rc.length;
      } else if (operation.equals("Rotate")) {
        rc = rotate(rc, start);
      }
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

  private static int[][] rotate(int[][] rc, int start) {
    int tmp = rc[start][0];
    for (int i = 0; i < N - 1; i++) {
      int row = (start + i) % N;
      int next = (start + i + 1) % N;
      rc[row][0] = rc[next][0];
    }
    for (int i = 0; i < M - 1; i++) {
      int row = (start + N - 1) % N;
      int col = i;
      rc[row][col] = rc[row][col + 1];
    }
    for (int i = N - 1; i > 0; i--) {
      int row = (start + i) % N;
      int pre = (start + i - 1) % N;
      rc[row][M - 1] = rc[pre][M - 1];
    }
    for (int i = M - 1; i > 0; i--) {
      rc[start][i] = rc[start][i - 1];
    }
    rc[start][1] = tmp;
    return rc;
  }
}
