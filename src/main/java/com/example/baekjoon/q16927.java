package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class q16927 {

  private static final int[][] dir = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
  private static int N, M;
  private static long R;
  private static int[][] map;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    Solution();
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    R = Long.parseLong(st.nextToken());
    map = new int[N][M];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    br.close();
  }

  private static void Solution() {
    int len = Math.min(N, M);
    for (int i = 0; i < len / 2; i++) {
      int circleLen = ((N - i * 2) + (M - i * 2)) * 2 - 4;
      int nr = Math.toIntExact(R % circleLen);
      turn(i, nr);
    }

    printMap();
  }

  private static void turn(int padding, int turn) {
    int lr = padding, lc = padding;
    int rr = N - 1 - padding, rc = M - 1 - padding;

    Deque<Integer> deque = new ArrayDeque<>();
    deque.add(map[lr][lc]);

    int row = lr, col = lc;
    for (int d = 0; d < dir.length; d++) {
      int len = (d % 2 == 0 ? N : M) - padding * 2 - 1;
      for (int i = 1; i <= len; i++) {
        row += dir[d][0];
        col += dir[d][1];
        deque.add(map[row][col]);
      }
    }

    deque.pollLast();
    for (int i = 0; i < turn; i++) {
      deque.addFirst(deque.pollLast());
    }

    row = lr;
    col = lc;
    map[lr][lc] = deque.pollFirst();
    for (int d = 0; d < dir.length; d++) {
      int len = (d % 2 == 0 ? N : M) - padding * 2 - 1;
      for (int i = 1; i <= len; i++) {
        row += dir[d][0];
        col += dir[d][1];
        if (!deque.isEmpty()) {
          map[row][col] = deque.pollFirst();
        }
      }
    }
  }

  private static void printMap() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        sb.append(map[i][j]).append(" ");
      }
      sb.append("\n");
    }
    System.out.print(sb);
  }
}
