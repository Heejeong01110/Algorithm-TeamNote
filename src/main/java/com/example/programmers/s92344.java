package com.example.programmers;

public class s92344 {

  private static int height;
  private static int width;

  public static int solution(int[][] board, int[][] skill) {
    int answer = 0;

    height = board.length;
    width = board[0].length;
    int[][] sumAry = new int[height + 1][width + 1];

    /*
     *  n 0 0 0 -n
     *  0 0 0 0 0
     *  0 0 0 0 0
     * -n 0 0 0 n
     * */

    for (int i = 0; i < skill.length; i++) {
      int degree = (skill[i][0] == 1 ? -1 : 1) * skill[i][5];
      int r1 = skill[i][1];
      int c1 = skill[i][2];
      int r2 = skill[i][3];
      int c2 = skill[i][4];
      sumAry[r1][c1] += degree;
      sumAry[r2 + 1][c2 + 1] += degree;
      sumAry[r2 + 1][c1] += -degree;
      sumAry[r1][c2 + 1] += -degree;
    }

    for (int i = 1; i <= height; i++) {
      sumAry[i][0] += sumAry[i - 1][0];
    }
    for (int i = 1; i <= width; i++) {
      sumAry[0][i] += sumAry[0][i - 1];
    }

    for (int i = 1; i <= height; i++) {
      for (int j = 1; j <= width; j++) {
        sumAry[i][j] += sumAry[i - 1][j] + sumAry[i][j - 1] - sumAry[i - 1][j - 1];
      }
    }

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        if (board[i][j] + sumAry[i][j] > 0) {
          answer++;
        }
      }
    }

    return answer;
  }
}
