package com.example.programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class s87377 {

  public String[] solution(int[][] line) {
    String[] answer = {};
    ArrayList<int[]> pos = new ArrayList<>();

    int rowMin = Integer.MAX_VALUE;
    int rowMax = Integer.MIN_VALUE;
    int cmin = Integer.MAX_VALUE;
    int cmax = Integer.MIN_VALUE;
    double x = 0, y = 0, c = 0, x1 = 0, y1 = 0;
    for (int i = 0; i < line.length; i++) {
      for (int j = i + 1; j < line.length; j++) {

        if (line[i][0] == 0) {
          y1 = (-1.0) * line[i][2] / (line[i][1]);
          x1 = ((-1) * line[j][1] * y1 + (-1) * line[j][2]) / line[j][0];
        } else if (line[i][1] == 0) {
          x1 = (-1.0) * line[i][2] / (line[i][0]);
          y1 = ((-1) * line[j][0] * x1 + (-1) * line[j][2]) / line[j][1];
        } else if (line[j][0] == 0) {
          y1 = (-1.0) * line[j][2] / (line[j][1]);
          x1 = ((-1) * line[i][1] * y1 + (-1) * line[i][2]) / line[i][0];
        } else if (line[j][1] == 0) {
          x1 = (-1.0) * line[j][2] / (line[j][0]);
          y1 = ((-1) * line[i][0] * x1 + (-1) * line[i][2]) / line[i][1];
        } else {
          double divide = line[j][0] == 0 ? 0 : (-1.0) * line[i][0] / line[j][0];
          x = line[i][0] + line[j][0] * divide;
          y = line[i][1] + line[j][1] * divide;
          c = line[i][2] + line[j][2] * divide;
          y1 = y == 0 ? 0 : (-1) * c / y;
          x1 = ((-1) * line[i][1] * y1 + (-1) * line[i][2]) / line[i][0];
        }

        if (x1 % 1L == 0.0 && y1 % 1 == 0.0) {
          rowMax = Math.max(rowMax, (int) y1);
          rowMin = Math.min(rowMin, (int) y1);
          cmin = Math.min(cmin, (int) x1);
          cmax = Math.max(cmax, (int) x1);
          pos.add(new int[]{(int) x1, (int) y1});
        }
      }
    }

    pos.sort((o1, o2) -> {
      if (o1[0] == o2[0]) {
        return o1[1] - o2[1];
      }
      return o2[0] - o1[0];
    });

    answer = new String[rowMax - rowMin + 1];
    Arrays.fill(answer, ".".repeat((cmax - cmin + 1)));
    for (int i = 0; i < pos.size(); i++) {
      int row = -(pos.get(i)[1] - rowMax);
      int col = (pos.get(i)[0] - cmin);
      if (col == 0) {
        answer[row] = "*" + answer[row].substring(1);
      } else {
        answer[row] = answer[row].substring(0, col) + "*" + answer[row].substring(col + 1);
      }
    }

    return answer;
  }
}
