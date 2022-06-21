package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class q16933 {

  private static final int[][] direct = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
  private static int N;
  private static int M;
  private static int K;
  private static int[][] map;

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
    M = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    map = new int[N][M];

    for (int i = 0; i < N; i++) {
      String str = br.readLine();
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(str.substring(j, j + 1));
      }
    }

    br.close();
  }

  private static int Solution() {
    int count = 1;
    int isDay = 0;
    Queue<Node> queue = new ArrayDeque<>();
    boolean[][][][] visited = new boolean[N][M][2][K + 1];
    //0 : 낮, 1 : 밤

    visited[0][0][0][0] = true;
    queue.add(new Node(0, 0, 0));

    while (!queue.isEmpty()) {
      int size = queue.size();

      for (int s = 0; s < size; s++) {
        Node now = queue.poll();
        if (now.breakWall > K) {
          continue;
        }

        if (now.row == N - 1 && now.col == M - 1) {
          return count;
        }

        for (int i = 0; i < 4; i++) {
          int nr = now.row + direct[i][0];
          int nc = now.col + direct[i][1];

          if (!isPossible(nr, nc)) {
            continue;
          }

          int nDay = (isDay + 1) % 2;
          if (map[nr][nc] == 0 && !visited[nr][nc][nDay][now.breakWall]) {//벽이 아닐 때
            queue.add(new Node(nr, nc, now.breakWall));
            visited[nr][nc][nDay][now.breakWall] = true;
          } else if (map[nr][nc] == 1) { //벽일 때
            if (isDay == 0 && now.breakWall + 1 <= K && !visited[nr][nc][nDay][now.breakWall
                + 1]) { //낮일 때 --> 뚫고 가기
              queue.add(new Node(nr, nc, now.breakWall + 1));
              visited[nr][nc][nDay][now.breakWall + 1] = true;
            } else if (isDay == 1 && !visited[nr][nc][nDay][now.breakWall]) { //밤일 때 --> 기다리기
              queue.add(new Node(now.row, now.col, now.breakWall));
              visited[nr][nc][nDay][now.breakWall] = true;
            }
          }
          //1. 벽이 아닐 때
          //2-1. 벽일 때 -> 뚫고 가기
          //2-2. 벽일 때(저녁일 경우) -> 기다리기
        }
      }
      count++;
      isDay = (isDay + 1) % 2;
    }

    return -1;
  }

  private static boolean isPossible(int row, int col) {
    return row >= 0 && row < N && col >= 0 && col < M;
  }

  private static class Node {

    int row;
    int col;
    int breakWall;

    public Node(int row, int col, int breakWall) {
      this.row = row;
      this.col = col;
      this.breakWall = breakWall;
    }
  }

}
