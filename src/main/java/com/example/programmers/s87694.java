package com.example.programmers;

import java.util.ArrayDeque;
import java.util.Queue;

public class s87694 {

  private static final int[][] direct = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
  private static boolean[][] map;

  public static int solution(int[][] rectangle, int characterX, int characterY, int itemX,
      int itemY) {
    map = new boolean[60][60];

    for (int i = 0; i < rectangle.length; i++) {
      fillMap(rectangle[i]);
    }

    Queue<Node> queue = new ArrayDeque<>();
    queue.add(new Node(characterX, characterY));
    boolean[][] visited = new boolean[60][60];
    visited[characterX][characterY] = true;

    int distinct = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();

      for (int s = 0; s < size; s++) {
        Node now = queue.poll();

        if (now.row == itemX && now.col == itemY) {
          s = size;
          queue.clear();
          distinct--;
          break;
        }

        for (int i = 0; i < 4; i++) {
          int nr = now.row + direct[i][0];
          int nc = now.col + direct[i][1];

          if (visited[nr][nc] || !isPossible(nr, nc)
              || !isEdge(nr, nc) || !isConnected(now.row, now.col, nr, nc)) {
            continue;
          }

          queue.add(new Node(nr, nc));
          visited[nr][nc] = true;
        }
      }
      distinct++;
    }

    return distinct;
  }

  private static boolean isConnected(int row, int col, int nr, int nc) {
    if (row == nr) {
      if (map[row - 1][Math.min(col, nc)] && map[row][Math.min(col, nc)]) {
        return false;
      }
      return map[row - 1][Math.min(col, nc)] || map[row][Math.min(col, nc)];
    } else {
      if (map[Math.min(row, nr)][col - 1] && map[Math.min(row, nr)][col]) {
        return false;
      }
      return map[Math.min(row, nr)][col - 1] || map[Math.min(row, nr)][col];
    }
  }

  private static boolean isEdge(int row, int col) {
    int count = 0;
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 2; j++) {
        if (!isPossible(row - 1 + i, col - 1 + j)) {
          continue;
        }
        if (map[row - 1 + i][col - 1 + j]) {
          count++;
        }
      }
    }
    return count != 0 && count != 4;
  }

  private static boolean isPossible(int row, int col) {
    return row >= 0 && col >= 0;
  }

  /*
   * [1,1,7,4]의 사각형이 있을 때,
   * (1,1) ~ (1,7)의 길만 다닐 수 있음.
   * 다닐 수 있는 길은 인도(1)로 표시(이미 못다니는 길이면 변경X)
   * 사각형 한칸 안쪽은 못다니는 길(2)로 표시
   *
   *
   * 9 x x x x x x x x x x
   * 8 x x x x o o x x x x
   * 7 x x o o o o o o x x
   * 6 x x o o o o o o x x
   * 5 x x x x o o x x x x
   * 4 x x x o o o x x x x
   * 3 x o o o o o o x x x
   * 2 x o o o o o o x x x
   * 1 x o o o o o o x x x
   * 0 x x x x x x x x x x
   *   0 1 2 3 4 5 6 7 8 9
   * */
  private static void fillMap(int[] rectangle) {
    for (int i = rectangle[0]; i < rectangle[2]; i++) {
      for (int j = rectangle[1]; j < rectangle[3]; j++) {
        map[i][j] = true;
      }
    }
  }

  static class Node {

    int row;
    int col;

    public Node(int row, int col) {
      this.row = row;
      this.col = col;
    }
  }
}

