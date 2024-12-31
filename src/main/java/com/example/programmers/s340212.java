package com.example.programmers;

public class s340212 {

  public static int solution(int[] diffs, int[] times, long limit) {
    int n = diffs.length;
    int answer = 100_000;

    int left = 1;
    int right = 100_000;
    int mid = 0;

    while (left <= right) {
      mid = (left + right) / 2; //level

      long time = times[0];
      for (int i = 1; i < n; i++) {
        int diff = diffs[i];
        int time_cur = times[i];
        int time_prev = times[i - 1];

        if (mid >= diff) {
          time += time_cur;
        } else if (mid < diff) {
          time += time_cur + (time_prev + time_cur) * (diff - mid);
        }
      }

      if (time > limit) {
        left = mid + 1;
      } else if (time <= limit) {
        answer = Math.min(answer, mid);
        right = mid - 1;
      }
    }

    return answer;
  }
}
