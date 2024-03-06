package com.example.programmers;

public class s258711 {

  public static int[] solution(int[][] edges) {
    int idx_max = 0;
    int[][] cnt = new int[1_000_001][2];

    for (int[] edge : edges) {
      cnt[edge[0]][0] += 1;
      cnt[edge[1]][1] += 1;
      idx_max = Math.max(idx_max, Math.max(edge[0], edge[1]));
    }

    int[] answer = new int[4];
    for (int i = 1; i <= idx_max; i++) {
      if (cnt[i][0] >= 2 && cnt[i][1] == 0) {
        answer[0] = i;
      }

      if (cnt[i][0] == 0) {
        answer[2] += 1;
      } else if (cnt[i][0] == 2 && cnt[i][1] >= 2) {
        answer[3] += 1;
      }
    }

    answer[1] = cnt[answer[0]][0] - (answer[2] + answer[3]);

    return answer;
  }
}
