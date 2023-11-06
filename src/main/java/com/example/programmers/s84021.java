package com.example.programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class s84021 {

  private static final int[][] dir = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
  private static int length;

  public static int solution(int[][] game_board, int[][] table) {

    length = game_board.length;

    ArrayList<ArrayList<int[]>> puzzles = new ArrayList<>();
    for (int i = 0; i < length; i++) {
      for (int j = 0; j < length; j++) {
        if (table[i][j] == 1) {
          puzzles.add(getShape(table, i, j, 1));
        }
      }
    }

    int answer = 0;

    for (int i = 0; i < length; i++) {
      for (int j = 0; j < length; j++) {
        if (game_board[i][j] == 0) {
          ArrayList<int[]> shape = getShape(game_board, i, j, 0);

          for (int k = 0; k < puzzles.size(); k++) {
            if (isSamePuzzle(puzzles.get(k), shape)) {
              answer += shape.size();
              puzzles.remove(k);
              break;
            }
          }
        }
      }
    }

    return answer;
  }

  private static boolean isSamePuzzle(ArrayList<int[]> puzzle, ArrayList<int[]> shape) {
    if (puzzle.size() != shape.size()) {
      return false;
    }
    for (int t = 0; t < 4; t++) {
      if (t != 0) {
        turnRight(puzzle);
      }

      if (isSameShape(puzzle, shape)) {
        return true;
      }
    }
    return false;
  }

  private static boolean isSameShape(ArrayList<int[]> puzzle, ArrayList<int[]> shape) {
    for (int i = 0; i < shape.size(); i++) {
      if (puzzle.get(i)[0] != shape.get(i)[0] || puzzle.get(i)[1] != shape.get(i)[1]) {
        return false;
      }
    }
    return true;
  }

  private static ArrayList<int[]> turnRight(ArrayList<int[]> puzzle) {

    puzzle.sort((o1, o2) -> {
      if (o1[1] == o2[1]) {
        return o2[0] - o1[0];
      }
      return o1[1] - o2[1];
    });

    int sr = puzzle.get(0)[0];
    int sc = puzzle.get(0)[1];
    puzzle.get(0)[0] = 0;
    puzzle.get(0)[1] = 0;

    for (int i = 1; i < puzzle.size(); i++) {
      int br = puzzle.get(i)[0] - sr;
      int bc = puzzle.get(i)[1] - sc;
      puzzle.get(i)[0] = bc;
      puzzle.get(i)[1] = -br;
    }

    return puzzle;
  }


  private static ArrayList<int[]> getShape(int[][] game_board, int sr, int sc, int n) {
    int tmp = (n + 1) % 2;
    ArrayList<int[]> shape = new ArrayList<>();

    Queue<int[]> queue = new LinkedList<>();

    queue.add(new int[]{sr, sc});
    shape.add(new int[]{sr - sr, sc - sc});
    game_board[sr][sc] = tmp;

    while (!queue.isEmpty()) {
      int[] now = queue.poll();

      for (int d = 0; d < dir.length; d++) {
        int nr = now[0] + dir[d][0];
        int nc = now[1] + dir[d][1];

        if (isPossible(nr, nc) && game_board[nr][nc] == n) {
          queue.add(new int[]{nr, nc});
          shape.add(new int[]{nr - sr, nc - sc});
          game_board[nr][nc] = tmp;
        }
      }
    }

    shape.sort((o1, o2) -> {
      if (o1[0] == o2[0]) {
        return o1[1] - o2[1];
      }
      return o1[0] - o2[0];
    });
    return shape;
  }

  private static boolean isPossible(int nx, int ny) {
    return nx >= 0 && nx < length && ny >= 0 && ny < length;
  }

}
