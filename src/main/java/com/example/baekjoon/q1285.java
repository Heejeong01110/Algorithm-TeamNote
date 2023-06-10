package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q1285 {

  private static int N;
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

    N = Integer.parseInt(br.readLine());
    map = new int[N][N];

    for (int i = 0; i < N; i++) {
      String s = br.readLine();
      for (int j = 0; j < N; j++) {
        map[i][j] = s.charAt(j) == 'T' ? 1 : 0;
      }
    }

    br.close();
  }

  private static int Solution() {
    int res = Integer.MAX_VALUE;
    int[][] cpy_map = new int[N][N];

    for (int bit = 0; bit < (1 << N); bit++) {
      //0. 맵 clone
      for (int i = 0; i < N; i++) {
        cpy_map[i] = map[i].clone();
      }

      //1. bit에 따라 뒤집을 열 뒤집어주기
      for (int r = 0; r < N; r++) {
        int next = (int) Math.pow(2, r); // 0, 1, 10, 100, 1000, ....
        if ((next & bit) != 0) {
          for (int c = 0; c < N; c++) {
            cpy_map[r][c] = cpy_map[r][c] == 0 ? 1 : 0;
          }
        }
      }

      //행 뒤집을지 말지 체크
      int cnt = 0;
      for (int c = 0; c < N; c++) {
        int T = 0;
        for (int r = 0; r < N; r++) {
          T += cpy_map[r][c];
        }
        cnt += Math.min(N - T, T);
      }
      res = Math.min(res, cnt);
    }
    return res;
  }
}
