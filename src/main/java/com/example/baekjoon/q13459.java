package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class q13459 {

  private static int N, M;
  private static char[][] map;
  private static int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

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
      map[i] = br.readLine().toCharArray();
    }

    br.close();
  }

  private static int Solution() {

    int[] red = new int[2];
    int[] blue = new int[2];
    int[] hole = new int[2];

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (map[i][j] == 'R') {
          map[i][j] = '.';
          red = new int[]{i, j};
        }
        if (map[i][j] == 'B') {
          map[i][j] = '.';
          blue = new int[]{i, j};
        }
        if (map[i][j] == 'O') {
          hole = new int[]{i, j};
        }
      }
    }

    int[][][][] memo = new int[N][M][N][M];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        for (int k = 0; k < N; k++) {
          Arrays.fill(memo[i][j][k], 11);
        }
      }
    }

    PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[4] - o2[4]);
    queue.add(new int[]{red[0], red[1], blue[0], blue[1], 0});
    memo[red[0]][red[1]][blue[0]][blue[1]] = 0;

    while (!queue.isEmpty()) {
      int[] now = queue.poll();

      if (now[4] > 10) {
        return 0;
      }

      if (now[0] == hole[0] && now[1] == hole[1]) {
        return 1;
      }

      for (int[] d : dir) {
        int[] next = tilt(now, d);
        if (next[4] == 1 && memo[next[0]][next[1]][next[2]][next[3]] > now[4] + 1) {
          memo[next[0]][next[1]][next[2]][next[3]] = now[4] + 1;
          queue.add(new int[]{next[0], next[1], next[2], next[3], now[4] + 1});
        }
      }


    }

    return 0;
  }

  private static int[] tilt(int[] now, int[] d) {
    int[] red = new int[]{now[0], now[1]};
    int[] blue = new int[]{now[2], now[3]};

    while (true) {
      if (map[blue[0] + d[0]][blue[1] + d[1]] == '#') {
        break;
      } else if (map[blue[0] + d[0]][blue[1] + d[1]] == 'O') {
        blue[0] += d[0];
        blue[1] += d[1];
        return new int[]{0, 0, 0, 0, 0}; //blue가 hole에 들어가는 경우
      } else if (map[blue[0] + d[0]][blue[1] + d[1]] == '.') {
        blue[0] += d[0];
        blue[1] += d[1];
      }
    }

    while (true) {
      if (map[red[0] + d[0]][red[1] + d[1]] == '#') {
        break;
      } else if (map[red[0] + d[0]][red[1] + d[1]] == 'O') {
        red[0] += d[0];
        red[1] += d[1];
        break;
      } else if (map[red[0] + d[0]][red[1] + d[1]] == '.') {
        red[0] += d[0];
        red[1] += d[1];
      }
    }

    if (blue[0] == red[0] && blue[1] == red[1]) {
      //둘 중 하나는 한칸 뒤로 원상복귀 시켜줘야 함
      if (d[0] == 1) {
        red[0] -= now[0] > now[2] ? 0 : d[0];
        blue[0] -= now[0] > now[2] ? d[0] : 0;
      } else if (d[0] == -1) {
        red[0] -= now[0] < now[2] ? 0 : d[0];
        blue[0] -= now[0] < now[2] ? d[0] : 0;
      } else if (d[1] == 1) {
        red[1] -= now[1] > now[3] ? 0 : d[1];
        blue[1] -= now[1] > now[3] ? d[1] : 0;
      } else if (d[1] == -1) {
        red[1] -= now[1] < now[3] ? 0 : d[1];
        blue[1] -= now[1] < now[3] ? d[1] : 0;
      }
    }

    return new int[]{red[0], red[1], blue[0], blue[1], 1};
  }


}
