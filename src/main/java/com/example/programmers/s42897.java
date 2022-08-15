package com.example.programmers;

public class s42897 {

  public static int solution(int[] money) {
    int[][] dp = new int[money.length][2];
    //0 : 방문X,
    // 1 : 훔치기

    int oneNotVisit = 0;
    dp[0][0] = 0;
    dp[0][1] = 0;
    dp[1][0] = 0;
    dp[1][1] = money[1];

    for (int i = 2; i < money.length; i++) {
      dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
      dp[i][1] = dp[i - 1][0] + money[i];
    }
    oneNotVisit = Math.max(dp[money.length - 1][0], dp[money.length - 1][1]);

    int oneVisit = 0;
    dp[0][0] = money[0];
    dp[0][1] = money[0];
    dp[1][0] = money[0];
    dp[1][1] = money[1];

    for (int i = 2; i < money.length; i++) {
      dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
      dp[i][1] = dp[i - 1][0] + money[i];
    }
    oneVisit = dp[money.length - 1][0];
    return Math.max(oneNotVisit, oneVisit);
  }
}

