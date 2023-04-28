package com.example.programmers;

import java.util.Comparator;
import java.util.PriorityQueue;

public class s159993 {

  private static int[][] direct = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
  private int rowLen;
  private int colLen;

  public int solution(String[] maps) {
    int answer = -1;
    rowLen = maps.length;
    colLen = maps[0].length();

    int sr = 0, sc = 0, er = 0, ec = 0, rr = 0, rc = 0;
    for (int i = 0; i < rowLen; i++) {
      for (int j = 0; j < colLen; j++) {
        if (maps[i].charAt(j) == 'S') {
          sr = i;
          sc = j;
        } else if (maps[i].charAt(j) == 'E') {
          er = i;
          ec = j;
        } else if (maps[i].charAt(j) == 'L') {
          rr = i;
          rc = j;
        }
      }
    }

    boolean[][] visited = new boolean[maps.length][maps[0].length()];
    PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));

    queue.add(new Node(rr, rc, 0));
    visited[rr][rc] = true;

    int startMin = Integer.MAX_VALUE;
    int endMin = Integer.MAX_VALUE;

    while (!queue.isEmpty()) {
      Node now = queue.poll();

      if (now.row == sr && now.col == sc) {
        startMin = now.cost;
      } else if (now.row == er && now.col == ec) {
        endMin = now.cost;
      }

      if (startMin != Integer.MAX_VALUE && endMin != Integer.MAX_VALUE) {
        answer = endMin + startMin;
        break;
      }

      for (int i = 0; i < 4; i++) {
        int nr = now.row + direct[i][0];
        int nc = now.col + direct[i][1];

        if (isPossible(nr, nc) && maps[nr].charAt(nc) != 'X' && !visited[nr][nc]) {
          visited[nr][nc] = true;
          queue.add(new Node(nr, nc, now.cost + 1));
        }
      }
    }

    return answer;
  }

  private boolean isPossible(int row, int col) {
    return row >= 0 && row < rowLen && col >= 0 && col < colLen;
  }

  private class Node {

    int row;
    int col;
    int cost;

    public Node(int row, int col, int cost) {
      this.row = row;
      this.col = col;
      this.cost = cost;
    }
  }
}
