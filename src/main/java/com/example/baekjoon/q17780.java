package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q17780 {

  private static int N;
  private static int K;
  private static int[][] map;
  private static int[][] pieces;
  private static int[][] dir = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
  private static Node[] nodes;


  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    output(Solution());
  }

  private static void output(int result) {
    System.out.print(result);
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    map = new int[N + 1][N + 1];
    pieces = new int[K + 1][3]; //행, 열, 이동방향

    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int i = 1; i <= K; i++) {
      st = new StringTokenizer(br.readLine());
      pieces[i][0] = Integer.parseInt(st.nextToken());
      pieces[i][1] = Integer.parseInt(st.nextToken());
      pieces[i][2] = Integer.parseInt(st.nextToken()) - 1;
    }

    br.close();
  }

  private static int Solution() {
    int answer = -1;
    nodes = new Node[K + 1];

    for (int i = 1; i <= K; i++) {
      nodes[i] = new Node(pieces[i][0], pieces[i][1], pieces[i][2], -1, -1);
    }

    int cnt = 1;
    while (cnt <= 1000) {
      for (int i = 1; i <= K; i++) {
        Node node = nodes[i];
        if (node.down != -1) {
          continue;
        }
        int nr = node.row + dir[node.dir][0];
        int nc = node.col + dir[node.dir][1];
        int idx = i;

        if (!isPossible(nr, nc) || map[nr][nc] == 2) { //파란색
          nr = node.row - dir[node.dir][0];
          nc = node.col - dir[node.dir][1];
          if (isPossible(nr, nc) && map[nr][nc] != 2) {
            //방향을 반대로 한 후에 파란색인 경우 --> 이동하지 않고 방향만 반대로
            //파란색이 아닐 경우 -> 흰,빨 중 색에따라서 이동 후 방향 반대
            i--;
          }
          node.dir += (node.dir % 2 == 0 ? 1 : -1);

        } else if (map[nr][nc] == 1) { //빨간색
          //이동하는 자리 맨 위의 말 구하기
          int nIdx = getChild(nr, nc);

          // 모든 말의 쌓여있는 순서를 반대로 && 모든 말을 nr,nc로 이동
          while (true) {
            nodes[idx].row = nr;
            nodes[idx].col = nc;

            int tmp = nodes[idx].up;
            nodes[idx].up = nodes[idx].down;
            nodes[idx].down = tmp;

            if (tmp == -1) {
              break;
            }
            idx = tmp;
          }

          //원래 맨 위에있던 말의 node.down = (nr,nc 자리에 있는 맨 위의 말)
          if (nIdx != -1) {
            nodes[nIdx].up = idx;
            nodes[idx].down = nIdx;
          }

        } else if (map[nr][nc] == 0) { //흰색
          //이동하는 자리 맨 위의 말 구하기
          int nIdx = getChild(nr, nc);

          //원래 맨 위에있던 말의 node.down = (nr,nc 자리에 있는 맨 위의 말)
          if (nIdx != -1) {
            nodes[nIdx].up = idx;
            nodes[idx].down = nIdx;
          }

          //모든 말을 nr,nc로 이동
          while (true) {
            nodes[idx].row = nr;
            nodes[idx].col = nc;

            if (nodes[idx].up == -1) {
              break;
            }
            idx = nodes[idx].up;
          }
        }
      }

      //이동 후 말이 4개인지 체크하기
      if (isMoreThanFour()) {
        answer = cnt;
        break;
      }
      cnt++;
    }

    return answer;
  }

  private static boolean isMoreThanFour() {
    for (int i = 1; i <= K; i++) {
      int cnt = 0;
      int idx = i;
      while (idx != -1) {
        cnt += 1;
        idx = nodes[idx].up;
      }
      if (cnt >= 4) {
        return true;
      }
    }
    return false;
  }

  private static int getChild(int row, int col) {
    for (int i = 1; i <= K; i++) {
      if (nodes[i].row == row && nodes[i].col == col && nodes[i].up == -1) {
        return i;
      }
    }
    return -1;
  }

  private static boolean isPossible(int row, int col) {
    return row >= 1 && row <= N && col >= 1 && col <= N;
  }


  private static class Node {

    int row;
    int col;
    int dir;

    int up;

    int down;

    public Node(int row, int col, int dir, int up, int down) {
      this.row = row;
      this.col = col;
      this.dir = dir;
      this.up = up;
      this.down = down;
    }

  }

}
