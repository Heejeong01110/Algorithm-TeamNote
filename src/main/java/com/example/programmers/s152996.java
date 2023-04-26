package com.example.programmers;

import java.util.Arrays;
import java.util.HashMap;

public class s152996 {

  private static double[] locations = new double[]{1, 2.0 / 3, 1.0 / 2, 3.0 / 4};

  public long solution(int[] weights) {
    long result = 0;
    Arrays.sort(weights);
    HashMap<Double, Integer> map = new HashMap<>();
    for (int weight : weights) {
      for (double location : locations) {
        if (map.containsKey(weight * location)) {
          result += map.get(weight * location);
        }
      }
      map.put((weight * 1.0), map.getOrDefault((weight * 1.0), 0) + 1);
    }

    return result;
  }
}
