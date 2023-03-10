package com.example.programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class s72415 {

  private static final int[][] direct = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
  private HashMap<Integer, Card> cards;

  public int solution(int[][] board, int r, int c) {
    int answer = 0;

    //1. 카드 번호 별로 뒤집기 위한 횟수 구하기 (enter - 이동 - enter 까지의 횟수) (중간에 다른 카드가 껴있을 경우를 고려해야 함)

    //1. 카드 번호 별로 위치 구하기
    //2. 각 카드를 모두 연결하는 최소거리(횟수) 구하기

    cards = new HashMap<>();
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        if (board[i][j] == 0) {
          continue;
        }
        Card card = cards.getOrDefault(board[i][j], new Card(board[i][j], new ArrayList<>(), 0));
        card.node.add(new int[]{i, j});
        cards.put(board[i][j], card);
      }
    }

    PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> {
      if (o1.visCnt == o2.visCnt) {
        return o1.cnt - o2.cnt;
      }
      return o2.visCnt - o1.visCnt;
    });

    queue.add(new Node(r, c, 0, new boolean[7], 0));
    answer = Integer.MAX_VALUE;
    while (!queue.isEmpty()) {
      Node now = queue.poll();
      if (answer <= now.cnt) {
        continue;
      }

      if (isEnd(now.visited)) {
        answer = now.cnt;
        break;
      }

      //1. 현재 자리에 카드가 있을 경우
      if (board[now.row][now.col] != 0 && !now.visited[board[now.row][now.col]]) {
        queue.add(getNode(board, now.row, now.col, now, 0));
        continue;
      }

      //2. 현재 자리에 카드가 없을 경우
      //2-1. 한번 움직여서 카드위치로 이동할 수 있을 경우
      boolean temp = false;
      for (int i = 0; i < 4; i++) {
        for (int j = 1; j < 4; j++) {
          int nr = now.row + direct[i][0] * j;
          int nc = now.col + direct[i][1] * j;
          if (isPossible(nr, nc) && board[nr][nc] != 0 && !now.visited[board[nr][nc]]) {
            queue.add(getNode(board, nr, nc, now, 1));
            temp = true;
            break;
          }
        }
      }

      if (temp) {
        continue;
      }

      //2-2. 한번 움직여서 카드위치로 이동할 수 없는 경우
      for (int i = 0; i < 4; i++) {
        for (int j = 1; j < 4; j++) {
          int nr = now.row + direct[i][0] * j;
          int nc = now.col + direct[i][1] * j;
          if (isPossible(nr, nc)
              && (board[nr][nc] == 0 || board[nr][nc] != 0 && !now.visited[board[nr][nc]])) {
            queue.add(new Node(nr, nc, now.cnt + 1, now.visited.clone(), now.visCnt));
            break;
          }
        }
      }

    }

    return answer;
  }

  private Node getNode(int[][] board, int row, int col, Node now, int move) {
    //1. 반대편 짝 찾기
    int biasRow = 0, biasCol = 0;
    ArrayList<int[]> nowNodes = cards.get(board[row][col]).node;
    for (int n = 0; n < 2; n++) {
      if (nowNodes.get(n)[0] == row && nowNodes.get(n)[1] == col) {
        biasRow = nowNodes.get((n + 1) % 2)[0];
        biasCol = nowNodes.get((n + 1) % 2)[1];
      }
    }
    //2. 두가지 위치 모두 뒤집기 표시
    boolean[] visitedClone = now.visited.clone();
    visitedClone[board[row][col]] = true;

    //3. 해당 위치로 이동
    int cnt = getCount(row, col, biasRow, biasCol);
    return new Node(biasRow, biasCol, now.cnt + cnt + move, visitedClone, now.visCnt + 1);
  }

  private int getCount(int nr, int nc, int br, int bc) {
    int cnt = 2;//엔터 2번
    if (br == 0 || br == 3 || Math.abs(nr - br) == 1) {
      cnt += 1;
    } else {
      cnt += Math.abs(nr - br);
    }

    if (bc == 0 || bc == 3 || Math.abs(nc - bc) == 1) {
      cnt += 1;
    } else {
      cnt += Math.abs(nc - bc);
    }

    return cnt;
  }

  private boolean isPossible(int row, int col) {
    return row >= 0 && row < 4 && col >= 0 && col < 4;
  }

  private boolean isEnd(boolean[] visited) {
    for (Integer key : cards.keySet()) {
      if (!visited[key]) {
        return false;
      }
    }
    return true;
  }

  private class Node {

    int row;
    int col;
    int cnt;

    boolean[] visited; //뒤집기 완료한 카드 : true
    int visCnt;

    public Node(int row, int col, int cnt, boolean[] visited, int visCnt) {
      this.row = row;
      this.col = col;
      this.cnt = cnt;
      this.visited = visited;
      this.visCnt = visCnt;
    }
  }

  private class Card {

    int index;
    ArrayList<int[]> node;

    int dist;

    public Card(int index, ArrayList<int[]> node, int dist) {
      this.index = index;
      this.node = node;
      this.dist = dist;
    }
  }
}
