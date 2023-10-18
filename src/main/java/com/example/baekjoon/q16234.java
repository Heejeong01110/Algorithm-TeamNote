package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q16234 {

  private static int N, L, R;
  private static int[][] inp, update;
  private static boolean[][] visited;
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

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    L = Integer.parseInt(st.nextToken());
    R = Integer.parseInt(st.nextToken());
    inp = new int[N][N];
    update = new int[N][N];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        inp[i][j] = Integer.parseInt(st.nextToken());
        update[i][j] = inp[i][j];
      }
    }

    br.close();
  }

  private static int Solution() {
    int cnt = 0;
    boolean temp;

    while (true) {
      temp = false;
      visited = new boolean[N][N];
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          if (!visited[i][j]) {
            boolean check = check(i, j);
            temp = temp || check;
          }
        }
      }

      if (!temp) {
        break;
      }
      cnt++;
    }

    return cnt;
  }

  private static boolean check(int row, int col) {
    ArrayList<int[]> list = new ArrayList<>();
    Queue<int[]> queue = new LinkedList<>();
    int sum = 0, cnt = 0;

    queue.add(new int[]{row, col});
    list.add(new int[]{row, col});
    visited[row][col] = true;
    sum += inp[row][col];
    cnt += 1;

    while (!queue.isEmpty()) {
      int[] now = queue.poll();

      for (int d = 0; d < 4; d++) {
        int nr = now[0] + dir[d][0];
        int nc = now[1] + dir[d][1];
        if (!isPossible(nr, nc)) {
          continue;
        }
        int diff = Math.abs(inp[now[0]][now[1]] - inp[nr][nc]);

        if (!visited[nr][nc] && (diff >= L && diff <= R)) {
          queue.add(new int[]{nr, nc});
          list.add(new int[]{nr, nc});
          visited[nr][nc] = true;
          sum += inp[nr][nc];
          cnt += 1;
        }
      }
    }

    int avg = sum / cnt;
    if (cnt == 1) {
      return false;
    }

    for(int[] item : list){
      inp[item[0]][item[1]] = avg;
    }
    return true;
  }

  private static boolean isPossible(int r, int c) {
    return r >= 0 && r < N && c >= 0 && c < N;
  }

}
