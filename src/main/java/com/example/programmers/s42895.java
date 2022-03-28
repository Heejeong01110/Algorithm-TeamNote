package com.example.programmers;

import java.util.ArrayList;

public class s42895 {

  private static ArrayList<Integer> list;
  private static ArrayList<Integer>[] map;

  public static int solution(int N, int number) {
    list = new ArrayList<>();
    map = new ArrayList[9];

    for (int i = 1; i < 9; i++) {
      map[i] = new ArrayList<>();
    }
    list.add(N);
    map[1].add(N);
    if (input(1, number, N)) {
      return 1; //종료
    }
    Integer one;
    Integer two;
    int[] calcResult = new int[7];
    for (int i = 2; i <= 8; i++) {
      calcResult[0] = 0;
      for (int j = 0; j < i; j++) {
        calcResult[0] += N * Math.pow(10, j);
      }
      if (calcResult[0] <= 32000 && input(i, number, calcResult[0])) {
        return i; //종료
      }

      for (int j = 1; j <= i / 2; j++) {

        for (int n = 0; n < map[j].size(); n++) {
          one = map[j].get(n);
          for (int m = 0; m < map[i - j].size(); m++) {
            two = map[i - j].get(m);
            calcResult[1] = one - two;
            calcResult[2] = one / two;
            calcResult[3] = one + two;
            calcResult[4] = one * two;
            calcResult[5] = two - one;
            calcResult[6] = two / one;

            for (int t = 1; t < 7; t++) {
              if (calcResult[t] >= 1 && calcResult[t] <= 32000 && input(i, number, calcResult[t])) {
                return i; //종료
              }
            }

          }
        }
      }
    }

    return -1;
  }

  private static boolean input(int len, int target, int num) {
    if (num == target) {
      return true;
    }

    if (!list.contains(num)) {
      list.add(num);
      map[len].add(num);
    }
    return false;
  }

}
