package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q1012 {

  private static int testCases, width, height, K;
  private static int[][] map;
  private static boolean[][] visited;
  private static int[] dx = {0, 0, -1, 1};
  private static int[] dy = {-1, 1, 0, 0};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int testCases = Integer.parseInt(br.readLine());
    StringTokenizer st;

    for (int i = 0; i < testCases; i++) {
      st = new StringTokenizer(br.readLine());
      width = Integer.parseInt(st.nextToken());
      height = Integer.parseInt(st.nextToken());
      K = Integer.parseInt(st.nextToken());
      map = new int[width][height];
      visited = new boolean[width][height];

      for (int j = 0; j < K; j++) {
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        map[x][y] = 1;
      }
      int answer = 0;
      for (int j = 0; j < width; j++) {
        for (int k = 0; k < height; k++) {
          if (map[j][k] == 1 && !visited[j][k]) {
            bfs(j, k);
            answer++;
          }
        }
      }
      System.out.println(answer);
    }

    br.close();
  }

  private static void bfs(int x, int y) {
    Queue<Node> queue = new LinkedList<>();
    queue.add(new Node(x, y));

    while (!queue.isEmpty()) {
      Node now = queue.poll();
      visited[now.x][now.y] = true;

      for (int i = 0; i < 4; i++) {
        int nx = now.x + dx[i];
        int ny = now.y + dy[i];

        if (nx >= width || ny >= height || nx < 0 || ny < 0) {
          continue;
        }
        if (visited[nx][ny] || map[nx][ny] != 1) {
          continue;
        }

        queue.add(new Node(nx, ny));
      }
    }
  }

  static class Node {

    int x;
    int y;

    public Node(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
