package com.example.programmers;

public class s87946 {

  private static int count;

  public static int solution(int k, int[][] dungeons) {
    count = 0;

    dfs(0, k, dungeons, new boolean[dungeons.length]);

    return count;
  }


  private static void dfs(int depth, int fatigue, int[][] dungeons, boolean[] visited) {
    for (int i = 0; i < dungeons.length; i++) {
      if (visited[i] || dungeons[i][0] > fatigue) {
        continue;
      }
      visited[i] = true;
      dfs(depth + 1, fatigue - dungeons[i][1], dungeons, visited);
      visited[i] = false;
    }
    count = Math.max(count, depth);
  }

}
