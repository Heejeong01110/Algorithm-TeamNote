package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class q18808 {

  private static int N, M, K;
  private static boolean[][] map;
  private static int pr, pc;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    map = new boolean[N][M];

    for (int k = 0; k < K; k++) {
      st = new StringTokenizer(br.readLine());
      pr = Integer.parseInt(st.nextToken());
      pc = Integer.parseInt(st.nextToken());
      ArrayList<int[]> piece = new ArrayList<>();

      for (int i = 0; i < pr; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < pc; j++) {
          if (st.nextToken().equals("1")) {
            piece.add(new int[]{i, j});
          }
        }
      }

      boolean check = false;
      for (int i = 0; i < 3; i++) {
        if (findLoc(piece)) {
          check = true;
          break;
        }
        turnPiece(piece);
      }
      if (!check) {
        findLoc(piece);
      }
    }

    int res = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        res += map[i][j] ? 1 : 0;
      }
    }

    br.close();
    System.out.print(res);
  }

  private static boolean findLoc(ArrayList<int[]> piece) {
    if (N < pr || M < pc) {
      return false;
    }
    for (int r = 0; r <= N - pr; r++) {
      for (int c = 0; c <= M - pc; c++) {
        boolean check = true;
        for (int[] now : piece) {
          int row = now[0] + r;
          int col = now[1] + c;
          if (map[row][col]) {
            check = false;
            break;
          }
        }

        if (check) {
          for (int[] now : piece) {
            int row = now[0] + r;
            int col = now[1] + c;
            map[row][col] = true;
          }
          return true;
        }
      }
    }
    return false;
  }

  private static void turnPiece(ArrayList<int[]> piece) {
    for (int[] now : piece) {
      int row = now[1];
      int col = (pr - 1) - now[0];
      now[0] = row;
      now[1] = col;
    }

    int tmp = pr;
    pr = pc;
    pc = tmp;
  }
}
