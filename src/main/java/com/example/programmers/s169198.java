package com.example.programmers;

public class s169198 {

  static int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

  public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
    int[] answer = new int[balls.length];

    for (int i = 0; i < balls.length; i++) {
      int[] ball = balls[i];
      int mx, my, min = Integer.MAX_VALUE;

      for (int j = 0; j < 4; j++) {
        mx = dir[j][0] == 0 ? ball[0] : (dir[j][0] == 1 ? 2 * m - ball[0] : -ball[0]);
        my = dir[j][1] == 0 ? ball[1] : (dir[j][1] == 1 ? 2 * n - ball[1] : -ball[1]);

        if (!isTouchBall(startX, startY, ball[0], ball[1], mx, my)) {
          min = Math.min(min, getLen(startX, startY, mx, my));
        }
      }
      answer[i] = min;
    }

    return answer;
  }

  private int getLen(int sx, int sy, int mx, int my) {
    int x = Math.abs(sx - mx);
    int y = Math.abs(sy - my);
    return x * x + y * y;
  }

  private boolean isTouchBall(int sx, int sy, int tx, int ty, int mx, int my) {
    double a = (1.0 * sy - my) / (1.0 * sx - mx);
    double b = (1.0 * sy - ty) / (1.0 * sx - tx);
    if (a != b) {
      return false;
    }

    double st = Math.sqrt(getLen(sx, sy, tx, ty));
    double tm = Math.sqrt(getLen(tx, ty, mx, my));
    double sm = Math.sqrt(getLen(sx, sy, mx, my));

    return st + tm == sm;
  }
}
