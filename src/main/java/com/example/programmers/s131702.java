package com.example.programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class s131702 {

  private static int[][] dir = new int[][]{{0, 0}, {0, 1}, {0, -1}, {1, 0}, {-1, 0}};
  private static int[][] originPuzzle;
  private static int N, res;

  public static int solution(int[][] clockHands) {
    int answer = 0;
    N = clockHands.length;
    res = Integer.MAX_VALUE;
    originPuzzle = clockHands;

    int[] tmp = new int[N];

    dfs(tmp, 0);

    return answer;
  }

  private static void dfs(int[] rotation, int depth) {
    if (depth == N) {//한줄 회전 결정
      int[][] clone = clone(originPuzzle, rotation);
      int move = 0;
      //다음 줄 부터 이전 배열을 통해서 회전시킨다.
      move += rotationPuzzle(clone);
      //퍼즐이 정답인지 확인한다. 정답이면 사용한 회전 수를 갱신한다.
      if (isAligned(clone)) {
        res = Math.min(res, move);
      }
      return;
    }
    for (int degree = 0; degree < 4; degree++) {
      rotation[depth] = degree;
      dfs(rotation, depth + 1);
    }
  }

  public static int[][] clone(int[][] puzzle, int[] firstDirect) {
    int[][] clone = new int[puzzle.length + 1][puzzle[0].length];
    Arrays.setAll(clone[0], col -> firstDirect[col]);
    for (int i = 0; i < puzzle.length; i++) {
      int row = i;
      Arrays.setAll(clone[i + 1], col -> puzzle[row][col]);
    }
    return clone;
  }

  public static void rotation(int r, int c, int degree, int[][] puzzle) {
    List<int[]> rotationIndexes = getNear(r, c, puzzle);
    for (int[] index : rotationIndexes) {
      int nr = index[0], nc = index[1];
      puzzle[nr][nc] = (puzzle[nr][nc] + degree) % 4;
    }
  }

  public static List<int[]> getNear(int r, int c, int[][] puzzle) {
    List<int[]> result = new LinkedList<>();
    for (int d = 0; d < dir.length; d++) {
      int nr = r + dir[d][0];
      int nc = c + dir[d][1];
      if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
        result.add(new int[]{nr, nc});
      }
    }
    return result;
  }

  public static int rotationPuzzle(int[][] puzzle) {
    int count = 0;
    for (int row = 1; row < puzzle.length; row++) {
      for (int col = 0; col < puzzle[0].length; col++) {
        //위 줄의 방향을 확인하고 회전 각도 결정
        int degree = (4 - puzzle[row - 1][col]) % 4;
        if (degree != 0) {
          count += degree;
          rotation(row, col, degree, puzzle);
        }
      }
    }
    return count;
  }

  public static boolean isAligned(int[][] puzzle) {
    for (int[] row : puzzle) {
      for (int component : row) {
        if (component != 0) {
          return false;
        }
      }
    }
    return true;
  }


}
