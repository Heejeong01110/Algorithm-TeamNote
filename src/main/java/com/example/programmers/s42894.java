package com.example.programmers;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class s42894 {

  private static final int[][] direct = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
  private static int N;
  private static int[][] Board;

  public static int solution(int[][] board) {
    N = board.length;
    Board = new int[N][N];
    for (int i = 0; i < board.length; i++) {
      Board[i] = board[i].clone();
    }

    int answer = 0;

    boolean[] empty = new boolean[N];
    Arrays.fill(empty, false);

    Queue<Integer> queue = new ArrayDeque<>();
    for (int i = 0; i < N; i++) {
      queue.add(i);
    }

    while (!queue.isEmpty()) {
      int now = queue.poll();

      for (int i = 0; i < N; i++) {
        if (Board[i][now] != 0 && i != 0) {
          if(check(i, now, queue)){
            answer++;
          }
          break;
        }
      }
    }

    return answer;
  }

  //row, col은 기존 블록이 있는 자리. 실제로 블록을 놓는 자리는 (row-1, col)
  private static boolean check(int row, int col, Queue<Integer> colQueue) {
    //1. 아랫 방향만 체크
    //5개 블록 모양 체크
    ArrayList<Node> block = new ArrayList<>();
    Queue<Node> queue = new ArrayDeque<>();
    boolean[][] visited = new boolean[N][N];
    queue.add(new Node(0, 0));

    block.add(new Node(0, 0));
    block.add(new Node(-1, 0));
    visited[row][col] = true;
    visited[row - 1][col] = true;

    while (!queue.isEmpty()) {
      Node now = queue.poll();

      for (int i = 0; i < 4; i++) {
        int nr = now.row + direct[i][0];
        int nc = now.col + direct[i][1];

        if (isPossible(row + nr, col + nc)
            && !visited[row + nr][col + nc]
            && Board[row + nr][col + nc] == Board[row][col]) {
          queue.add(new Node(nr, nc));
          block.add(new Node(nr, nc));
          visited[row + nr][col + nc] = true;
        }
      }
    }

    //2. 총 5개의 블럭이 직사각형 모양에서 벗어나지 않는지 체크
    //2-1. 나머지 빈 블록 자리의 윗라인이 비어있는지 체크
    if (isCanDelete(block, row, col)) {
      //3-1. 가능한 경우 지도에서 블럭 삭제 && queue에 블럭 삭제한 col 값 중복없이 넣기

      //블럭 삭제
      queue = new ArrayDeque<>();
      visited = new boolean[N][N];

      queue.add(new Node(0, 0));
      visited[row][col] = true;
      int blockNum = Board[row][col];

      while (!queue.isEmpty()) {
        Node now = queue.poll();
        Board[row + now.row][col + now.col] = 0;

        for (int i = 0; i < 4; i++) {
          int nr = now.row + direct[i][0];
          int nc = now.col + direct[i][1];

          if (isPossible(row + nr, col + nc)
              && !visited[row + nr][col + nc]
              && Board[row + nr][col + nc] == blockNum) {
            queue.add(new Node(nr, nc));
            visited[row + nr][col + nc] = true;
          }
        }
      }

      //col값 넣기
      for (Node node : block) {
        if (!colQueue.contains(col + node.col)) {
          colQueue.add(col + node.col);
        }
      }
      return true;
    }
    return false;
  }

  private static boolean isCanDelete(ArrayList<Node> block, int row, int col) {
    //가장 위쪽인 쪽 부터 정렬
    block.sort((o1, o2) -> {
      if (o1.row == o2.row) {
        return o1.col - o2.col;
      }
      return o1.row - o2.row;
    });

    //2. 총 5개의 블럭이 직사각형 모양에서 벗어나지 않는지 체크
    Node minNode = new Node(block.get(0).row, block.get(0).col);
    Node maxNode = new Node(block.get(0).row, block.get(0).col);

    for (int i = 1; i < block.size(); i++) {
      minNode.row = Math.min(minNode.row, block.get(i).row);
      minNode.col = Math.min(minNode.col, block.get(i).col);

      maxNode.row = Math.max(maxNode.row, block.get(i).row);
      maxNode.col = Math.max(maxNode.col, block.get(i).col);
    }

    //직사각형 체크
    if (!isTwoThreeSquare(minNode, maxNode)) {
      return false;
    }

    //2-1. 나머지 빈 블록 자리의 윗라인이 비어있는지 체크
    Node empty = new Node(0, 0);

    int idx = 0;
    for (int i = minNode.row; i <= maxNode.row; i++) {
      for (int j = minNode.col; j <= maxNode.col; j++) {
        if (block.get(idx).row == i && block.get(idx).col == j) {
          idx++;
        } else {//빈 블럭자리
          empty = new Node(i + row, j + col);
          i = maxNode.row;
          j = maxNode.col;
        }
      }
    }

    //윗라인 체크
    for (int i = empty.row; i >= 0; i--) {
      if (Board[i][empty.col] != 0) {
        return false;
      }
    }

    return true;
  }

  private static boolean isTwoThreeSquare(Node minNode, Node maxNode) {
    return (maxNode.row - minNode.row == 2 && maxNode.col - minNode.col == 1) ||
        (maxNode.row - minNode.row == 1 && maxNode.col - minNode.col == 2);
  }

  private static boolean isPossible(int row, int col) {
    return row >= 0 && row < N && col >= 0 && col < N;
  }

  private static class Node {

    int row;
    int col;

    public Node(int row, int col) {
      this.row = row;
      this.col = col;
    }
  }
}
