package com.example.programmers;

// 기둥과 보 설치
public class s60061 {

  static int height;
  private static boolean[][] pillar;
  private static boolean[][] bar;

  public static int[][] solution(int n, int[][] build_frame) {
    pillar = new boolean[n + 1][n + 1];
    bar = new boolean[n + 1][n + 1];
    height = n;

    int count = 0;
    for (int i = 0; i < build_frame.length; i++) {
      int x = build_frame[i][0];
      int y = build_frame[i][1];
      int type = build_frame[i][2];
      int action = build_frame[i][3];

      if (type == 0) { //기둥
        if (action == 1) { //설치
          if (checkPillar(x, y)) {
            pillar[x][y] = true;
            count++;
          }
        } else { //삭제
          pillar[x][y] = false;
          if (!canDelete()) {
            pillar[x][y] = true;
          } else {
            count--;
          }
        }
      } else { //보
        if (action == 1) {
          if (checkBar(x, y)) { //설치
            bar[x][y] = true;
            count++;
          }
        } else { //삭제
          bar[x][y] = false;
          if (!canDelete()) {
            bar[x][y] = true;
          } else {
            count--;
          }
        }
      }
    }
    int[][] result = new int[count][3];
    int idx = 0;
    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= n; j++) {
        if (pillar[i][j]) {
          result[idx][0] = i;
          result[idx][1] = j;
          result[idx++][2] = 0;
        }
        if (bar[i][j]) {
          result[idx][0] = i;
          result[idx][1] = j;
          result[idx++][2] = 1;
        }
      }
    }
    return result;
  }

  private static boolean checkPillar(int x, int y) {
    if (y == 0) { //바닥 위
      return true;
    }

    if (pillar[x][y - 1]) { //기둥 위
      return true;
    }

    //보의 한쪽 끝
    if (x > 0) {
      return bar[x - 1][y] || bar[x][y];
    } else {
      return bar[x][y];
    }

  }

  private static boolean checkBar(int x, int y) {
    if (y == 0) {
      return false;
    }

    //양쪽 중 한곳이 기둥 위
    if (pillar[x][y - 1] || pillar[x + 1][y - 1]) {
      return true;
    }

    //양쪽 모두 다른 보와 연결되어있음
    if (x > 0 && x < height) {
      return bar[x - 1][y] && bar[x + 1][y];
    }

    return false;
  }

  private static boolean canDelete() {
    for (int i = 0; i <= height; i++) {
      for (int j = 0; j <= height; j++) {
        if (pillar[i][j] && !checkPillar(i, j)) {
          return false;
        } else if (bar[i][j] && !checkBar(i, j)) {
          return false;
        }
      }
    }
    return true;
  }

}
