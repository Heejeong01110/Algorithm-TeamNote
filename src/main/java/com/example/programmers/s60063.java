package com.example.programmers;

import java.util.ArrayDeque;
import java.util.Queue;

//블록 이동하기
public class s60063 {

  private static int width;

  public static int solution(int[][] board) {
    width = board.length;
    boolean[][][] visited = new boolean[width][width][2]; // //0 : 가로, 1 : 세로
    Queue<Node> queue = new ArrayDeque<>();
    queue.add(new Node(0, 0, 0));
    visited[0][0][0] = true;

    Node[] moveNodes = new Node[8];
    for (int i = 0; i < 8; i++) {
      moveNodes[i] = new Node(0, 0, 0);
    }

    int count = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();

      for (int i = 0; i < size; i++) {
        Node now = queue.poll();
        if (isEnd(now)) {
          return count;
        }

        if (now.direct == 0) {
          moveNodes[0].setInfo(now.row, now.col + 1, 0);
          moveNodes[1].setInfo(now.row, now.col - 1, 0);
          moveNodes[2].setInfo(now.row, now.col + 1, 1);
          moveNodes[3].setInfo(now.row - 1, now.col + 1, 1);
          moveNodes[4].setInfo(now.row, now.col, 1);
          moveNodes[5].setInfo(now.row - 1, now.col, 1);
          moveNodes[6].setInfo(now.row + 1, now.col, 0);//위
          moveNodes[7].setInfo(now.row - 1, now.col, 0);//아래
        } else {
          moveNodes[0].setInfo(now.row + 1, now.col, 1);
          moveNodes[1].setInfo(now.row - 1, now.col, 1);
          moveNodes[2].setInfo(now.row + 1, now.col, 0);
          moveNodes[3].setInfo(now.row, now.col, 0);
          moveNodes[4].setInfo(now.row + 1, now.col - 1, 0);
          moveNodes[5].setInfo(now.row, now.col - 1, 0);
          moveNodes[6].setInfo(now.row, now.col + 1, 1);//좌
          moveNodes[7].setInfo(now.row, now.col - 1, 1);//우
        }

        for (int j = 0; j < 8; j++) {
          if (check(board, moveNodes[j]) && canTurn(now, moveNodes[j], board)
              && !visited[moveNodes[j].row][moveNodes[j].col][moveNodes[j].direct]) {
            Node move = new Node(moveNodes[j].row, moveNodes[j].col, moveNodes[j].direct);
            visited[moveNodes[j].row][moveNodes[j].col][moveNodes[j].direct] = true;
            queue.add(move);
          }
        }
      }

      count++;
    }

    return count;
  }

  private static boolean canTurn(Node now, Node moveNode, int[][] board) {
    if (now.direct == moveNode.direct) {
      return true;
    }

    if (now.row == moveNode.row && now.col == moveNode.col) {
      if (board[now.row + 1][now.col + 1] == 1) {
        return false;
      }
    } else if (now.row == moveNode.row) {
      int checkCol = Math.min(now.col, moveNode.col);
      if (board[now.row + 1][checkCol] == 1) {
        return false;
      }
    } else if (now.col == moveNode.col) {
      int checkRow = Math.min(now.row, moveNode.row);
      if (board[checkRow][now.col + 1] == 1) {
        return false;
      }
    } else {
      int checkRow = Math.min(now.row, moveNode.row);
      int checkCol = Math.min(now.col, moveNode.col);
      if (board[checkRow][checkCol] == 1) {
        return false;
      }
    }
    return true;
  }

  private static boolean check(int[][] board, Node node) {
    int nearR = node.direct == 0 ? node.row : node.row + 1;
    int nearC = node.direct == 0 ? node.col + 1 : node.col;
    if (node.row >= 0 && node.row < width && node.col >= 0 && node.col < width
        && nearR >= 0 && nearR < width && nearC >= 0 && nearC < width) {
      if (board[node.row][node.col] == 0 && board[nearR][nearC] == 0) {
        return true;
      }
    }
    return false;
  }

  private static boolean isEnd(Node now) {
    if (now.row == width - 2 && now.col == width - 1 && now.direct == 1) {
      return true;
    }
    if (now.row == width - 1 && now.col == width - 2 && now.direct == 0) {
      return true;
    }
    return false;
  }

  private static class Node {

    int row;
    int col;
    int direct;

    public Node(int row, int col, int direct) {
      this.row = row;
      this.col = col;
      this.direct = direct; //0 : 가로, 1 : 세로
    }

    public void setInfo(int row, int col, int direct) {
      this.row = row;
      this.col = col;
      this.direct = direct; //0 : 가로, 1 : 세로
    }

  }
}
