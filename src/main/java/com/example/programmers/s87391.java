package com.example.programmers;

//공 이동 시뮬레이션
public class s87391 {

  public static long solution(int n, int m, int x, int y, int[][] queries) {
    int x1 = x;
    int y1 = y;
    int x2 = x;
    int y2 = y;
    for (int i = queries.length - 1; i >= 0; i--) {

      if (queries[i][0] == 0) {//x 감소
        if (y1 != 0) {
          y1 += queries[i][1];
        }
        y2 = Math.min(y2 + queries[i][1], m - 1);
        if (m < y1) {
          return 0;
        }

      } else if (queries[i][0] == 1) {//x 증가
        if (y2 != m - 1) {
          y2 = y2 - queries[i][1];
        }
        y1 = Math.max(0, y1 - queries[i][1]);
        if (y2 < 0) {
          return 0;
        }


      } else if (queries[i][0] == 2) {//y 감소
        if (x1 != 0) {
          x1 = x1 + queries[i][1];
        }
        x2 = Math.min(x2 + queries[i][1], n - 1);
        if (n < x1) {
          return 0;
        }

      } else if (queries[i][0] == 3) {//y 증가
        if (x2 != n - 1) {
          x2 = x2 - queries[i][1];
        }
        x1 = Math.max(0, x1 - queries[i][1]);
        if (x2 < 0) {
          return 0;
        }

      }
    }
    long X = x2 - x1 + 1;
    long Y = y2 - y1 + 1;

    return X * Y;
  }

}
