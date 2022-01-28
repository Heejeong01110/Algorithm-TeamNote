package com.example.programmers;

// 보행자 천국
public class s1832 {

  private static int count, width, height;
  private static int MOD = 20170805;

  public static int solution(int m, int n, int[][] cityMap) {
    count = 0;
    width = m;
    height = n;

    int[][][] dp = new int[width][height][2]; // 0: 하, 1 : 우

    for (int i = 0; i < width; i++) {
      if (cityMap[i][0] != 1) {
        dp[i][0][0] = 1;
      }
    }
    for (int i = 0; i < height; i++) {
      if (cityMap[0][i] != 1) {
        dp[0][i][1] = 1;
      }
    }

    for (int i = 1; i < width; i++) {
      for (int j = 1; j < height; j++) {
        for (int dir = 0; dir < 2; dir++) {
          if (i == 0 && j == 0) {
            continue;
          }

          if (cityMap[i][j] == 1) {
            continue;
          }

          if (i - 1 < 0) {
            dp[i][j][0] = 0;
          } else if (cityMap[i - 1][j] == 2) {
            dp[i][j][0] = dp[i - 1][j][0];
          } else {
            dp[i][j][0] = dp[i - 1][j][0] + dp[i - 1][j][1];
          }

          if (j - 1 < 0) {
            dp[i][j][1] = 0;
          } else if (cityMap[i][j - 1] == 2) {
            dp[i][j][1] = dp[i][j - 1][1];
          } else {
            dp[i][j][1] = dp[i][j - 1][0] + dp[i][j - 1][1];
          }

        }
      }
    }
    count = dp[width - 1][height - 1][0] + dp[width - 1][height - 1][1];

//    dfs(0, 0, cityMap, -1);
    return count % MOD;
  }

  private static void dfs(int row, int col, int[][] cityMap, int dir) {
    if (row == width - 1 && col == height - 1) {
      count += 1;
      return;
    }

    int[] dr = {1, 0}; //하우
    int[] dc = {0, 1};

    for (int i = 0; i < 2; i++) {
      int newRow = row + dr[i];
      int newCol = col + dc[i];

      if (!inMap(newRow, newCol)) {
        continue;
      }

      if (!possibleMove(row, col, newRow, newCol, i, dir, cityMap)) {
        continue;
      }
      dfs(newRow, newCol, cityMap, i);
    }


  }

  private static boolean possibleMove(int row, int col, int newRow, int newCol, int moveDir,
      int beforeDir,
      int[][] cityMap) {
    if (cityMap[newRow][newCol] == 1) {
      return false;
    }
    if (beforeDir == -1) {
      return true;
    }
    if (cityMap[row][col] == 2 && beforeDir != moveDir) {
      return false;
    }

    return true;
  }

  private static boolean inMap(int newRow, int newCol) {
    if (newRow < 0 || newCol < 0 || newRow >= width || newCol >= height) {
      return false;
    }

    return true;
  }
}
