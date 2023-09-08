package com.example.programmers;

import java.util.ArrayList;
import java.util.HashMap;

public class s133500 {

  private static int result;
  private static HashMap<Integer, ArrayList<Integer>> map;

  public static int solution(int n, int[][] lighthouse) {
    result = 0;

    map = new HashMap<>();
    for (int i = 1; i <= n; i++) {
      map.put(i, new ArrayList<>());
    }

    for (int[] light : lighthouse) {
      map.get(light[0]).add(light[1]);
      map.get(light[1]).add(light[0]);
    }

    dfs(1, 0);
    return result;
  }

  public static int dfs(int now, int before) {
    if (map.get(now).size() == 1 && map.get(now).get(0) == before) {
      return 1;
    }

    int tmpRes = 0;
    for (int i = 0; i < map.get(now).size(); i++) {
      int next = map.get(now).get(i);
      if (next == before) {
        continue;
      }
      tmpRes += dfs(next, now);
    }

    if (tmpRes == 0) {
      return 1;
    }

    result++;
    return 0;
  }
}
