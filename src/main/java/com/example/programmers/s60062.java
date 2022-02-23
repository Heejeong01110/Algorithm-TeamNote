package com.example.programmers;

import java.util.Arrays;

public class s60062 {

  private static Integer result = 0;

  public static int solution(int n, int[] weak, int[] dist) {
    result = dist.length + 1;

    int[] reWeak = new int[weak.length * 2];

    System.arraycopy(weak, 0, reWeak, 0, weak.length);
    for (int i = weak.length; i < weak.length * 2; i++) {
      reWeak[i] = weak[i - weak.length] + n;
    }

    Arrays.sort(dist);

    for (int i = 0; i < weak.length; i++) {
      int[] newWeak = new int[weak.length];
      for (int j = 0; j < newWeak.length; j++) {
        newWeak[j] = reWeak[i + j];
      }

      perm(dist, new int[dist.length], new boolean[dist.length], 0, newWeak);
    }
    if (result == dist.length + 1) {
      result = -1;
    }
    return result;
  }

  private static void perm(int[] inputDist, int[] outputDist, boolean[] visited, int depth,
      int[] newWeak) {
    if (depth == inputDist.length) {
      //연산
      check(outputDist, newWeak);
      return;
    }
    for (int i = 0; i < inputDist.length; i++) {
      if (!visited[i]) {
        visited[i] = true;
        outputDist[depth] = inputDist[i];
        perm(inputDist, outputDist, visited, depth + 1, newWeak);
        visited[i] = false;
      }
    }
  }

  private static void check(int[] dist, int[] weak) {
    int cur = 0;
    int next = 0;
    int dist_idx = 0;
    while (cur < weak.length && dist_idx < dist.length) {
      next = cur + 1;
      while ((next < weak.length) && (weak[cur] + dist[dist_idx] >= weak[next])) {
        next++;
      }
      cur = next;
      dist_idx++;
    }
    if (cur == weak.length && dist_idx < result) {
      result = dist_idx;
    }
  }

}
