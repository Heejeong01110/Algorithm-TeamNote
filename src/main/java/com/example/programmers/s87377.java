package com.example.programmers;

import java.util.ArrayList;

public class s87377 {

  public String[] solution(int[][] line) {
    ArrayList<long[]> pos = new ArrayList<>();
    long minX = Long.MAX_VALUE, minY = Long.MAX_VALUE, maxX = Long.MIN_VALUE, maxY = Long.MIN_VALUE;

    for (int i = 0; i < line.length; i++) {
      long a = line[i][0];
      long b = line[i][1];
      long e = line[i][2];
      for (int j = i + 1; j < line.length; j++) {
        long c = line[j][0];
        long d = line[j][1];
        long f = line[j][2];

        long down = a * d - b * c;
        if (down == 0) {
          continue;
        }

        long xUp = b * f - e * d;
        long yUp = e * c - a * f;

        double nx = xUp / (double) down;
        double ny = yUp / (double) down;
        if (nx == Math.ceil(nx) && ny == Math.ceil(ny)) {
          minX = Math.min(minX, (long) nx);
          minY = Math.min(minY, (long) ny);
          maxX = Math.max(maxX, (long) nx);
          maxY = Math.max(maxY, (long) ny);
          pos.add(new long[]{(long) nx, (long) ny});
        }
      }
    }

    boolean[][] answerTemp = new boolean[(int) (maxY - minY + 1)][(int) (maxX - minX + 1)];

    for (long[] ints : pos) {
      int x = (int) (ints[0] - minX);
      int y = (int) (ints[1] - maxY);

      answerTemp[Math.abs(y)][Math.abs(x)] = true;
    }

    String[] answer = new String[answerTemp.length];

    int i = 0;
    for (boolean[] bs : answerTemp) {
      StringBuilder sb = new StringBuilder();
      for (boolean b : bs) {
        if (b) {
          sb.append("*");
        } else {
          sb.append(".");
        }
      }
      answer[i] = sb.toString();
      i++;
    }

    return answer;
  }

}
