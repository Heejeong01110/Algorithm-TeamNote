package com.example.programmers;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class s84021 {

  private static final int[][] direct = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

  public static int solution(int[][] game_board, int[][] table) {
    int answer = -1;

    boolean[][] visitedBoard = new boolean[game_board.length][game_board[0].length];
    boolean[][] visitedTable = new boolean[table.length][table[0].length];

    ArrayList<ArrayList<int[]>> boardList = new ArrayList<>();
    ArrayList<ArrayList<int[]>> tableList = new ArrayList<>();

    for (int i = 0; i < game_board.length; i++) {
      for (int j = 0; j < game_board[0].length; j++) {
        if (game_board[i][j] == 0 && !visitedBoard[i][j]) {
          bfs(i, j, visitedBoard, game_board, 0, boardList);
        }

        if (table[i][j] == 1 && !visitedTable[i][j]) {
          bfs(i, j, visitedTable, table, 1, tableList);
        }
      }
    }

    answer = findBlock(boardList, tableList);

    return answer;
  }

  private static int findBlock(ArrayList<ArrayList<int[]>> boards,
      ArrayList<ArrayList<int[]>> tables) {
    int size = 0;
    int tableSize = tables.size();
    int boardSize = boards.size();

    boolean[] visited = new boolean[boardSize];

    for (int i = 0; i < tableSize; i++) {
      ArrayList<int[]> table = tables.get(i);

      for (int j = 0; j < boardSize; j++) {
        ArrayList<int[]> board = boards.get(j);

        if (table.size() == board.size() && !visited[j]) {
          if (isRotate(table, board)) {
            size += table.size();
            visited[j] = true;
            break;
          }
        }
      }
    }
    return size;
  }

  private static boolean isRotate(ArrayList<int[]> table, ArrayList<int[]> board) {
    boolean result = false;

    board.sort((o1, o2) -> {
      if (o1[0] == o2[0]) {
        return o1[1] - o2[1];
      }
      return o1[0] - o2[0];
    });

    for (int i = 0; i < 4; i++) {
      table.sort((o1, o2) -> {
        if (o1[0] == o2[0]) {
          return o1[1] - o2[1];
        }
        return o1[0] - o2[0];
      });

      int pr = table.get(0)[0];
      int pc = table.get(0)[1];

      for (int j = 0; j < table.size(); j++) {
        table.get(j)[0] -= pr;
        table.get(j)[1] -= pc;
      }

      boolean isCollectPoint = true;
      for (int j = 0; j < board.size(); j++) {
        if (board.get(j)[0] != table.get(j)[0] || board.get(j)[1] != table.get(j)[1]) {
          isCollectPoint = false;
          break;
        }
      }

      if (isCollectPoint) {
        result = true;
        break;
      } else {//90도 회전 : x,y -> y, -x
        for (int j = 0; j < table.size(); j++) {
          int temp = table.get(j)[0];
          table.get(j)[0] = table.get(1)[1];
          table.get(j)[1] = -temp;
        }
      }
    }
    return result;
  }

  private static void bfs(int row, int col, boolean[][] visited, int[][] board, int check,
      ArrayList<ArrayList<int[]>> boardList) {
    Queue<int[]> queue = new ArrayDeque<>();
    ArrayList<int[]> subList = new ArrayList<>();

    visited[row][col] = true;
    queue.add(new int[]{row, col});
    subList.add(new int[]{row - row, col - col});

    while (!queue.isEmpty()) {
      int[] now = queue.poll();

      for (int i = 0; i < 4; i++) {
        int nr = now[0] + direct[i][0];
        int nc = now[1] + direct[i][1];

        if (isPossible(nr, nc, board.length, board[0].length)
            && !visited[nr][nc]
            && board[nr][nc] == check) {

          visited[nr][nc] = true;
          queue.add(new int[]{nr, nc});
          subList.add(new int[]{nr - row, nc - col});
        }
      }
    }

    boardList.add(subList);
  }

  private static boolean isPossible(int nx, int ny, int N, int M) {
    return nx >= 0 && nx < N && ny >= 0 && ny < M;
  }

}
