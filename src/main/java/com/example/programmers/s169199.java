package com.example.programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class s169199 {

  private static int[][] direct = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
  private int rowLen;
  private int colLen;

  public int solution(String[] board) {
    int answer = -1;
    rowLen = board.length;
    colLen = board[0].length();
    int[][] map = new int[rowLen][colLen];

    for (int i = 0; i < rowLen; i++) {
      Arrays.fill(map[i], Integer.MAX_VALUE);
    }

    Node start = new Node(-1, -1, -1);
    Node end = new Node(-1, -1, -1);
    for (int i = 0; i < rowLen; i++) {
      for (int j = 0; j < colLen; j++) {
        if (board[i].charAt(j) == 'R') {
          start = new Node(i, j, 0);
        } else if (board[i].charAt(j) == 'G') {
          end = new Node(i, j, 0);
        }
      }
    }

    PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
    queue.add(start);
    map[start.row][start.col] = 0;

    while (!queue.isEmpty()) {
      Node now = queue.poll();

      if (now.row == end.row && now.col == end.col) {
        answer = now.cost;
        break;
      }

      for (int i = 0; i < 4; i++) {

        int[] loc = getLoc(board, now.row, now.col, direct[i]);

        if (isPossible(loc[0], loc[1]) && map[loc[0]][loc[1]] > now.cost + 1) {
          queue.add(new Node(loc[0], loc[1], now.cost + 1));
          map[loc[0]][loc[1]] = now.cost + 1;
        }
      }


    }

    return answer;
  }

  private int[] getLoc(String[] board, int row, int col, int[] direct) {
    int[] loc = new int[]{row, col};
    if (direct[0] == 0) {

      for (int i = 0; i < colLen; i++) {
        if (isPossible(loc[0], loc[1] + direct[1])) {
          if (board[loc[0]].charAt(loc[1] + direct[1]) == 'D') {
            return loc;
          } else {
            loc[1] += direct[1];
          }
        } else {
          break;
        }
      }

    } else if (direct[1] == 0) {

      for (int i = 0; i < rowLen; i++) {
        if (isPossible(loc[0] + direct[0], loc[1])) {
          if (board[loc[0] + direct[0]].charAt(loc[1]) == 'D') {
            return loc;
          } else {
            loc[0] += direct[0];
          }
        } else {
          break;
        }
      }

    }
    return loc;
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
