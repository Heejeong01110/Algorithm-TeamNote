package com.example.programmers;

public class s172927 {

  private static int[][] costs = {{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};

  public int solution(int[] picks, String[] minerals) {
    int answer = 0;

    return dfs(minerals, picks.clone(), 0, 0);
  }

  private int dfs(String[] minerals, int[] used, int idx, int result) { //최소값 리턴
    boolean temp = false;
    for (int i = 0; i < 3; i++) {
      if (used[i] != 0) {
        temp = true;
        break;
      }
    }
    if (!temp) {
      return 0;
    }

    if (idx >= minerals.length - 5) {
      int cost = 0;
      int usePick = 0;

      for (int i = 0; i < 3; i++) {
        if (used[i] != 0) {
          usePick = i;
          break;
        }
      }

      for (int i = idx; i < minerals.length; i++) {
        cost += costs[usePick][getPickIndex(minerals[i])];
      }
      return cost;
    }

    int min = Integer.MAX_VALUE;
    for (int i = 0; i < 3; i++) {
      if (used[i] == 0) {
        continue;
      }
      int cost = 0;
      for (int j = 0; j < 5; j++) {
        cost += costs[i][getPickIndex(minerals[idx + j])];
      }
      used[i] -= 1;
      min = Math.min(min, cost + dfs(minerals, used, idx + 5, result));

      used[i] += 1;
    }

    return min;
  }

  private int getPickIndex(String mineral) {
    switch (mineral) {
      case "diamond":
        return 0;
      case "iron":
        return 1;
      case "stone":
        return 2;
    }
    return -1;
  }
}
