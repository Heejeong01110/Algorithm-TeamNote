package com.example.programmers;

import java.util.Arrays;

public class s147354 {

  public static int solution(int[][] data, int col, int row_begin, int row_end) {
    int answer = 0;
    Arrays.sort(data, (o1, o2) -> {
      if (o1[col - 1] == o2[col - 1]) {
        return o2[0] - o1[0];
      }
      return o1[col - 1] - o2[col - 1];
    });

    for (int i = row_begin - 1; i <= row_end - 1; i++) {
      int si = 0;

      for (int j = 0; j < data[0].length; j++) {
        si += (data[i][j] % (i + 1));
      }
      answer = answer ^ si;
    }
    return answer;
  }
}
