package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class q17472 {

  private static int N;
  private static int M;
  private static int[][] map;
  private static boolean[][] visited;
  private static int[][] numberMap;
  private static int[] parent;
  private static int[][] direct = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

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
    map = new int[N][M];
    numberMap = new int[N][M];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    br.close();
  }

  private static void Solution() {
    visited = new boolean[N][M];

    Integer index = 1;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (!visited[i][j] && map[i][j] == 1) {
          dfs(i, j, index++);
        }
      }
    }

// 간선의 비용 구하기
    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
    for (int i = 1; i < index; i++) {
      for (int j = i + 1; j < index; j++) {
        int cost = getBridge(i, j);
        if (cost != 0) {
          pq.add(new int[]{i, j, cost});
        }
      }
    }

    // makeSet
    parent = new int[index];
    for (int i = 1; i < index; i++) {
      parent[i] = i;
    }

    int ans = 0;
    // 다리선택 MST
    while (!pq.isEmpty()) {
      int[] now = pq.poll();
      int x = find(now[0]);
      int y = find(now[1]);
      if (x != y) {
        union(now[0], now[1]);
        ans += now[2];
      }
    }

    // 결과
    boolean flag = true;
    for (int i = 1; i < index; i++) {
      if (find(i) != 1) {
        flag = false;
        break;
      }
    }

    System.out.print(flag ? ans : -1);

    return;
  }

  private static void union(int i, int j) {
    int x = find(i);
    int y = find(j);

    if (x > y) {
      parent[x] = y;
    } else {
      parent[y] = x;
    }
  }

  private static int find(int i) {
    if (i == parent[i]) {
      return i;
    }
    return parent[i] = find(parent[i]);
  }

  private static int getBridge(int start, int end) {
    boolean[][][] visit = new boolean[N][M][4];
    Queue<int[]> q = new LinkedList<>();

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (numberMap[i][j] != start) {
          continue;
        }
        for (int k = 0; k < direct.length; k++) {
          int r = i + direct[k][0];
          int c = j + direct[k][1];
          if (!check(r, c) || numberMap[r][c] != 0) {
            continue;
          }
          q.add(new int[]{r, c, 0, k});
          visit[r][c][k] = true;
        }
      }
    }

    int ret = 0;

    while (!q.isEmpty()) {
      int[] now = q.poll();
      if (numberMap[now[0]][now[1]] == end) {
        if (now[2] == 1) {
          continue;
        }
        ret = now[2];
        break;
      }
      int nr = now[0] + direct[now[3]][0];
      int nc = now[1] + direct[now[3]][1];

      if (check(nr, nc) && !visit[nr][nc][now[3]]
          && (numberMap[nr][nc] == 0 || numberMap[nr][nc] == end)) {
        visit[nr][nc][now[3]] = true;
        q.add(new int[]{nr, nc, now[2] + 1, now[3]});
      }
    }

    return ret;
  }


  private static void dfs(int row, int col, int index) {
    numberMap[row][col] = index;

    for (int i = 0; i < 4; i++) {
      if (!check(row + direct[i][0], col + direct[i][1])) {
        continue;
      }
      if (!visited[row + direct[i][0]][col + direct[i][1]]
          && map[row + direct[i][0]][col + direct[i][1]] == 1) {
        numberMap[row + direct[i][0]][col + direct[i][1]] = index;
        visited[row + direct[i][0]][col + direct[i][1]] = true;
        dfs(row + direct[i][0], col + direct[i][1], index);
      }
    }
  }

  private static boolean check(int row, int col) {
    return row >= 0 && row < N && col >= 0 && col < M;
  }

}
