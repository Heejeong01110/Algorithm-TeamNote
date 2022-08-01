package com.example.programmers.exam;

import java.util.Arrays;

public class s4 {

  public static int solution(int[][] beginning, int[][] target) {
    int answer1 = 0;

    int[][] beginCopy = new int[beginning.length][beginning[0].length];
    for (int i = 0; i < beginning.length; i++) {
      beginCopy[i] = beginning[i].clone();
    }
    for (int i = 0; i < beginCopy.length; i++) {
      for (int j = 0; j < beginCopy[0].length; j++) {
        if (beginCopy[i][j] != target[i][j]) {
          if (i == 0) {
            turnCols(beginCopy, j);
            answer1++;
          } else {
            turnRows(beginCopy, i);
            answer1++;
          }
        }
      }
    }

    int answer2 = 0;
    int[][] begin2Copy = new int[beginning.length][beginning[0].length];
    for (int i = 0; i < beginning.length; i++) {
      begin2Copy[i] = beginning[i].clone();
    }

    for (int i = 0; i < begin2Copy[0].length; i++) {
      for (int j = 0; j < begin2Copy.length; j++) {
        if (begin2Copy[j][i] != target[j][i]) {
          if (i == 0) {
            turnRows(begin2Copy, j);
            answer2++;
          } else {
            turnCols(begin2Copy, i);
            answer2++;
          }
        }
      }
    }

    boolean one = isSameAry(beginCopy, target);
    boolean two = isSameAry(begin2Copy, target);

    if (one && two) {
      return Math.min(answer1, answer2);
    } else if (one) {
      return answer1;
    } else if (two) {
      return answer2;
    } else {
      return -1;
    }

  }

  private static void turnRows(int[][] beginning, int row) {
    for (int i = 0; i < beginning[0].length; i++) {
      beginning[row][i] = (beginning[row][i] + 1) % 2;
    }
  }

  private static void turnCols(int[][] beginning, int col) {
    for (int i = 0; i < beginning.length; i++) {
      beginning[i][col] = (beginning[i][col] + 1) % 2;
    }
  }


  private static boolean isSameAry(int[][] beginning, int[][] target) {
    for (int i = 0; i < beginning.length; i++) {
      if (!Arrays.equals(beginning[i], target[i])) {
        return false;
      }
    }
    return true;
  }
}
