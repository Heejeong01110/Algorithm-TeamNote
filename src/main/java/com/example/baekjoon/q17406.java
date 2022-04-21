package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q17406 {

  private static final int[][] direct = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
  private static int N;
  private static int M;
  private static int K;
  private static int minRes;
  private static int[][] map;
  private static int[][] copyMap;
  private static int[][] input;

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
    map = new int[N + 1][M + 1];

    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    input = new int[K][3];
    for (int i = 0; i < K; i++) {
      st = new StringTokenizer(br.readLine());
      input[i][0] = Integer.parseInt(st.nextToken());
      input[i][1] = Integer.parseInt(st.nextToken());
      input[i][2] = Integer.parseInt(st.nextToken());
    }

    br.close();
  }

  private static int Solution() {
    minRes = Integer.MAX_VALUE;
    perm(new int[K], new boolean[K], 0);
    return minRes;
  }

  private static void perm(int[] out, boolean[] visited, int depth) {
    if (depth == K) {
      copyMap = new int[N + 1][M + 1];
      for (int i = 1; i <= N; i++) {
        copyMap[i] = map[i].clone();
      }

      for (int num : out) {
        turnMap(copyMap, input[num][0], input[num][1], input[num][2]);
      }

      int sum = Integer.MAX_VALUE;
      for (int i = 1; i <= N; i++) {
        sum = Math.min(sum, Arrays.stream(copyMap[i]).sum());
      }
      minRes = Math.min(sum, minRes);
      return;
    }
    for (int i = 0; i < K; i++) {
      if (!visited[i]) {
        visited[i] = true;
        out[depth] = i;
        perm(out, visited, depth + 1);
        visited[i] = false;
      }
    }
  }

  private static void turnMap(int[][] map, int row, int col, int range) {
    int nr, nc, mr, mc;
    for (int i = 1; i <= range; i++) {
      nr = row - i;
      nc = col - i;
      int temp = map[nr][nc];

      for (int j = 0; j < 4; j++) {
        for (int k = 0; k < i * 2; k++) {
          mr = nr + direct[j][0];
          mc = nc + direct[j][1];

          map[nr][nc] = map[mr][mc];

          nr = mr;
          nc = mc;
        }
      }

      nr -= direct[3][0];
      nc -= direct[3][1];
      map[nr][nc] = temp;
    }
  }


}
