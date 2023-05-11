package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q15684 {

  private static int N;
  private static int M;
  private static int H;
  private static int result;
  private static int[][] infos;

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
    H = Integer.parseInt(st.nextToken());

    infos = new int[M][2];
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      infos[i][0] = Integer.parseInt(st.nextToken());
      infos[i][1] = Integer.parseInt(st.nextToken());
    }

    br.close();
  }

  private static int Solution() {
    //N : 세로선 갯수
    //M : 가로선 갯수
    result = 4;

    boolean[][] map = new boolean[H + 1][N + 1];
    for (int i = 0; i < infos.length; i++) {
      int row = infos[i][0];
      int col = infos[i][1];
      map[row][col] = true;
    }
    dfs(1, 1, 0, map);
    if (result == 4) {
      return -1;
    }
    return result;
  }

  private static void dfs(int row, int col, int cnt, boolean[][] map) {
    if (result <= cnt) {
      return;
    }
    if (calc(map)) {
      result = Math.min(result, cnt);
      return;
    }
    if (cnt == 3 || row == H + 1 && col == 1) {
      return;
    }


    int nr = col + 1 == N ? row + 1 : row;
    int nc = col + 1 == N ? 1 : col + 1;
    if (map[row][col]
        || isPossible(row, col - 1) && map[row][col - 1]
        || isPossible(row, col + 1) && map[row][col + 1]) { //사다리를 놓을 수 없음
      dfs(nr, nc, cnt, map);
    } else { //사다리를 놓을 수 있을 경우
      map[row][col] = true;
      dfs(nr, nc, cnt + 1, map); //놓음
      map[row][col] = false;
      dfs(nr, nc, cnt, map); //놓지 않음
    }
  }

  private static boolean calc(boolean[][] map) {
    for (int i = 1; i <= N; i++) {
      int now = i;
      for (int j = 1; j <= H; j++) {
        if (now != N && map[j][now]) {
          now = now + 1;
        } else if (now != 1 && map[j][now - 1]) {
          now = now - 1;
        }
      }

      if (now != i) {
        return false;
      }
    }
    return true;
  }

  private static boolean isPossible(int row, int col) {
    return row >= 1 && row < N && col >= 1 && col <= M;
  }

}
