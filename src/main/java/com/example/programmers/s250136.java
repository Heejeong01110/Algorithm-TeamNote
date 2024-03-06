package com.example.programmers;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class s250136 {

  private static int[][] map;
  private static int N, M;
  private static int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

  public static int solution(int[][] land) {
    int answer = 0;
    N = land.length;
    M = land[0].length;

    int idx = 1;

    HashMap<Integer, Integer> land_size = new HashMap<>();
    map = new int[N][M];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (land[i][j] == 1 && map[i][j] == 0) {
          land_size.put(idx, bfs(i, j, idx++, land));
        }
      }
    }

    for (int j = 0; j < M; j++) {
      int sum = 0;
      boolean[] visited = new boolean[idx];
      visited[0] = true;
      for (int i = 0; i < N; i++) {
        if (!visited[map[i][j]]) {
          sum += land_size.get(map[i][j]);
          visited[map[i][j]] = true;
        }
      }
      answer = Math.max(sum, answer);
    }

    return answer;
  }

  private static int bfs(int r, int c, int idx, int[][] land) {
    Queue<int[]> queue = new LinkedList<>();
    int cnt = 0;

    queue.add(new int[]{r, c});
    map[r][c] = idx;
    cnt += 1;

    while (!queue.isEmpty()) {
      int[] now = queue.poll();

      for (int i = 0; i < 4; i++) {
        int nr = now[0] + dir[i][0];
        int nc = now[1] + dir[i][1];

        if (isPossible(nr, nc) && map[nr][nc] == 0 && land[nr][nc] == 1) {
          queue.add(new int[]{nr, nc});
          map[nr][nc] = idx;
          cnt += 1;
        }
      }
    }
    return cnt;
  }

  private static boolean isPossible(int r, int c) {
    return r >= 0 && r < N && c >= 0 && c < M;
  }

}
