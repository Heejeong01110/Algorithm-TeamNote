package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class q4179 {

  private static int r;
  private static int c;
  private static char[][] maze;
  private static boolean[][] visited;
  private static Node node;
  private static int[] dx = {-1, 1, 0, 0};
  private static int[] dy = {0, 0, -1, 1};


  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");

    r = Integer.parseInt(input[0]);
    c = Integer.parseInt(input[1]);

    maze = new char[r][c];
    visited = new boolean[r][c];
    Queue<Node> fire = new LinkedList<>();

    for (int i = 0; i < r; i++) {
      input = br.readLine().split("");
      for (int j = 0; j < c; j++) {
        maze[i][j] = input[j].charAt(0);

        if (maze[i][j] == 'J') {
          if (isEdge(i, j)) {
            System.out.println(1);
            return;
          }

          maze[i][j] = '.';
          node = new Node(i, j, 0, 0);
        } else if (maze[i][j] == 'F') {
          fire.add(new Node(i, j, 1, 0));
        }
      }
    }

    bfs(fire);
  }

  private static void bfs(Queue<Node> fireQue) {
    int x;
    int y;
    int count;

    fireQue.add(node); // 불 - 지훈의 순서로 queue에 넣어줌
    visited[node.x][node.y] = true;

    while (!fireQue.isEmpty()) {
      Node p = fireQue.poll();
      x = p.x;
      y = p.y;
      count = p.count;

      // 종료 조건
      if (isEdge(x, y) && p.type == 0) {
        System.out.println(count + 1);
        return;
      }

      for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];

        if (!isRange(nx, ny) || maze[nx][ny] == '#' || maze[nx][ny] == 'F') {
          continue;
        }

        if (p.type == 0 && !visited[nx][ny]) {
          // 지훈
          fireQue.add(new Node(nx, ny, p.type, count + 1));
          visited[nx][ny] = true;
        } else if (p.type == 1) {
          // 불
          maze[nx][ny] = 'F';
          fireQue.add(new Node(nx, ny, p.type, count + 1));
        }
      }
    }

    System.out.println("IMPOSSIBLE");
  }

  private static boolean isRange(int x, int y) {
    if (x >= 0 && y >= 0 && x < r && y < c) {
      return true;
    }
    return false;
  }

  private static boolean isEdge(int x, int y) {
    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      if (!isRange(nx, ny)) {
        return true;
      }
    }

    return false;
  }

  private static class Node {
    int x;
    int y;
    int type;
    int count;

    public Node(int x, int y, int type, int count) {
      this.x = x;
      this.y = y;
      this.type = type;
      this.count = count;
    }
  }


}
