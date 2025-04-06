package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q15653 {

  private static final int[][] dir = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
  private static int N, M;
  private static char[][] map;

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
    map = new char[N][M];

    for (int i = 0; i < N; i++) {
      String str = br.readLine();
      for (int j = 0; j < N; j++) {
        map[i] = str.toCharArray();
      }
    }

    br.close();
  }

  private static int Solution() {
    int[][] visited = new int[100][100];
    int red = 0, blue = 0, hole = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (map[i][j] == 'B') {
          blue = i * 10 + j;
        }
        if (map[i][j] == 'R') {
          red = i * 10 + j;
        }

        if (map[i][j] == 'O') {
          hole = i * 10 + j;
        }
      }
    }
    for (int i = 0; i < 100; i++) {
      Arrays.fill(visited[i], Integer.MAX_VALUE);
    }

    int ans = -1;
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{red, blue, 0});
    visited[red][blue] = 0;

    while (!queue.isEmpty()) {
      int[] now = queue.poll();

      if (now[0] == hole) {
        ans = now[2];
        break;
      }

      int[] r = new int[]{now[0] / 10, now[0] % 10};
      int[] b = new int[]{now[1] / 10, now[1] % 10};

      for (int d = 0; d < 4; d++) {
        int nr = tilt(r, b, dir[d]);
        int nb = tilt(b, r, dir[d]);

        if (visited[nr][nb] > now[2] + 1 && nb != hole) {
          queue.add(new int[]{nr, nb, now[2] + 1});
          visited[nr][nb] = now[2] + 1;
        }
      }

    }
    return ans;
  }

  private static int tilt(int[] ball, int[] other, int[] d) {
    int m = 0;
    boolean isOtherBall = false; //다른 공이 동선 상에 있으면 벽보다 +1 위치에서 멈춤
    boolean isHole = false;

    for (int i = 1; i < 10; i++) {
      int nr = ball[0] + d[0] * i;
      int nc = ball[1] + d[1] * i;

      if (map[nr][nc] == 'O') {
        m = i;
        isHole = true;
        break;
      }

      if (map[nr][nc] == '#') {
        m = i - 1;
        break;
      }

      if (other[0] == nr && other[1] == nc) {
        isOtherBall = true;
      }
    }
    if (!isHole && isOtherBall) {
      m -= 1;
    }
    return (ball[0] + d[0] * m) * 10 + (ball[1] + d[1] * m);
  }
}
