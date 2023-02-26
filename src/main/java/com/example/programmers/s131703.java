package com.example.programmers;

public class s131703 {

  private static int ROW_LEN;
  private static int COL_LEN;
  private static int[][] table;

  public static int solution(int[][] beginning, int[][] target) {
    int answer = Integer.MAX_VALUE;
    ROW_LEN = beginning.length;
    COL_LEN = beginning[0].length;

    int[] result = new int[4];
    result[0] = rowFirst(beginning, target);
    result[1] = colFirst(beginning, target);
    result[2] = rowDFirst(beginning, target);
    result[3] = colDFirst(beginning, target);

    for (int i = 0; i < 4; i++) {
      if (result[i] != -1) {
        answer = Math.min(answer, result[i]);
      }
    }
    if(answer == Integer.MAX_VALUE){
      return -1;
    }
    return answer;
  }

  private static int rowFirst(int[][] beginning, int[][] target) {
    int answer = 0;
    table = new int[ROW_LEN][COL_LEN];
    for (int i = 0; i < ROW_LEN; i++) {
      table[i] = beginning[i].clone();
    }

    for (int i = 0; i < ROW_LEN; i++) {
      if (table[i][0] != target[i][0]) {
        convertRow(i);
        answer++;
      }
    }

    for (int i = 0; i < COL_LEN; i++) {
      if (table[0][i] != target[0][i]) {
        convertCol(i);
        answer++;
      }
    }

    for (int i = 0; i < ROW_LEN; i++) {
      for (int j = 0; j < COL_LEN; j++) {
        if (table[i][j] != target[i][j]) {
          return -1;
        }
      }
    }
    return answer;
  }


  private static int rowDFirst(int[][] beginning, int[][] target) {
    int answer = 0;
    table = new int[ROW_LEN][COL_LEN];
    for (int i = 0; i < ROW_LEN; i++) {
      table[i] = beginning[i].clone();
    }

    for (int i = 0; i < ROW_LEN; i++) {
      if (table[i][0] == target[i][0]) {
        convertRow(i);
        answer++;
      }
    }

    for (int i = 0; i < COL_LEN; i++) {
      if (table[0][i] != target[0][i]) {
        convertCol(i);
        answer++;
      }
    }

    for (int i = 0; i < ROW_LEN; i++) {
      for (int j = 0; j < COL_LEN; j++) {
        if (table[i][j] != target[i][j]) {
          return -1;
        }
      }
    }
    return answer;
  }

  private static int colFirst(int[][] beginning, int[][] target) {
    int answer = 0;
    table = new int[ROW_LEN][COL_LEN];
    for (int i = 0; i < ROW_LEN; i++) {
      table[i] = beginning[i].clone();
    }

    for (int i = 0; i < COL_LEN; i++) {
      if (table[0][i] != target[0][i]) {
        convertCol(i);
        answer++;
      }
    }

    for (int i = 0; i < ROW_LEN; i++) {
      if (table[i][0] != target[i][0]) {
        convertRow(i);
        answer++;
      }
    }

    for (int i = 0; i < ROW_LEN; i++) {
      for (int j = 0; j < COL_LEN; j++) {
        if (table[i][j] != target[i][j]) {
          return -1;
        }
      }
    }

    return answer;
  }


  private static int colDFirst(int[][] beginning, int[][] target) {
    int answer = 0;
    table = new int[ROW_LEN][COL_LEN];
    for (int i = 0; i < ROW_LEN; i++) {
      table[i] = beginning[i].clone();
    }

    for (int i = 0; i < COL_LEN; i++) {
      if (table[0][i] == target[0][i]) {
        convertCol(i);
        answer++;
      }
    }

    for (int i = 0; i < ROW_LEN; i++) {
      if (table[i][0] != target[i][0]) {
        convertRow(i);
        answer++;
      }
    }

    for (int i = 0; i < ROW_LEN; i++) {
      for (int j = 0; j < COL_LEN; j++) {
        if (table[i][j] != target[i][j]) {
          return -1;
        }
      }
    }

    return answer;
  }

  private static void convertCol(int col) {
    for (int i = 0; i < ROW_LEN; i++) {
      table[i][col] = (table[i][col] + 1) % 2;
    }
  }

  private static void convertRow(int row) {
    for (int i = 0; i < COL_LEN; i++) {
      table[row][i] = (table[row][i] + 1) % 2;
    }
  }

}
