package com.example.programmers;

import java.util.ArrayDeque;
import java.util.Queue;

public class s388353 {

  private static char[][] map;
  private static int n, m;


  public static int solution(String[] storage, String[] requests) {
    int answer = 0;
    n = storage.length + 2;
    m = storage[0].length() + 2;

    map = new char[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (i == 0 || j == 0 || i == n - 1 || j == m - 1) {
          map[i][j] = '.';
        } else {
          map[i][j] = storage[i - 1].charAt(j - 1);
        }
      }
    }

    for (int i = 0; i < requests.length; i++) {
      char type = requests[i].charAt(0);
      if (requests[i].length() == 1) { //접근 가능 컨테이너 제거
        removeAccessibleContainer(type);
      } else { //모든 컨테이너 제거
        removeAllContainer(type);
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (map[i][j] != '.') {
          answer++;
        }
      }
    }
    return answer;
  }

  private static void removeAccessibleContainer(char type) {
    int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    Queue<int[]> queue = new ArrayDeque<>();
    boolean[][] visited = new boolean[n][m];
    queue.add(new int[]{0, 0});
    visited[0][0] = true;

    while (!queue.isEmpty()) {
      int[] now = queue.poll();

      for (int i = 0; i < 4; i++) {
        int nr = now[0] + dir[i][0];
        int nc = now[1] + dir[i][1];

        if ((nr >= 0 && nr < n && nc >= 0 && nc < m) && !visited[nr][nc]) {
          if (map[nr][nc] == '.') {
            queue.add(new int[]{nr, nc});
          } else if (map[nr][nc] == type) {
            map[nr][nc] = '.';
          }
          visited[nr][nc] = true;
        }
      }
    }
  }

  private static void removeAllContainer(char type) {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (map[i][j] == type) {
          map[i][j] = '.';
        }
      }
    }
  }
}
