package com.example.programmers;

public class s140107 {
  public long solution(int k, int d) {
    long answer = 0;

    int idx = 0;
    while(idx * k <= d){
      int xLoc = idx * k;
      long yMax = (long) Math.sqrt(((long)d * d) -((long)xLoc * xLoc));

      answer += (yMax / k)+ 1;
      idx++;
    }

    return answer;
  }
}
