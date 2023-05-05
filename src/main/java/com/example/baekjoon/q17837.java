package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class q17837 {

  private static int N, K;
  private static int[][] map;
  private static int[][] directs = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
  private static ArrayList<Integer>[][] pos;
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
    nodes = new Node[K + 1];
    pos = new ArrayList[N + 1][N + 1];

    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
        pos[i][j] = new ArrayList<>();
      }
    }

    for (int i = 1; i <= K; i++) {
      st = new StringTokenizer(br.readLine());
      int row = Integer.parseInt(st.nextToken());
      int col = Integer.parseInt(st.nextToken());
      int dir = Integer.parseInt(st.nextToken()) - 1;
      nodes[i] = new Node(row, col, dir);
      pos[row][col].add(i);
    }

    br.close();
  }

  private static int Solution() {

    int cnt = 0;
    while (true) {

      if (cnt > 1000) {
        return -1;
      }

      cnt++;

      for (int i = 1; i <= K; i++) {
        Node now = nodes[i];

        int nr = now.row + directs[now.dir][0];
        int nc = now.col + directs[now.dir][1];

        if (!isPossible(nr, nc) || map[nr][nc] == 2) {//파란색일 때
          nr = now.row - directs[now.dir][0];//방향을 반대로
          nc = now.col - directs[now.dir][1];
          now.dir += now.dir % 2 == 0 ? +1 : -1;
        }

        if (isPossible(nr, nc) && map[nr][nc] == 0) {
          ArrayList<Integer> tmp = new ArrayList<>();
          boolean flag = false;

          for (int n : pos[now.row][now.col]) {
            if (n == i) {
              flag = true;
            }

            if (flag) {
              pos[nr][nc].add(n);
              tmp.add(n);
            }
          }

          for (int n : tmp) {
            pos[nodes[n].row][nodes[n].col].remove((Integer) n);
            nodes[n].row = nr;
            nodes[n].col = nc;
          }


        } else if (isPossible(nr, nc) && map[nr][nc] == 1) {
          ArrayList<Integer> tmp = new ArrayList<>();

          for (int j = pos[now.row][now.col].size() - 1; j >= 0; j--) {
            int n = pos[now.row][now.col].get(j);

            pos[nr][nc].add(n);
            tmp.add(n);

            if (n == i) {
              break;
            }
          }

          for (int n : tmp) {
            pos[nodes[n].row][nodes[n].col].remove((Integer) n);
            nodes[n].row = nr;
            nodes[n].col = nc;
          }
        }

        for (int k = 1; k <= K; k++) {
          if (pos[nodes[k].row][nodes[k].col].size() >= 4) {
            return cnt;
          }
        }
      }
    }
  }

  private static boolean isPossible(int row, int col) {
    return row >= 1 && row <= N && col >= 1 && col <= N;
  }

  private static class Node {

    int row;
    int col;
    int dir;

    public Node(int row, int col, int dir) {
      this.row = row;
      this.col = col;
      this.dir = dir;
    }
  }


}
