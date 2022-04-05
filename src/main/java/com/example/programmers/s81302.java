package com.example.programmers;

import java.util.Arrays;

// 거리두기 확인하기
public class s81302 {

  private static int N;
  private static int M;

  public static int[] solution(String[][] places) {
    N = places.length;
    M = places[0].length;
    int[] answer = new int[N];
    Arrays.fill(answer, 1);

    for (int r = 0; r < places.length; r++) {
      Loop1:
      for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
          if (places[r][i].charAt(j) == 'P') {
            if (!checkRange(i, j, places[r])) {
              answer[r] = 0;
              break Loop1;
            }
          }
        }
      }

    }
    return answer;
  }

  private static boolean checkRange(int row, int col, String[] room) {
    int[][] oneDir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int[][] twoDir = new int[][]{{2, 0}, {-2, 0}, {0, 2}, {0, -2},
        {1, -1}, {1, 1}, {-1, -1}, {-1, 1},};

    for (int i = 0; i < oneDir.length; i++) {
      int nr = row + oneDir[i][0];
      int nc = col + oneDir[i][1];

      if (check(nr, nc)) {
        if (room[nr].charAt(nc) == 'P') {
          return false;
        }

        if (room[nr].charAt(nc) == 'O') {
          nr = row + twoDir[i][0];
          nc = col + twoDir[i][1];
          if (check(nr, nc) && room[nr].charAt(nc) == 'P') {
            return false;
          }
        }
      }
    }

    for (int i = 4; i < twoDir.length; i++) {
      int nr = row + twoDir[i][0];
      int nc = col + twoDir[i][1];

      if (check(nr, nc)) {
        if (room[nr].charAt(nc) == 'P' && !checkCorrectPtc(row, col, nr, nc, room)) {
          return false;
        }
      }
    }
    return true;
  }

  private static boolean checkCorrectPtc(int row, int col, int nr, int nc, String[] room) {
    if (row > nr && col > nc || row < nr && col < nc) {//상 하
      return !isNotPtc(Math.max(row, nr), Math.min(col, nc), room)
          && !isNotPtc(Math.min(row, nr), Math.max(col, nc), room);
    } else {//하 상
      return !isNotPtc(Math.min(row, nr), Math.min(col, nc), room)
          && !isNotPtc(Math.max(row, nr), Math.max(col, nc), room);
    }
  }

  private static boolean isNotPtc(int cr, int cc, String[] room) {
    return room[cr].charAt(cc) != 'X';
  }

  private static boolean check(int nr, int nc) {
    return nr >= 0 && nr < 5 && nc >= 0 && nc < 5;
  }
}
