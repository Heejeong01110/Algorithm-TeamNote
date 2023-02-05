package com.example.programmers;

import java.util.Comparator;
import java.util.PriorityQueue;

public class s150365 {

  private static final int[][] DIRECT = new int[][]{{1, 0}, {0, -1}, {0, 1}, {-1, 0}};
  private static final String[] DIRECT_STR = new String[]{"d", "l", "r", "u"};
  private static final String IMPOSSIBLE = "impossible";

  public static String solution(int n, int m, int x, int y, int r, int c, int k) {
    String answer = "";

    int[][] map = new int[n + 1][m + 1];

    map[x][y] = -1;
    map[r][c] = 1;

    //1. k거리 만에 이동할 수 있는지?
    //최단거리 > k || 최단거리와 k는 홀, 짝이 일치해야 함
    int minPath = Math.abs(x - r) + Math.abs(y - c);
    if (!isPossible(minPath, k)) {
      answer = IMPOSSIBLE;
      return answer;
    }

    PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparing(o -> o.path));
    queue.add(new Node(x, y, ""));

    while (!queue.isEmpty()) {
      Node now = queue.poll();
      if (now.path.length() == k) {
        if (map[now.row][now.col] == 1) {
          answer = now.path;
          return answer;
        }
        continue;
      }

      for (int i = 0; i < 4; i++) {
        int nr = now.row + DIRECT[i][0];
        int nc = now.col + DIRECT[i][1];

        int nMinPath = Math.abs(nr - r) + Math.abs(nc - c);
        if (isInMap(nr, nc, n, m)
            && isPossible(nMinPath, k - (now.path.length() + 1))) {
          Node next = new Node(nr, nc, now.path + DIRECT_STR[i]);
          queue.add(next);
        }
      }
    }
    answer = IMPOSSIBLE;
    return answer;
  }

  private static boolean isInMap(int nr, int nc, int n, int m) {
    return nr >= 1 && nc >= 1 && nr <= n && nc <= m;
  }

  private static boolean isPossible(int target, int k) {
    return target <= k && (target % 2) == (k % 2);
  }

  private static class Node {

    int row;
    int col;
    String path;

    public Node(int row, int col, String path) {
      this.row = row;
      this.col = col;
      this.path = path;
    }
  }
}
