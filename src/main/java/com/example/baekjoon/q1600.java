package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class q1600 {

  private static int K, W, H;
  private static int[][] map;
  private static int[][] horse_dir = new int[][]{{1, -2}, {1, 2}, {2, -1}, {2, 1}, {-1, -2},
      {-1, 2}, {-2, -1}, {-2, 1}};
  private static int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    System.out.print(Solution());
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    K = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    W = Integer.parseInt(st.nextToken());
    H = Integer.parseInt(st.nextToken());
    map = new int[H][W];

    for (int i = 0; i < H; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < W; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    br.close();
  }

  private static int Solution() {

    if (H == 1 && W == 1) {
      return 0;
    }

    int[][][] visited = new int[H][W][K + 1];
    for (int i = 0; i < H; i++) {
      for (int j = 0; j < W; j++) {
        Arrays.fill(visited[i][j], W * H);
      }
    }

    PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
    queue.add(new int[]{0, 0, 0, 0});
    visited[0][0][0] = 0;

    while (!queue.isEmpty()) {
      int[] now = queue.poll();

      if (now[3] < K) { //horse 이동경로 체크
        for (int[] d : horse_dir) {
          int nr = now[0] + d[0];
          int nc = now[1] + d[1];
          if (isPossible(nr, nc) && map[nr][nc] == 0
              && visited[nr][nc][now[3] + 1] > now[2] + 1) {
            queue.add(new int[]{nr, nc, now[2] + 1, now[3] + 1});
            visited[nr][nc][now[3] + 1] = now[2] + 1;
            if (nr == H - 1 && nc == W - 1) {
              return visited[nr][nc][now[3] + 1];
            }
          }
        }
      }
      for (int[] d : dir) {
        int nr = now[0] + d[0];
        int nc = now[1] + d[1];
        if (isPossible(nr, nc) && map[nr][nc] == 0 && visited[nr][nc][now[3]] > now[2] + 1) {
          queue.add(new int[]{nr, nc, now[2] + 1, now[3]});
          visited[nr][nc][now[3]] = now[2] + 1;
          if (nr == H - 1 && nc == W - 1) {
            return visited[nr][nc][now[3]];
          }
        }
      }
    }

    return -1;
  }

  private static boolean isPossible(int row, int col) {
    return row >= 0 && row < H && col >= 0 && col < W;
  }

}
