package com.example.programmers;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class s42894 {

  public static int solution(int[][] board) {
    int answer = 0;

    boolean[] empty = new boolean[board[0].length];
    Arrays.fill(empty, true);

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if(empty[j]){
          if (board[i][j] != 0) {
            board = dfs(board, i, j);
            if(board[i][j] != 0){
              empty[j] = false;
            }
          }
        }

      }
    }
    return answer;
  }

  private static int[][] dfs(int[][] board, int row, int col) {

    Queue<Node> queue = new ArrayDeque<>();

    return board;
  }
  private static class Node{
    int row;
    int col;

    public Node(int row, int col) {
      this.row = row;
      this.col = col;
    }
  }
}
