package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q11967 {

  private static int N;
  private static int M;
  private static int[][] infos;
  private static int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
  private static boolean[][] visited;
  private static boolean[][] light;

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
    infos = new int[M][4];

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 4; j++) {
        infos[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    br.close();
  }

  private static int Solution() {
    ArrayList<Node>[][] switches = new ArrayList[N + 1][N + 1];
    light = new boolean[N + 1][N + 1];
    light[1][1] = true;

    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= N; j++) {
        switches[i][j] = new ArrayList<>();
      }
    }

    for (int[] info : infos) {
      switches[info[0]][info[1]].add(new Node(info[2], info[3]));
    }

    return bfs(switches) + 1;
  }

  private static int bfs(ArrayList<Node>[][] switches) {
    int cnt = 0;

    Queue<Node> queue = new LinkedList<>();
    queue.add(new Node(1, 1));

    visited = new boolean[N + 1][N + 1];
    boolean isSwitchOn = false;

    while (!queue.isEmpty()) {
      Node now = queue.poll();

      for (int[] d : dir) {
        int nr = now.row + d[0];
        int nc = now.col + d[1];

        if (isPossible(nr, nc) && !visited[nr][nc] && light[nr][nc]) {
          queue.add(new Node(nr, nc));
          visited[nr][nc] = true;
        }
      }

      //1. 해당 자리에 있는 스위치들 키기
      for (Node node : switches[now.row][now.col]) {
        if (!light[node.row][node.col]) {
          isSwitchOn = true;
          light[node.row][node.col] = true;
          cnt++;
        }
      }
    }

    if (isSwitchOn) {
      return cnt + bfs(switches);
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
