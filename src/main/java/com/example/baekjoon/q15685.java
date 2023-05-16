package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class q15685 {

  private static int[] dx = new int[]{1, 0, -1, 0};
  private static int[] dy = new int[]{0, -1, 0, 1};
  private static int N;
  private static int[][] curves;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    curves = new int[N][4];

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      curves[i][0] = Integer.parseInt(st.nextToken());
      curves[i][1] = Integer.parseInt(st.nextToken());
      curves[i][2] = Integer.parseInt(st.nextToken());
      curves[i][3] = Integer.parseInt(st.nextToken());
    }

    boolean[][] map = new boolean[101][101];
    for (int c = 0; c < N; c++) {
      ArrayList<Node> nodes = new ArrayList<>();
      nodes.add(new Node(curves[c][0], curves[c][1]));

      int d = curves[c][2];
      nodes.add(new Node(curves[c][0] + dx[d], curves[c][1] + dy[d]));

      for (int t = 0; t < curves[c][3]; t++) {//next를 기준으로 시계방향 90도 회전한 node 추가하기
        Node next = nodes.get(nodes.size() - 1);
        for (int i = nodes.size() - 2; i >= 0; i--) {
          nodes.add(turnRight(nodes.get(i), next));
        }
      }

      for (int i = 0; i < nodes.size(); i++) {
        map[nodes.get(i).x][nodes.get(i).y] = true;
      }
    }

    int cnt = 0;
    for (int i = 0; i < 100; i++) {
      for (int j = 0; j < 100; j++) {
        if (map[i][j] && map[i + 1][j] && map[i][j + 1] && map[i + 1][j + 1]) {
          cnt++;
        }
      }
    }

    System.out.println(cnt);
  }

  private static Node turnRight(Node target, Node center) {
    int xUp = target.x - center.x;
    int yUp = target.y - center.y;
    return new Node(center.x - yUp, center.y + xUp);
  }

  private static class Node {

    int x;
    int y;

    Node(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
