package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class q2151 {


  private static final int[][] direct = new int[][]{{-1,0}, {0, -1}, {1, 0}, {0, 1}};

  private static int N;
  private static Character[][] map;
  private static int result;
  private static Node start;
  private static Node end;

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

    N = Integer.parseInt(br.readLine());
    map = new Character[N][N];

    int idx = 0;
    for (int i = 0; i < N; i++) {
      String str = br.readLine();
      for (int j = 0; j < N; j++) {
        map[i][j] = str.charAt(j);

        // 문 좌표 저장
        if (map[i][j] == '#') {
          if (idx == 0) {
            start = new Node(i, j);
          } else {
            end = new Node(i, j);
          }
          idx++;
        }
      }
    }

    br.close();
  }

  private static int Solution() {
    int answer;
    result = Integer.MAX_VALUE;
    boolean[][][] visited = new boolean[N][N][4];

    PriorityQueue<Mirror> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.cnt));

    for (int i = 0; i < 4; i++) {
      queue.add(new Mirror(start.row, start.col, i, 0));
    }

    while (!queue.isEmpty()) {
      Mirror now = queue.poll();

      visited[now.row][now.col][now.dir] = true;

      if (now.row == end.row && now.col == end.col) {
        result = now.cnt;
        return result;
      }

      int nr = now.row + direct[now.dir][0];
      int nc = now.col + direct[now.dir][1];

      if (isPossible(nr, nc) && !visited[nr][nc][now.dir] && map[nr][nc] != '*') {
        // 거울을 설치할 수 있는 곳인 경우
        if (map[nr][nc] == '!') {
          // 시계 방향 (오른쪽)
          int nDir = (now.dir + 3) % 4;
          queue.add(new Mirror(nr, nc, nDir, now.cnt + 1));

          // 반시계 방향 (왼쪽)
          nDir = (now.dir + 1) % 4;
          queue.add(new Mirror(nr, nc, nDir, now.cnt + 1));
        }

        queue.add(new Mirror(nr, nc, now.dir, now.cnt));
      }

    }
    return result;
  }

  private static boolean isPossible(int row, int col) {
    return row >= 0 && row < N && col >= 0 && col < N;
  }


  private static class Mirror {

    int row;
    int col;
    int dir; // 거울의 현재 방향
    int cnt; // 사용한 거울 개수

    public Mirror(int row, int col, int dir, int cnt) {
      this.row = row;
      this.col = col;
      this.dir = dir;
      this.cnt = cnt;
    }
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
