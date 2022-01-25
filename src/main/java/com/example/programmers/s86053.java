package com.example.programmers;

public class s86053 {

  public static long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
    int sMax, sMin, gMax, gMin;

    int start = 0;
    int end = Integer.MAX_VALUE;

    while (start <= end) {
      int mid = (start + end) / 2;
      int gold = 0;
      int silver = 0;
      int add = 0;
      for (int i = 0; i < s.length; i++) {
        int now_g = g[i];
        int now_s = s[i];
        int now_w = w[i];
        int now_t = t[i];

        int move_cnt = (int) Math.floor(mid / (now_t * 2));
        if (mid % (now_t * 2) >= t[i]) {
          move_cnt++;
        }
      }


    }

    return 0;
  }

}
