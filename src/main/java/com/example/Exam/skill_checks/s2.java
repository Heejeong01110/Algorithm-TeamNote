package com.example.Exam.skill_checks;

import java.util.ArrayDeque;
import java.util.Queue;

//카카오배 로봇경진대회
public class s2 {

  private static int width;

  public static int solution(int[][] board) {
    int answer = 0;
    width = board.length;
    boolean[][][] visited = new boolean[width][width][2]; // //0 : 가로, 1 : 세로
    Queue<Node> queue = new ArrayDeque<>();
    queue.add(new Node(0, 0, 0));
    visited[0][0][0] = true;

    Node[] moveNodes = new Node[6];
    for (int i = 0; i < 6; i++) {
      moveNodes[i] = new Node(0, 0, 0);
    }

    int count = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();

      for (int i = 0; i < size; i++) {
        Node now = queue.poll();
        if (isEnd(now)) {
          break;
        }

        if (now.direct == 0) {
          moveNodes[0].setInfo(now.row, now.col + 1, 0);
          moveNodes[1].setInfo(now.row, now.col - 1, 0);
          moveNodes[2].setInfo(now.row, now.col + 1, 1);
          moveNodes[3].setInfo(now.row - 1, now.col + 1, 1);
          moveNodes[4].setInfo(now.row, now.col, 1);
          moveNodes[5].setInfo(now.row - 1, now.col, 1);
        } else {
          moveNodes[0].setInfo(now.row + 1, now.col, 1);
          moveNodes[1].setInfo(now.row - 1, now.col, 1);
          moveNodes[2].setInfo(now.row + 1, now.col, 0);
          moveNodes[3].setInfo(now.row, now.col, 0);
          moveNodes[5].setInfo(now.row + 1, now.col - 1, 0);
          moveNodes[4].setInfo(now.row, now.col - 1, 0);
        }

        for (int j = 0; j < 6; j++) {
          if (check(board, moveNodes[j])
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

  private static boolean check(int[][] board, Node n) {
    int nearR = n.direct == 0 ? n.row : n.row + 1;
    int nearC = n.direct == 0 ? n.col + 1 : n.col;
    if (n.row >= 0 && n.row < width && n.col >= 0 && n.col < width
        && nearR >= 0 && nearR < width && nearC >= 0 && nearC < width) {
      //회전 시 1인지 아닌지 체크
      if (board[n.row][n.col] == 0 && board[nearR][nearC] == 0) {
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

    @Override
    protected Object clone() throws CloneNotSupportedException {
      return super.clone();
    }
  }
}
