package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q2573 {

  private static final int[][] dir = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
  private static int N, M;
  private static int[][] inp;

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

    inp = new int[N][M];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        inp[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    br.close();
  }

  private static int Solution() {

    ArrayList<ArrayList<int[]>> ice = new ArrayList<>();
    boolean[][] visited = new boolean[N][M];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (!visited[i][j] && inp[i][j] != 0) {
          ice.add(getIceMass(visited, i, j));
        }
      }
    }

    int maxIce = 0;
    int cnt = 0;
    while (!ice.isEmpty()) {
      cnt++;
      int size = ice.size();
      for (int s = 0; s < size; s++) {
        meltIce(ice.get(s));
      }
      if (!separateIce(ice)) {
        return cnt;
      }
    }

    return maxIce;
  }

  private static ArrayList<int[]> getIceMass(boolean[][] visited, int r, int c) {
    ArrayList<int[]> res = new ArrayList<>();
    Queue<int[]> queue = new ArrayDeque<>();

    queue.add(new int[]{r, c});
    res.add(new int[]{r, c});
    visited[r][c] = true;

    while (!queue.isEmpty()) {
      int[] now = queue.poll();

      for (int d = 0; d < 4; d++) {
        int nr = now[0] + dir[d][0];
        int nc = now[1] + dir[d][1];

        if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc] && inp[nr][nc] != 0) {
          queue.add(new int[]{nr, nc});
          res.add(new int[]{nr, nc});
          visited[nr][nc] = true;
        }
      }
    }

    return res;
  }

  private static void meltIce(ArrayList<int[]> ice) {
    int s = ice.size();
    int[][] meltMap = new int[N][M];
    for (int i = 0; i < s; i++) {
      int r = ice.get(i)[0];
      int c = ice.get(i)[1];

      int melt = 0;
      for (int d = 0; d < 4; d++) {
        int nr = r + dir[d][0];
        int nc = c + dir[d][1];
        if (nr >= 0 && nr < N && nc >= 0 && nc < M && inp[nr][nc] == 0) {
          melt += 1;
        }
      }
      meltMap[r][c] = melt;
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (meltMap[i][j] != 0) {
          if (inp[i][j] <= meltMap[i][j]) {
            inp[i][j] = 0;
            for (int[] c : ice) {
              if (c[0] == i && c[1] == j) {
                ice.remove(c);
                break;
              }
            }
          } else {
            inp[i][j] -= meltMap[i][j];
          }
        }
      }
    }
  }

  private static boolean separateIce(ArrayList<ArrayList<int[]>> ice) {
    int size = ice.size();

    boolean[][] visited = new boolean[N][M];
    for (int s = 0; s < size; s++) {
      if (ice.get(s).isEmpty()) {
        ice.remove(s);
        return true;
      }
      ArrayList<int[]> iceMass = getIceMass(visited, ice.get(s).get(0)[0], ice.get(s).get(0)[1]);
      if (ice.get(s).size() != iceMass.size()) {
        return false;
      }
    }
    return true;
  }


}
