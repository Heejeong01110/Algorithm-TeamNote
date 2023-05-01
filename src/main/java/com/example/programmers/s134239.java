package com.example.programmers;

import java.util.ArrayList;

public class s134239 {

  public double[] solution(int k, int[][] ranges) {
    double[] answer;

    ArrayList<Integer> graph = new ArrayList<>();
    graph.add(k);

    while (k > 1) {
      if (k % 2 == 0) {
        k /= 2;
      } else {
        k = k * 3 + 1;
      }
      graph.add(k);
    }

    double[] sumList = new double[graph.size()];
    sumList[0] = 0;
    for (int i = 1; i < graph.size(); i++) {
      sumList[i] = sumList[i - 1]+ (graph.get(i - 1) +graph.get(i)) / 2.0;
    }

    answer = new double[ranges.length];
    for (int i = 0; i < ranges.length; i++) {
      int start = ranges[i][0];
      int end = sumList.length - 1 + ranges[i][1];
      answer[i] = start > end ? -1
          : Double.parseDouble(String.format("%.1f", sumList[end] - sumList[start]));
    }
    return answer;
  }
}
