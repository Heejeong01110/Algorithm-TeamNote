package com.example.programmers;

public class s12971 {

  private int length;

  public int solution(int sticker[]) {

    length = sticker.length;

    if (length == 1) {
      return sticker[0];
    }
    if (length == 3) {
      return Math.max(sticker[2], Math.max(sticker[0], sticker[1]));
    }

    int[][] dp1 = new int[length][2]; //0 : 안붙인 것 중에 최대, //1: 붙인것 중에 최대
    //dp1 : idx 0번 붙였을 경우
    //dp2 : idx 0번 안붙였을 경우
    dp1[0][0] = 0;
    dp1[0][1] = sticker[0];
    dp1[1][0] = Math.max(dp1[0][0], dp1[0][1]);
    dp1[1][1] = 0;

    for (int i = 2; i < length; i++) {
      dp1[i][0] = Math.max(dp1[i - 1][0], dp1[i - 1][1]);
      dp1[i][1] = dp1[i - 1][0] + sticker[i];
    }

    int max = dp1[length - 1][0];

    dp1 = new int[length][2];
    dp1[0][0] = 0;
    dp1[0][1] = 0;
    dp1[1][0] = 0;
    dp1[1][1] = sticker[1];

    for (int i = 2; i < length; i++) {
      dp1[i][0] = Math.max(dp1[i - 1][0], dp1[i - 1][1]);
      dp1[i][1] = dp1[i - 1][0] + sticker[i];
    }

    return Math.max(Math.max(max, dp1[length - 1][0]), dp1[length - 1][1]);
  }

}
