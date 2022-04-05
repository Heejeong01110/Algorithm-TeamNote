package com.example.programmers;

public class s92344 {

  private static int height;
  private static int width;

  public int solution(int[][] board, int[][] skill) {
    int answer = 0;

    height = board.length;
    width = board[0].length;
    int[][] sumAry = new int[height + 1][width + 1];

    for (int i = 0; i < skill.length; i++) {
      int degree = (skill[i][0] == 1 ? -1 : 1) * skill[i][5];
      int r1 = skill[i][1];
      int c1 = skill[i][2];
      int r2 = skill[i][3];
      int c2 = skill[i][4];

      for (int j = r1; j <= r2; ++j) {
        sumAry[j][c1] += degree;
        sumAry[j][c2 + 1] += -degree;
      }
    }

    for (int i = 0; i < height; i++) {
      for (int j = 1; j < width; j++) {
        sumAry[i][j] = sumAry[i][j - 1] + sumAry[i][j];
      }
    }

    for (int i = 0; i < height; i++) {
      for (int j = 1; j < width; j++) {
        sumAry[i][j] = sumAry[i - 1][j] + sumAry[i][j];
      }
    }

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        if(board[i][j] + sumAry[i][j] > 0){
          answer++;
        }
      }
    }

    return answer;
  }
}
