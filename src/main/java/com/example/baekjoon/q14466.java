package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q14466 {

  private static int N, K, R;
  private static int[][][] map;
  private static ArrayList<Node> cows;
  private static int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
  private static boolean[][] memo;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    output(Solution());
  }

  private static void output(int result) {
    System.out.print(result);
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    R = Integer.parseInt(st.nextToken());
    map = new int[N + 1][N + 1][4];
    cows = new ArrayList<>();

    for (int i = 0; i < R; i++) {
      st = new StringTokenizer(br.readLine());
      Node one = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
      Node two = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

      for (int j = 0; j < 4; j++) {
        if (one.row - two.row == dir[j][0] && one.col - two.col == dir[j][1]) {
          map[one.row][one.col][j + (j % 2 == 0 ? 1 : -1)] = 1;
          map[two.row][two.col][j] = 1;
          break;
        }
      }
    }

    for (int i = 0; i < K; i++) {
      st = new StringTokenizer(br.readLine());
      cows.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
    }

    br.close();
  }

  private static int Solution() {
    boolean[][] checked = new boolean[N + 1][N + 1];
    boolean[][] checkCow = new boolean[K + 1][K + 1];

    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= N; j++) {
        if (checked[i][j]) {
          continue;
        }

        boolean[][] visited = new boolean[N + 1][N + 1];
        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(i, j));
        visited[i][j] = true;
        checked[i][j] = true;

        while (!queue.isEmpty()) {
          Node now = queue.poll();
          
          for (int d = 0; d < 4; d++) {
            int nr = now.row + dir[d][0];
            int nc = now.col + dir[d][1];
            if (isPossible(nr, nc) && !visited[nr][nc] && map[now.row][now.col][d] != 1) {
              if(map[now.row][now.col][d] == 0){
                checked[nr][nc] = true;
              }
              visited[nr][nc] = true;
              queue.add(new Node(nr, nc));
            }
          }
        }

        for (int k1 = 0; k1 < K; k1++) {
          if (!visited[cows.get(k1).row][cows.get(k1).col]) {
            continue;
          }
          for (int k2 = k1 + 1; k2 < K; k2++) {
            if (visited[cows.get(k2).row][cows.get(k2).col]) {
              checkCow[k1][k2] = true;
            }
          }
        }
      }
    }

    int cnt = 0;
    for (int k1 = 0; k1 < K; k1++) {
      for (int k2 = k1 + 1; k2 < K; k2++) {
        if (!checkCow[k1][k2]) {
          cnt += 1;
        }
      }
    }

    return cnt;
  }


  private static boolean isPossible(int row, int col) {
    return row > 0 && row <= N && col > 0 && col <= N;
  }


  private static class Node {

    int row;
    int col;

    public Node(int row, int col) {
      this.row = row;
      this.col = col;
    }
  }
}
