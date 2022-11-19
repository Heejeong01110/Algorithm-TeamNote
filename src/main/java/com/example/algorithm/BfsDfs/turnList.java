package com.example.algorithm.BfsDfs;

public class turnList {

  public static void main(String[] args) {
    int[][] board = new int[][]{
        {1, 1, 0, 0, 1, 0},
        {0, 0, 1, 0, 1, 0},
        {0, 1, 1, 0, 0, 1},
        {1, 1, 0, 1, 1, 1},
        {1, 0, 0, 0, 1, 0},
        {0, 1, 1, 1, 0, 0}};

    int[][] turnBoard = turnRight(board);

    printBlock(turnBoard);
  }


  private static void printBlock(int[][] block) {
    for (int i = 0; i < block.length; i++) {
      for (int j = 0; j < block[0].length; j++) {
        System.out.print(block[i][j] + " ");
      }
      System.out.println(" ");
    }
    System.out.println(" ");
  }

  private static int[][] turnRight(int[][] block) {
    int maxRow = block.length - 1;
    int maxCol = block[0].length - 1;

    int[][] result = new int[block[0].length][block.length];

    for (int i = 0; i <= maxRow; i++) {
      for (int j = 0; j <= maxCol; j++) {
        result[j][maxRow - i] = block[i][j];
      }
    }

    return result;
  }
}
