package com.example.programmers;

import java.util.Arrays;

public class s77485 {

  private static int[][] map;
  private static int[] minNums;

  public static int[] solution(int rows, int columns, int[][] queries) {

    map = new int[rows][columns];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        map[i][j] = i * columns + (j + 1);
      }
    }

    minNums = new int[queries.length];
    Arrays.fill(minNums, Integer.MAX_VALUE);
    for (int i = 0; i < queries.length; i++) {
      turn(queries[i], i);
    }

    return minNums;
  }

  private static void turn(int[] queries, int index) {
    int sr = queries[0] - 1;
    int sc = queries[1] - 1;
    int er = queries[2] - 1;
    int ec = queries[3] - 1;

    int temp = map[sr][sc];

    for (int i = sr; i < er; i++) {//왼
      map[i][sc] = map[i + 1][sc];
      minNums[index] = Math.min(map[i][sc], minNums[index]);
    }

    for (int i = sc; i < ec; i++) {//아래
      map[er][i] = map[er][i + 1];
      minNums[index] = Math.min(map[er][i], minNums[index]);
    }
    for (int i = er; i > sr; i--) {//오른
      map[i][ec] = map[i - 1][ec];
      minNums[index] = Math.min(map[i][ec], minNums[index]);
    }
    for (int i = ec; i > sc + 1; i--) {//위
      map[sr][i] = map[sr][i - 1];
      minNums[index] = Math.min(map[sr][i], minNums[index]);
    }
    map[sr][sc + 1] = temp;
    minNums[index] = Math.min(map[sr][sc + 1], minNums[index]);
  }
}
