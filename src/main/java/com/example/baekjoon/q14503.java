package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q14503 {

  private static int N;
  private static int M;
  private static int r, c, d;
  private static int[][] map;

  private static int[][] directs = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
  private static int[][] directs2 = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
  private static int dcnt;

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
    map = new int[N][M];

    st = new StringTokenizer(br.readLine());
    r = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());
    d = Integer.parseInt(st.nextToken());

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    br.close();
  }

  private static int Solution() {
    dcnt = 1;
    dfs(r, c, d);
    return dcnt;
  }

  private static void dfs(int row, int col, int dir) {
    map[row][col] = -1;

    for (int i = 0; i < 4; i++) {
      dir = (dir + 3) % 4;
      int nr = row + directs2[dir][0];
      int nc = col + directs2[dir][1];

      // 2. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우
      if (isPossible(nr, nc) && map[nr][nc] == 0) {
        dcnt++;
        dfs(nr, nc, dir);
        return;
      }
    }

    int d = (dir + 2) % 4;
    int nr = row + directs2[d][0];
    int nc = col + directs2[d][1];
    if (isPossible(nr, nc) && map[nr][nc] != 1) {
      dfs(nr, nc, d);
    }
  }

  private static boolean isPossible(int row, int col){
    return row >= 0 && col >= 0 && row < N && col < M;
  }
}
