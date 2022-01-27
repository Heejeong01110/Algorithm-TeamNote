package com.example.programmers;

//경주로 건설
public class s67259 {

  static int[] makeRoadCost = {100, 500};
  private static int[] dr = {1, 0, -1, 0};
  private static int[] dc = {0, 1, 0, -1};
  private static int width, minCost;

  public static int solution(int[][] board) {
    width = board.length - 1;
    minCost = Integer.MAX_VALUE;

    boolean[][] visited = new boolean[board.length][board.length];
    for (int i = 0; i < visited.length; i++) {
      for (int j = 0; j < visited.length; j++) {
        visited[i][j] = (board[i][j] == 1);
      }
    }

    dfs(visited, null, new Node(0, 0), 0);

    return minCost;
  }

  public static void dfs(boolean[][] visited, Node beforeNode, Node currentNode,
      int cost) {
    if (cost >= minCost) {//이전 최저금액 이상일 시 탐색 종료
      return;
    }

    if (currentNode.isEnd()) { //종점 도착시 탐색 종료
      minCost = Math.min(minCost, cost);
      return;
    }

    for (int i = 0; i < 4; i++) {
      Node moveNode = new Node(currentNode.row + dr[i], currentNode.col + dc[i]);
      if (isPossibleVisit(visited, moveNode)) { //방문 가능
        visited[moveNode.row][moveNode.col] = true;
        dfs(visited, currentNode, moveNode, cost + addCost(beforeNode, moveNode));
        visited[moveNode.row][moveNode.col] = false;
      }
    }

  }

  private static int addCost(Node beforeNode, Node moveNode) {
    if (beforeNode == null) {
      //출발점 옆일 때
      return makeRoadCost[0];
    }
    if (beforeNode.row == moveNode.row || beforeNode.col == moveNode.col) {
      //직진도로 2개
      return makeRoadCost[0];
    } else {
      //곡선도로 포함
      return makeRoadCost[0] + makeRoadCost[1];
    }

  }

  private static boolean isPossibleVisit(boolean[][] visited, Node moveNode) {
    if (moveNode.row < 0 || moveNode.col < 0 || moveNode.row > width || moveNode.col > width) {
      return false;
    }

    if (visited[moveNode.row][moveNode.col]) {
      return false;
    }

    return true;
  }


  private static class Node {

    int row;
    int col;

    public Node(int row, int col) {
      this.row = row;
      this.col = col;
    }

    public boolean isEnd() {
      if (row == width && col == width) {
        return true;
      }
      return false;
    }
  }

}
