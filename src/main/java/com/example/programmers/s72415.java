package com.example.programmers;

import java.util.Arrays;
import java.util.PriorityQueue;

public class s72415 {

  private static final int[][] dir = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
  private int[][] cards;
  private boolean[] checkCard;

  public int solution(int[][] board, int r, int c) {
    int answer = 0;
    checkCard = new boolean[7];

    cards = new int[7][4];
    for (int i = 0; i < 7; i++) {
      Arrays.fill(cards[i], -1);
    }

    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        if (board[i][j] == 0) {
          continue;
        }
        checkCard[board[i][j]] = true;
        if (cards[board[i][j]][0] == -1) {
          cards[board[i][j]][0] = i;
          cards[board[i][j]][1] = j;
        } else {
          cards[board[i][j]][2] = i;
          cards[board[i][j]][3] = j;
        }
      }
    }

    PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.cnt - o2.cnt);
    queue.add(new Node(r, c, 0, new boolean[7]));

    while (!queue.isEmpty()) {
      Node now = queue.poll();

      //1. 모든 카드를 뒤집은 경우 종료
      if (isNothingCard(now.visited)) {
        answer = now.cnt;
        break;
      }

      //카드 이동
      for (int i = 1; i < checkCard.length; i++) {
        //1. visited 하지 않은 모든 카드 방문(둘 중 가까운 카드)
        if (checkCard[i] && !now.visited[i]) {
          Node one = new Node(cards[i][0], cards[i][1], -1, null);
          Node two = new Node(cards[i][2], cards[i][3], -1, null);

          int nowToOne = getCntBetweenNodes(now, one, now.visited, board);
          int nowToTwo = getCntBetweenNodes(now, two, now.visited, board);
          int oneToTwo = getCntBetweenNodes(one, two, now.visited, board);
          int twoToOne = getCntBetweenNodes(two, one, now.visited, board);

          boolean[] clone = now.visited.clone();
          clone[i] = true;
          queue.add(new Node(one.row, one.col, now.cnt + nowToTwo + twoToOne + 2, clone));
          queue.add(new Node(two.row, two.col, now.cnt + nowToOne + oneToTwo + 2, clone));
        }
      }
    }

    return answer;
  }

  private int getCntBetweenNodes(Node start, Node end, boolean[] visited, int[][] board) {
    if (start.row == end.row && start.col == end.col) {
      return 0;
    }
    PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
    boolean[][] vmap = new boolean[4][4];

    queue.add(new int[]{start.row, start.col, 0});
    vmap[start.row][start.col] = true;

    while (!queue.isEmpty()) {
      int[] now = queue.poll();
      if (now[0] == end.row && now[1] == end.col) {
        return now[2];
      }

      for (int d = 0; d < 4; d++) {
        //1. 한칸 이동
        int nr = now[0] + dir[d][0];
        int nc = now[1] + dir[d][1];
        if (isPossible(nr, nc) && !vmap[nr][nc]) {
          vmap[nr][nc] = true;
          queue.add(new int[]{nr, nc, now[2] + 1});
        }

        //2. ctrl + 한칸 이동
        int er = now[0] + dir[d][0];
        int ec = now[1] + dir[d][1];
        for (int move = 0; move < 4; move++) {
          if (!isPossible(er, ec)) {//막다른 길일 때
            er -= dir[d][0];
            ec -= dir[d][1];
            break;
          }
          if (board[er][ec] != 0 && !visited[board[er][ec]]) {//방문안한 카드가 있어서 멈춰야 할 때
            break;
          }
          er += dir[d][0];
          ec += dir[d][1];
        }
        if (!(nr == er && nc == ec) && isPossible(er, ec) && !vmap[er][ec]) {
          vmap[er][ec] = true;
          queue.add(new int[]{er, ec, now[2] + 1});
        }
      }
    }
    return 0;
  }

  private boolean isPossible(int row, int col) {
    return row >= 0 && row < 4 && col >= 0 && col < 4;
  }

  private boolean isNothingCard(boolean[] visited) {
    for (int i = 0; i < visited.length; i++) {
      if (checkCard[i] && !visited[i]) {
        return false;
      }
    }
    return true;
  }

  private class Node {

    int row;
    int col;
    int cnt;

    boolean[] visited;

    public Node(int row, int col, int cnt, boolean[] visited) {
      this.row = row;
      this.col = col;
      this.cnt = cnt;
      this.visited = visited;
    }
  }

}
