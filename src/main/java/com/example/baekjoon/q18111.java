package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q18111 {

  private static final int REMOVE = 2, BUILD = 1;
  private static int N, M, B;
  private static int[][] map;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    System.out.print(Solution());
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    B = Integer.parseInt(st.nextToken());
    map = new int[N][M];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    br.close();
  }

  private static String Solution() {
    int maxHeight = 0, minHeight = map[0][0];
    int sum = B;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        sum += map[i][j];
        minHeight = Math.min(minHeight, map[i][j]);
      }
    }
    maxHeight = sum / (N * M);

    int resTime = Integer.MAX_VALUE;
    int resHeight = -1;
    for (int i = maxHeight; i >= minHeight; i--) { //땅 높이
      int time = getTime(i);
      if (time < resTime) {
        resTime = time;
        resHeight = i;
      }
    }

    return resTime + " " + resHeight;
  }

  //2. 평평하게 만드는 시간 구하기
  private static int getTime(int h) {
    int time = 0;
    int block = B;

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (map[i][j] > h) {
          time += (map[i][j] - h) * REMOVE;
          block += (map[i][j] - h);
        } else if (map[i][j] < h) {
          time += (h - map[i][j]) * BUILD;
          block -= (h - map[i][j]);
        }
      }
    }
    return time;
  }

}
