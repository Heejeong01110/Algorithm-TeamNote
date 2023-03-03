package com.example.programmers;

public class s92345 {

  private static final int[][] direct = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
  private static int answer;
  private static int N;
  private static int M;

  public static int solution(int[][] board, int[] aloc, int[] bloc) {
    answer = Integer.MAX_VALUE;
    N = board.length;
    M = board[0].length;

    return answer;
  }

  private static boolean isPossible(int row, int col) {
    return row >= 0 && row < N && col >= 0 && col < M;
  }

  public Result dfs(int nowRow, int nowCol, int nearRow, int nearCol, int depth, int[][] board) {

    boolean win = false;
    int minCount = 5 * 5;
    int maxCount = depth;

    if (board[nowRow][nowCol] == 1) {
      for (int i = 0; i < 4; i++) {
        int nextRow = nowRow + direct[i][0];
        int nextCol = nowCol + direct[i][1];

        if (isPossible(nextRow, nextCol) && board[nextRow][nextCol] == 1) {
          board[nowRow][nowCol] = 0;

          Result res = dfs(nearRow, nearCol, nextRow, nextCol, depth + 1, board);
          win = win || !res.win;
          if (!res.win) {
            minCount = Math.min(minCount, res.count);
          } else {
            maxCount = Math.max(maxCount, res.count);
          }

          board[nowRow][nowCol] = 1;
        }
      }
    }

    return new Result(win, win ? minCount : maxCount);
  }

  private static class Result {

    boolean win;
    int count;

    public Result(boolean win, int count) {
      this.win = win;
      this.count = count;
    }
  }

}
