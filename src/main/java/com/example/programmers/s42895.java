package com.example.programmers;

import java.util.ArrayList;

public class s42895 {

  public static int solution(int N, int number) {
    ArrayList<Integer>[] nodes = new ArrayList[9];
    int num = 0;
    for (int i = 1; i <= 8; i++) {
      nodes[i] = new ArrayList<>();
      num = num * 10 + N;
      if (num == number) {
        return i;
      }
      nodes[i].add(num);
    }

    for (int s = 2; s <= 8; s++) {
      for (int idx = 1; idx <= s / 2; idx++) {

        for (Integer o : nodes[idx]) {
          for (Integer t : nodes[s - idx]) {
            int[] list = new int[6];
            list[0] = o + t;
            list[1] = o - t;
            list[2] = o * t;
            list[3] = t != 0 ? o / t : 0;
            list[4] = t - o;
            list[5] = o != 0 ? t / o : 0;

            for (int i = 0; i < 6; i++) {
              if (list[i] >= 0 && list[i] <= 32000) {
                if (nodes[s].contains(list[i])) {
                  continue;
                }
                if (list[i] == number) {
                  return s;
                }
                nodes[s].add(list[i]);
              }
            }
          }
        }
      }
    }
    return -1;
  }

}
