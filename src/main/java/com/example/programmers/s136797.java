package com.example.programmers;

import java.util.Arrays;

public class s136797 {

  private int[][] cost = {
      {1, 7, 6, 7, 5, 4, 5, 3, 2, 3},
      {7, 1, 2, 4, 2, 3, 5, 4, 5, 6},
      {6, 2, 1, 2, 3, 2, 3, 5, 4, 5},
      {7, 4, 2, 1, 5, 3, 2, 6, 5, 4},
      {5, 2, 3, 5, 1, 2, 4, 2, 3, 5},
      {4, 3, 2, 3, 2, 1, 2, 3, 2, 3},
      {5, 5, 3, 2, 4, 2, 1, 5, 3, 2},
      {3, 4, 5, 6, 2, 3, 5, 1, 2, 4},
      {2, 5, 4, 5, 3, 2, 3, 2, 1, 2},
      {3, 6, 5, 4, 5, 3, 2, 4, 2, 1}
  };

  private int Len;
  private String numbersStr;
  private int[][][] dp;

  public int solution(String numbers) {
    Len = numbers.length();
    numbersStr = numbers;
    dp = new int[Len + 1][10][10]; //L, R

    for (int i = 0; i <= Len; i++) {
      for (int j = 0; j < 10; j++) {
        Arrays.fill(dp[i][j], -1);
      }
    }

    return func(0, 4, 6);
  }

  private int func(int idx, int left, int right) {
    if (idx == Len) {
      return 0;
    }

    if (dp[idx][right][left] != -1) {
      return dp[idx][right][left];
    }

    int num = numbersStr.charAt(idx) - '0';
    int result = Integer.MAX_VALUE;

    if (num != right) {
      result = Math.min(func(idx + 1, num, right) + cost[left][num], result);
    }
    if (num != left) {
      result = Math.min(func(idx + 1, left, num) + cost[num][right], result);
    }
    return dp[idx][left][right] = result;
  }


}
