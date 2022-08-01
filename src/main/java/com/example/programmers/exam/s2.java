package com.example.programmers.exam;

import java.util.HashMap;

public class s2 {

  private static HashMap<String, Integer> wantIdx;

  public static int solution(String[] want, int[] number, String[] discount) {
    int answer = 0;
    wantIdx = new HashMap<>();
    for (int i = 0; i < want.length; i++) {
      wantIdx.put(want[i], i);
    }

    int[][] sumAry = new int[discount.length+1][want.length];

    for (int i = 1; i <= discount.length; i++) {
      int upIdx = wantIdx.getOrDefault(discount[i-1], -1);
      if (upIdx == -1) {
        continue;
      }

      System.arraycopy(sumAry[i - 1], 0, sumAry[i], 0, want.length);
      sumAry[i][upIdx]++;
    }

    for (int i = 0; i < sumAry.length - 10; i++) {
      if (!isMatch(sumAry, i, want, number)) {
        continue;
      }
      answer++;
    }
    return answer;
  }

  private static boolean isMatch(int[][] sumAry, int start, String[] want, int[] number) {
    int[] compare = new int[want.length];

    for(int i=0;i<want.length;i++){
      compare[i] = sumAry[start + 10][i] - sumAry[start][i];
      if(compare[i] < number[wantIdx.get(want[i])]){
        return false;
      }
    }

    return true;
  }
}
