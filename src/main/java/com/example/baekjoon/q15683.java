package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class q15683 {

  private static final int[][] dir = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
  private static int N;
  private static int M;
  private static int[][] map;

  private static ArrayList<Node> cctvs;
  private static int[] minMemo;
  private static int minCount;

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
    M = Integer.parseInt(st.nextToken());
    map = new int[N][M];
    cctvs = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
        if (map[i][j] != 0 && map[i][j] != 6) {
          cctvs.add(new Node(i, j, map[i][j]));
        }
      }
    }

    br.close();
  }

  private static int Solution() {
    boolean[][] result = new boolean[N][M];
    cctvs.sort(((o1, o2) -> o2.type - o1.type));
    int count = 0;

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (map[i][j] != 0) {
          result[i][j] = true;
        } else {
          count++;
        }
      }
    }
    minCount = count;

    dfs(result, 0, count);

    return minCount;
  }


  private static void dfs(boolean[][] visited, int depth, int count) {
    if (count == 0) {
      minCount = 0;
      return;
    }

    if (minCount == 0) {
      return;
    }

    if (depth == cctvs.size()) {
      if (minCount > count) {
        minCount = count;
      }
      return;
    }

    Node now = cctvs.get(depth);
    int row;
    int col;
    int[] dirCount = new int[4];
    for (int d = 0; d < 4; d++) {
      row = now.row + dir[d][0];
      col = now.col + dir[d][1];
      while (true) {
        if (isPossible(row, col) && map[row][col] != 6) {
          dirCount[d] += 1;
        } else {
          break;
        }
        row += dir[d][0];
        col += dir[d][1];
      }
    }

    boolean[][] cloneVis = new boolean[N][M];
    int cnt = 0;
    switch (now.type) {
      case 1:
        for (int d = 0; d < 4; d++) {
          for (int i = 0; i < visited.length; i++) {
            cloneVis[i] = visited[i].clone();
          }

          row = now.row;
          col = now.col;
          cnt = 0;
          for (int i = 0; i < dirCount[d]; i++) {
            row += dir[d][0];
            col += dir[d][1];
            if (!cloneVis[row][col]) {
              cloneVis[row][col] = true;
              cnt++;
            }
          }
          dfs(cloneVis, depth + 1, count - cnt);
        }
        break;

      case 2:
        for (int d = 0; d < 2; d += 2) {
          for (int i = 0; i < visited.length; i++) {
            cloneVis[i] = visited[i].clone();
          }

          row = now.row;
          col = now.col;
          cnt = 0;
          for (int i = 0; i < dirCount[d]; i++) {
            row += dir[d][0];
            col += dir[d][1];
            if (!cloneVis[row][col]) {
              cloneVis[row][col] = true;
              cnt++;
            }
          }

          row = now.row;
          col = now.col;
          for (int i = 0; i < dirCount[d + 1]; i++) {
            row += dir[d + 1][0];
            col += dir[d + 1][1];
            if (!cloneVis[row][col]) {
              cloneVis[row][col] = true;
              cnt++;
            }
          }
          dfs(cloneVis, depth + 1, count - cnt);
        }
        break;

      case 3:

        cnt = 0;
        for (int d = 0; d < 2; d++) {
          for (int i = 0; i < visited.length; i++) {
            cloneVis[i] = visited[i].clone();
          }

          row = now.row;
          col = now.col;
          for (int i = 0; i < dirCount[d]; i++) {
            row += dir[d][0];
            col += dir[d][1];
            if (!cloneVis[row][col]) {
              cloneVis[row][col] = true;
              cnt++;
            }
          }

          for (int j = 2; j < 4; j++) {
            boolean[][] clone2 = new boolean[N][M];
            int newCnt = 0;
            for (int i = 0; i < visited.length; i++) {
              clone2[i] = cloneVis[i].clone();
            }

            row = now.row;
            col = now.col;
            for (int i = 0; i < dirCount[j]; i++) {
              row += dir[i][0];
              col += dir[i][1];
              if (!clone2[row][col]) {
                clone2[row][col] = true;
                newCnt++;
              }
            }
            dfs(clone2, depth + 1, count - cnt - newCnt);
          }

        }

        break;

      case 4:
        cnt = 0;
        for (int i = 0; i < visited.length; i++) {
          cloneVis[i] = visited[i].clone();
        }

        for (int d = 0; d < 4; d++) {

          row = now.row;
          col = now.col;
          for (int i = 0; i < dirCount[d]; i++) {
            row += dir[d][0];
            col += dir[d][1];

            if (!cloneVis[row][col]) {
              cloneVis[row][col] = true;
              cnt++;
            }
          }
        }

        for (int d = 0; d < 4; d++) {
          boolean[][] clone2 = new boolean[N][M];
          for (int i = 0; i < visited.length; i++) {
            clone2[i] = cloneVis[i].clone();
          }

          row = now.row;
          col = now.col;
          int newCnt = 0;
          for (int i = 0; i < dirCount[d]; i++) {
            row += dir[d][0];
            col += dir[d][1];

            if (clone2[row][col]) {
              clone2[row][col] = false;
              newCnt++;
            }
          }

          dfs(clone2, depth + 1, count - cnt + newCnt);
        }

        break;
      case 5:
        cnt = 0;
        for (int i = 0; i < visited.length; i++) {
          cloneVis[i] = visited[i].clone();
        }

        for (int d = 0; d < 4; d++) {
          row = now.row;
          col = now.col;
          for (int i = 0; i < dirCount[d]; i++) {
            row += dir[d][0];
            col += dir[d][1];

            if (!cloneVis[row][col]) {
              cloneVis[row][col] = true;
              cnt++;
            }
          }
        }
        dfs(cloneVis, depth + 1, count - cnt);

        break;
      default:
        break;
    }
  }

  private static boolean isPossible(int row, int col) {
    return row >= 0 && row < N && col >= 0 && col < M;
  }


  private static class Node {

    int row;
    int col;
    int type;

    public Node(int row, int col, int type) {
      this.row = row;
      this.col = col;
      this.type = type;
    }

  }
}
