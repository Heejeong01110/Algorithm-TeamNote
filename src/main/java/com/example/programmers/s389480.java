package com.example.programmers;

import java.util.Arrays;

public class s389480 {

  public int solution(int[][] info, int n, int m) {
    Arrays.sort(info, (o1, o2) -> {
      if (o1[0] - o2[0] == 0) {
        return o1[1] - o2[1];
      }
      return o1[0] - o2[0];
    });

    int[][] dp = new int[info.length + 1][m];
    for (int i = 1; i <= info.length; i++) {
      Arrays.fill(dp[i], n);
    }

    dp[0][0] = 0;
    for (int i = 1; i <= info.length; i++) {
      int a = info[i - 1][0];
      int b = info[i - 1][1];

      for (int j = 0; j < m; j++) {
        //a가 훔침
        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + a);

        //b가 훔침
        if (j + b < m) {
          dp[i][j + b] = Math.min(dp[i][j + b], dp[i - 1][j]);
        }
      }
    }

    int answer = n;
    for (int j = 0; j < m; j++) {
      answer = Math.min(answer, dp[info.length][j]);
    }

    return answer >= n ? -1 : answer;
  }
}
