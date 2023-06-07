package com.example.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class s154540 {

  private int N, M;
  private int[][] directs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

  public int[] solution(String[] maps) {
    ArrayList<Integer> list = new ArrayList<>();

    N = maps.length;
    M = maps[0].length();
    int[][] map = new int[N][M];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        map[i][j] = maps[i].charAt(j) == 'X' ? 0 : Integer.parseInt(maps[i].substring(j, j + 1));
      }
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (map[i][j] == 0) {
          continue;
        }

        int days = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        days += map[i][j];
        map[i][j] = 0;

        while (!queue.isEmpty()) {
          int[] now = queue.poll();
          map[i][j] = 0;
          days += map[now[0]][now[1]];

          for (int d = 0; d < 4; d++) {
            int nr = now[0] + directs[d][0];
            int nc = now[1] + directs[d][1];

            if (isPossible(nr, nc) && map[nr][nc] != 0) {
              queue.add(new int[]{nr, nc});
              days += map[nr][nc];
              map[nr][nc] = 0;
            }
          }
        }
        list.add(days);
      }
    }
    if (list.size() == 0) {
      return new int[]{-1};
    }

    int[] answer = new int[list.size()];
    for (int i = 0; i < list.size(); i++) {
      answer[i] = list.get(i);
    }
    Arrays.sort(answer);
    return answer;
  }

  private boolean isPossible(int row, int col) {
    return row >= 0 && row < N && col >= 0 && col < M;
  }
}
