package com.example.programmers;

import java.util.Arrays;

public class s43236 {

  private static int result = 0;

  public static int solution(int distance, int[] rocks, int n) {
    Arrays.sort(rocks);

    int[] rockAry = new int[rocks.length + 2];
    rockAry[0] = 0;
    for (int i = 1; i < rocks.length + 1; i++) {
      rockAry[i] = rocks[i - 1];
    }

    rockAry[rocks.length + 1] = distance;

    int start = 0;
    int end = distance;
    int mid = 0; //부술 최소 바위

    while (start <= end) {
      mid = (start + end) / 2;

      if (getMaxDistance(mid, rockAry, n)) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return result;
  }

  private static boolean getMaxDistance(int mid, int[] rockAry, int n) {
    //사이 거리 중 mid 보다 작은 거리의 바위는 부수기

    int breakRock = 0;
    int prev = 0;
    for (int i = 1; i < rockAry.length; i++) {
      if (rockAry[i] - prev < mid) {
        breakRock++;
      } else {
        prev = rockAry[i];
      }
    }

    if (breakRock > n) {
      return false;
    }

    result = Math.max(mid, result);
    return true;
  }
}
