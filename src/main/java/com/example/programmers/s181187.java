package com.example.programmers;

public class s181187 {

  public long solution(int r1, int r2) {
    long answer = 0;

    for (int i = 1; i < r2; i++) {
      if (i < r1) {
        answer += getMaxY(i, r2, false) - getMaxY(i, r1, true);
      } else {
        answer += getMaxY(i, r2, false);
      }
    }

    answer *= 4;
    answer += (r2 - r1 + 1) * 4;
    return answer;
  }

  private long getMaxY(long x, long r, boolean isR1) {
    double max = Math.sqrt(r * r - x * x);
    int result = (int) max;

    if (isR1 && max - result == 0.0) {
      return result - 1;
    }
    return result;
  }
}
