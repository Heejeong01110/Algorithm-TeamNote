package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class q16920 {

  private static int N, M, P;
  private static int[] S;
  private static int[][] map;

  private static int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    Solution();
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    P = Integer.parseInt(st.nextToken());
    S = new int[P + 1];
    map = new int[N][M];

    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= P; i++) {
      S[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < N; i++) {
      char[] chars = br.readLine().toCharArray();
      for (int j = 0; j < M; j++) {
        map[i][j] =
            chars[j] == '#' ? -1 : chars[j] == '.' ? 0 : Character.getNumericValue(chars[j]);
      }
    }

    br.close();
  }

  private static void Solution() {

    ArrayList<int[]>[] castles = new ArrayList[P + 1];
    for (int i = 1; i <= P; i++) {
      castles[i] = new ArrayList<>();
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (map[i][j] > 0) {
          castles[map[i][j]].add(new int[]{i, j, 0});
        }
      }
    }

    boolean[] flag = new boolean[P + 1];
    while (true) {
      for (int i = 1; i <= P; i++) {
        if (flag[i]) {
          continue;
        }
        if (!bfs(castles, i)) {
          flag[i] = true;
        }
      }

      if (check(flag)) {
        break;
      }
    }

    for (int i = 1; i <= P; i++) {
      System.out.print(castles[i].size() + " ");
    }

    return;
  }

  private static boolean check(boolean[] flag) {
    for (int i = 1; i <= P; i++) {
      if (!flag[i]) {
        return false;
      }
    }
    return true;
  }

  private static boolean isPossible(int row, int col) {
    return row >= 0 && row < N && col >= 0 && col < M;
  }

  private static boolean bfs(ArrayList<int[]>[] castles, int idx) {
    boolean result = false;
    PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
    boolean[][] visited = new boolean[N][M];
    for (int c = 0; c < castles[idx].size(); c++) {
      queue.add(castles[idx].get(c));
      visited[castles[idx].get(c)[0]][castles[idx].get(c)[1]] = true;
    }

    while (!queue.isEmpty()) {
      int[] now = queue.poll();

      if (now[2] == S[idx]) {
        continue;
      }

      for (int d = 0; d < 4; d++) {
        int nr = now[0] + dir[d][0];
        int nc = now[1] + dir[d][1];

        if (isPossible(nr, nc) && map[nr][nc] == 0) {
          map[nr][nc] = idx;
          castles[idx].add(new int[]{nr, nc, 0});
          queue.add(new int[]{nr, nc, now[2] + 1});
          result = true;
        }
      }
    }
    return result;
  }
}
