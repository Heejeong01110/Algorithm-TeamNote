package com.example.Exam.skill_checks;

import java.util.Arrays;

//체스판
public class s1 {

  private static int result;
  private static int width;

  public static int solution(int n) {
    result = 0;
    width = n;

    for (int i = 0; i < width; i++) {
      int[] queenInfo = new int[width];
      Arrays.fill(queenInfo, -1);
      queenInfo[0] = i;
      dfs(queenInfo, 1);

    }

    return result;
  }

  private static void dfs(int[] queenInfo, int row) {
    if (row == width) {
      result++;
      return;
    }

    for (int i = 0; i < width; i++) {
      queenInfo[row] = i;
      if (isPossible(row, queenInfo)) {
        dfs(queenInfo, row + 1);
      }
    }

  }


  private static boolean isPossible(int row, int[] queenInfo) {
    for (int i = 0; i < row; i++) {
      if (queenInfo[i] == queenInfo[row]) {
        return false;
      }
      if (Math.abs(row - i) == Math.abs(queenInfo[row] - queenInfo[i])) {
        return false;
      }

    }

    return true;
  }
}
