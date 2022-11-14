package com.example.programmers;

public class s12979 {

  private static int BLOCK;

  public static int solution(int n, int[] stations, int w) {

    int now = 1;
    int index = 0;
    int answer = 0;
    BLOCK = 1 + w * 2;

    while (now <= n) {
      if (index >= stations.length) {
        int size = n - now + 1;
        answer += size / BLOCK + (size % BLOCK > 0 ? 1 : 0);
        break;
      }

      if (stations[index] > now + w) {
        int size = (stations[index] - w) - now;
        answer += size / BLOCK + (size % BLOCK > 0 ? 1 : 0);
      }
      now = stations[index] + w + 1;
      index++;
    }

    return answer;
  }

}
