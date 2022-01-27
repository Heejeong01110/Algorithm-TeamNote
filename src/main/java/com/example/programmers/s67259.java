package com.example.programmers;

import java.util.Comparator;
import java.util.PriorityQueue;

//경주로 건설
public class s67259 {

  private static int[] dr = {1, 0, -1, 0}; //하좌상우
  private static int[] dc = {0, 1, 0, -1};
  private static int width, minCost;

  public static int solution(int[][] board) {
    width = board.length;
    minCost = Integer.MAX_VALUE;

    boolean[][][] visited;
    for (int i = 0; i < 4; i++) {
      visited = new boolean[board.length][board.length][4];
      bfs(visited, board, i);
    }

    return minCost;
  }

  private static void bfs(boolean[][][] visited, int[][] board, int dir) {
    PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparing(o -> o.cost));

    queue.add(new Node(0,0,0,dir));

    while (!queue.isEmpty()) {
      Node currentNode = queue.poll();

      if (currentNode.row == width - 1 && currentNode.col == width - 1) {
        minCost = Math.min(minCost, currentNode.cost);
        return;
      }

      if (visited[currentNode.row][currentNode.col][currentNode.dir]) {
        continue;
      }
      visited[currentNode.row][currentNode.col][currentNode.dir] = true;

      for (int i = 0; i < 4; i++) {
        int row = currentNode.row + dr[i];
        int col = currentNode.col + dc[i];
        if (!isPossibleVisit(board, row, col)) {
          continue;
        }

        if (currentNode.dir == i) {
          queue.add(new Node(row, col, currentNode.cost + 100, i));
        } else {
          queue.add(new Node(row, col, currentNode.cost + 600, i));

        }

      }
    }
  }

  private static boolean isPossibleVisit(int[][] board, int row, int col) {
    if (row < 0 || col < 0 || row >= width || col >= width) {
      return false;
    }

    if (board[row][col] == 1) {
      return false;
    }

    return true;
  }

  private static class Node {

    int row;
    int col;
    int cost;
    int dir;

    public Node(int row, int col, int cost, int dir) {
      this.row = row;
      this.col = col;
      this.cost = cost;
      this.dir = dir;
    }
  }

}
