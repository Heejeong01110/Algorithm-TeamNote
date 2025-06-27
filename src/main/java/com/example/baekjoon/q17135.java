package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class q17135 {

  private static final int[][] dir = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
  private static int N, M, D, answer, totalEnemy;
  private static int[][] map, nowMap;

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
    D = Integer.parseInt(st.nextToken());
    map = new int[N + 1][M];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    br.close();
  }

  private static int Solution() {
    totalEnemy = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (map[i][j] == 1) {
          totalEnemy += 1;
        }
      }
    }

    answer = 0;
    perm(new boolean[M], 0, 0);
    return answer;
  }

  private static void perm(boolean[] visited, int depth, int start) {
    if (depth == 3) {
      int[] loc = new int[3];
      int idx = 0;
      for (int i = 0; i < M; i++) {
        if (visited[i]) {
          loc[idx++] = i;
        }
      }
      answer = Math.max(answer, getRemoveEnemy(loc));
      return;
    }

    for (int i = start; i < M; i++) {
      if (answer == totalEnemy) {
        return;
      }
      if (!visited[i]) {
        visited[i] = true;
        perm(visited, depth + 1, i + 1);
        visited[i] = false;
      }
    }
  }

  private static int getRemoveEnemy(int[] loc) {
    nowMap = new int[N + 1][M];
    for (int i = 0; i < N; i++) {
      System.arraycopy(map[i], 0, nowMap[i], 0, M);
    }
    int res = 0;
    for (int i = 0; i < N; i++) {
      ArrayList<int[]> attacks = getAttackLoc(loc);//1. 공격 위치 확인
      res += attackEnemy(attacks);//2. 궁수 공격
      if (moveEnemy()) {//3. 적 이동
        break; //모든 적 제거시
      }
    }
    return res;
  }

  private static ArrayList<int[]> getAttackLoc(int[] loc) {
    ArrayList<int[]> res = new ArrayList<>();
    Queue<int[]> queue;
    boolean[][] visited;
    for (int c : loc) {
      queue = new ArrayDeque<>();
      visited = new boolean[N + 1][M];

      queue.add(new int[]{N, c, 0});
      visited[N][c] = true;

      while (!queue.isEmpty()) {
        int[] now = queue.poll();
        if (nowMap[now[0]][now[1]] == 1) {
          res.add(new int[]{now[0], now[1]});
          break;
        }

        for (int[] d : dir) {
          int nr = now[0] + d[0];
          int nc = now[1] + d[1];

          if (now[2] + 1 <= D && (nr >= 0 && nr < N && nc >= 0 && nc < M) && !visited[nr][nc]) {
            queue.add(new int[]{nr, nc, now[2] + 1});
            visited[nr][nc] = true;
          }
        }
      }
    }
    return res;
  }

  private static int attackEnemy(ArrayList<int[]> attacks) {
    int res = 0;
    for (int[] a : attacks) {
      if (nowMap[a[0]][a[1]] != 0) {
        res += 1;
        nowMap[a[0]][a[1]] = 0;
      }
    }
    return res;
  }

  private static boolean moveEnemy() {
    boolean tmp = true;
    for (int i = N - 1; i > 0; i--) {
      for (int j = 0; j < M; j++) {
        nowMap[i][j] = nowMap[i - 1][j];
        if (nowMap[i][j] == 1) {
          tmp = false;
        }
      }
    }
    Arrays.fill(nowMap[0], 0);
    return tmp;
  }

}
