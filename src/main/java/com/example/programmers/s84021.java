package com.example.programmers;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class s84021 {

  private static final int[][] direct = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
  private static boolean[][] visitedBoard;
  private static boolean[][] visitedTable;
  private static int length;

  public static int solution(int[][] game_board, int[][] table) {

    length = game_board.length;
    visitedBoard = new boolean[length][length];
    visitedTable = new boolean[length][length];

    for (int i = 0; i < length; i++) {
      for (int j = 0; j < length; j++) {
        visitedBoard[i][j] = game_board[i][j] == 0; //블럭이 true, 배경이 false
        visitedTable[i][j] = table[i][j] == 1; //블럭이 true, 배경이 false
      }
    }

    ArrayList<boolean[][]> insertBlocks = new ArrayList<>();
    ArrayList<boolean[][]> blankBlocks = new ArrayList<>();

    for (int i = 0; i < length; i++) {
      for (int j = 0; j < length; j++) {
        if (visitedBoard[i][j]) {
          blankBlocks.add(createBlock(visitedBoard, i, j));
        }
        if (visitedTable[i][j]) {
          insertBlocks.add(createBlock(visitedTable, i, j));
        }
      }
    }

    int answer = 0;
    for (boolean[][] insertBlock : insertBlocks) {
      for (boolean[][] blankBlock : blankBlocks) {
        if (isCorrectBlock(insertBlock, blankBlock)) {
          answer += countItems(insertBlock);
          blankBlocks.remove(blankBlock);
          break;
        }
      }
    }

    return answer;
  }

  private static int countItems(boolean[][] block) {
    int count = 0;
    for (int i = 0; i < block.length; i++) {
      for (int j = 0; j < block[0].length; j++) {
        count += block[i][j] ? 1 : 0;
      }
    }
    return count;
  }

  private static boolean isCorrectBlock(boolean[][] insertBlock, boolean[][] blankBlock) {
    //1. 비교
    for (int d = 0; d < 4; d++) {
      if (isSameBlock(insertBlock, blankBlock)) {
        return true;
      }

      //2. 회전
      insertBlock = turnRight(insertBlock);
    }
    return false;
  }

  private static boolean[][] turnRight(boolean[][] block) {
    int maxRow = block.length - 1;
    int maxCol = block[0].length - 1;

    boolean[][] result = new boolean[block[0].length][block.length];

    for (int i = 0; i <= maxRow; i++) {
      for (int j = 0; j <= maxCol; j++) {
        result[j][maxRow - i] = block[i][j];
      }
    }

    return result;
  }

  private static boolean isSameBlock(boolean[][] insertBlock, boolean[][] blankBlock) {
    if (insertBlock.length != blankBlock.length
        || insertBlock[0].length != blankBlock[0].length) {
      return false;
    }

    for (int i = 0; i < insertBlock.length; i++) {
      for (int j = 0; j < insertBlock[0].length; j++) {
        if (insertBlock[i][j] != blankBlock[i][j]) {
          return false;
        }
      }
    }

    return true;
  }

  private static boolean[][] createBlock(boolean[][] table, int row, int col) {
    ArrayList<int[]> nodes = new ArrayList<>();
    Queue<int[]> queue = new ArrayDeque<>();
    boolean[][] visited = new boolean[length][length];
    int maxRow = row, minRow = row, maxCol = col, minCol = col;

    visited[row][col] = true;
    queue.add(new int[]{row, col});
    nodes.add(new int[]{row, col});

    while (!queue.isEmpty()) {
      int[] now = queue.poll();

      for (int i = 0; i < 4; i++) {
        int nr = now[0] + direct[i][0];
        int nc = now[1] + direct[i][1];

        if (isPossible(nr, nc) && !visited[nr][nc] && table[nr][nc]) {
          maxRow = Math.max(maxRow, nr);
          minRow = Math.min(minRow, nr);
          maxCol = Math.max(maxCol, nc);
          minCol = Math.min(minCol, nc);

          queue.add(new int[]{nr, nc});
          visited[nr][nc] = true;
          nodes.add(new int[]{nr, nc});
        }
      }
    }

    boolean[][] result = new boolean[maxRow - minRow + 1][maxCol - minCol + 1];
    for (int[] node : nodes) {
      result[node[0] - minRow][node[1] - minCol] = true;
      table[node[0]][node[1]] = false;
    }

    return result;
  }

  private static boolean isPossible(int nx, int ny) {
    return nx >= 0 && nx < length && ny >= 0 && ny < length;
  }

}
