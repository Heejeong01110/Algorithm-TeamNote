package com.example.programmers;

import java.util.ArrayDeque;
import java.util.Queue;

//블록 이동하기
public class s60063 {

  static private Integer result;
  static private Integer HEIGHT;

  public static int solution(int[][] board) {
    result = Integer.MAX_VALUE;
    HEIGHT = board.length;

    boolean[][][] visited = new boolean[HEIGHT][HEIGHT][2];
    visited[0][0][0] = true;
    dfs(0, 0, 0, 0, board, visited);
    return result;
  }

  private static void bfs(int[][] board, boolean[][][] visited) {
    Queue<Node> queue = new ArrayDeque<>();

    int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int[] rotate = {-1, 1};

    queue.add(new Node(0, 0, 0));

    while (!queue.isEmpty()) {
      int size = queue.size();
      int depth = 0;

      for (int i = 0; i < size; i++) {
        Node now = queue.poll();

        //종료 체크
        if ((now.r == board.length - 2 && now.c == board.length - 1)
            || now.r == board.length - 1 && now.c == board.length - 2) {
          result = depth;
          return;
        }

        for (int d = 0; d < 4; d++) {
          //회전 없이
          int nr = now.r + dir[d][0];
          int nc = now.c + dir[d][1];
          int ndir = now.direct;

          if (isPossibleVisit(board, visited, nr, nc, ndir)) {
            Node addNode = new Node(nr, nc, ndir);
          }
        }

        depth++;
      }

    }
  }

  private static void dfs(int row, int col, int direct, int depth, int[][] board,
      boolean[][][] visited) {
    if (depth > result) {
      return;
    }

    if ((row == board.length - 2 && col == board.length - 1)
        || row == board.length - 1 && col == board.length - 2) {
      result = Math.min(result, depth);
      return;
    }

    int[] dr = new int[]{1, -1, 0, 0};
    int[] dc = new int[]{0, 0, 1, -1};

    int[] tr = new int[]{-1, 1, -1, 1};
    int[] tc = new int[]{0, 0, 1, 1};

    for (int i = 0; i < 4; i++) {
      //회전 없이
      int cRow = row + dr[i];
      int cCol = col + dc[i];
      if (isPossibleVisit(board, visited, cRow, cCol, direct)) {
        visited[cRow][cCol][direct] = true;
        dfs(cRow, cCol, direct, depth + 1, board, visited);
        visited[cRow][cCol][direct] = false;
      }
    }

    for (int i = 0; i < 4; i++) {
      int cr;
      int cc;
      if (direct == 0) {
        cr = tr[i];
        cc = tc[i];
      } else {
        cr = tc[i];
        cc = tr[i];
      }
      //회전
      if (isPossibleTurn(board, visited, row, col, cr, cc, direct)) {
        int cRow, cCol;
        if (direct == 0) {
          if (cr == -1) {
            cRow = row - 1;
            cCol = cc == 0 ? col + 1 : col;
          } else {
            cRow = row;
            cCol = cc == 0 ? col + 1 : col;
          }
        } else {
          if (cc == -1) {
            cRow = cr == 0 ? row + 1 : row;
            cCol = col - 1;
          } else {
            cRow = cr == 0 ? row + 1 : row;
            cCol = col;
          }
        }

        visited[cRow][cCol][(direct + 1) % 2] = true;
        dfs(cRow, cCol, (direct + 1) % 2, depth + 1, board, visited);
        visited[cRow][cCol][(direct + 1) % 2] = false;
      }


    }

  }

  private static boolean isPossibleTurn(int[][] board, boolean[][][] visited, int row, int col,
      int tr, int tc, int direct) {
    if (row + tr >= 0 && row + tr < HEIGHT && col + tc >= 0 && col + tc < HEIGHT) {
      if (board[row + tr][col + tc] == 1) {
        return false;
      }
    }

    int cRow, cCol;
    if (direct == 0) {
      if (tr == -1) {
        cRow = row - 1;
        cCol = tc == 0 ? col + 1 : col;
      } else {
        cRow = row;
        cCol = tc == 0 ? col + 1 : col;
      }
    } else {
      if (tc == -1) {
        cRow = tr == 0 ? row + 1 : row;
        cCol = col - 1;
      } else {
        cRow = tr == 0 ? row + 1 : row;
        cCol = col;
      }
    }

    return isPossibleVisit(board, visited, cRow, cCol, (direct + 1) % 2);
  }

  private static boolean isPossibleVisit(int[][] board, boolean[][][] visited, int row, int col,
      int direct) {
    if (row < 0 || row >= HEIGHT || col < 0 || col >= HEIGHT || visited[row][col][direct]
        || board[row][col] == 1) {
      return false;
    }
    int anotherR;
    int anotherC;
    if (direct == 0) {
      anotherR = row;
      anotherC = col + 1;
    } else {
      anotherR = row + 1;
      anotherC = col;
    }
    if (anotherR >= HEIGHT || anotherC >= HEIGHT || board[anotherR][anotherC] == 1) {
      return false;
    }
    return true;
  }

  private static class Node {

    int r;
    int c;
    int direct;

    public Node(int r, int c, int direct) {
      this.r = r;
      this.c = c;
      this.direct = direct;
    }
  }
}
