package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q5549 {

  private static int M;
  private static int N;
  private static int K;
  private static Character[][] map;
  private static Integer[][] ranges;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    output(Solution());
  }

  private static void output(String result) {
    System.out.print(result);
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());

    K = Integer.parseInt(br.readLine());

    map = new Character[M + 1][N + 1];
    String str;
    for (int i = 0; i < M; i++) {
      str = br.readLine();
      for (int j = 0; j < N; j++) {
        map[i+1][j+1] = str.charAt(j);
      }
    }

    ranges = new Integer[K][4];
    for (int i = 0; i < K; i++) {
      st = new StringTokenizer(br.readLine());
      ranges[i][0] = Integer.parseInt(st.nextToken());
      ranges[i][1] = Integer.parseInt(st.nextToken());
      ranges[i][2] = Integer.parseInt(st.nextToken());
      ranges[i][3] = Integer.parseInt(st.nextToken());
    }

    br.close();
  }

  private static String Solution() {

    int[][] Jungle = new int[M + 1][N + 1];
    int[][] Ocean = new int[M + 1][N + 1];
    int[][] Ice = new int[M + 1][N + 1];

    Jungle[1][1] = map[1][1] == 'J' ? 1 : 0;
    Ocean[1][1] = map[1][1] == 'O' ? 1 : 0;
    Ice[1][1] = map[1][1] == 'I' ? 1 : 0;
    for (int i = 2; i <= N; i++) {
      Jungle[1][i] = Jungle[1][i - 1] + (map[1][i] == 'J' ? 1 : 0);
      Ocean[1][i] = Ocean[1][i - 1] + (map[1][i] == 'O' ? 1 : 0);
      Ice[1][i] = Ice[1][i - 1] + (map[1][i] == 'I' ? 1 : 0);
    }
    for (int i = 2; i <= M; i++) {
      Jungle[i][1] = Jungle[i - 1][1] + (map[i][1] == 'J' ? 1 : 0);
      Ocean[i][1] = Ocean[i - 1][1] + (map[i][1] == 'O' ? 1 : 0);
      Ice[i][1] = Ice[i - 1][1] + (map[i][1] == 'I' ? 1 : 0);
    }

    for (int i = 2; i <= M; i++) {
      for (int j = 2; j <= N; j++) {
        Jungle[i][j] = Jungle[i][j - 1]
            + (Jungle[i - 1][j] - Jungle[i - 1][j - 1])
            + (map[i][j] == 'J' ? 1 : 0);
        Ocean[i][j] = Ocean[i][j - 1]
            + (Ocean[i - 1][j] - Ocean[i - 1][j - 1])
            + (map[i][j] == 'O' ? 1 : 0);
        Ice[i][j] = Ice[i][j - 1]
            + (Ice[i - 1][j] - Ice[i - 1][j - 1])
            + (map[i][j] == 'I' ? 1 : 0);
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < K; i++) {
      int startR = ranges[i][0];
      int startC = ranges[i][1];
      int endR = ranges[i][2];
      int endC = ranges[i][3];

      int jungle,ocean,ice;

      jungle = Jungle[endR][endC] - Jungle[endR][startC-1] - Jungle[startR-1][endC] + Jungle[startR-1][startC-1];
      ocean = Ocean[endR][endC] - Ocean[endR][startC-1] - Ocean[startR-1][endC] + Ocean[startR-1][startC-1];
      ice = Ice[endR][endC] - Ice[endR][startC-1] - Ice[startR-1][endC] + Ice[startR-1][startC-1];

      sb.append(jungle).append(" ").append(ocean).append(" ").append(ice).append("\n");

    }

    return sb.toString();
  }

}
