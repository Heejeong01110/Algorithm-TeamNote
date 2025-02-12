package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class q20056 {

  private static final int DIFFERENT = 1000;
  private static int N, M, K;
  private static List<Node> nodes;
  private static int[][] direct = new int[][]{{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1},
      {0, -1}, {-1, -1}};

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
    N = Integer.parseInt(st.nextToken()); // <= 50
    M = Integer.parseInt(st.nextToken()); // <= N^2
    K = Integer.parseInt(st.nextToken()); // <= 1000
    nodes = new ArrayList<>();

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      nodes.add(new Node(Integer.parseInt(st.nextToken()) - 1,
          Integer.parseInt(st.nextToken()) - 1,
          Integer.parseInt(st.nextToken()),
          Integer.parseInt(st.nextToken()),
          Integer.parseInt(st.nextToken()),
          1));
    }

    br.close();
  }

  private static int Solution() {

    for (int k = 0; k < K; k++) {
      //1. 이동
      for (Node node : nodes) {
        node.r = (N * 1000 + node.r + direct[node.d][0] * node.s) % N;
        node.c = (N * 1000 + node.c + direct[node.d][1] * node.s) % N;
      }

      //2. 겹치는 노드 체크
      Map<Integer, Node> map = new HashMap<>();
      //key : (50,50) -> 5050

      for (Node node : nodes) {
        int key = node.r * 100 + node.c;
        Node info = map.getOrDefault(key, new Node(node.r, node.c, 0, 0, -1, 0));
        info.cnt += 1;
        info.m += node.m;
        info.s += node.s;
        if (info.d < 0) {
          info.d = node.d;
        } else if ((info.d % 2 != 0 || node.d % 2 != 0)
            && (info.d % 2 != 1 || node.d % 2 != 1)) {
          info.d = DIFFERENT; //1357
        }
        map.put(key, info);
      }

      List<Node> move = new LinkedList<>(map.values());
      nodes = new ArrayList<>();
      int size = move.size();
      for (int i = 0; i < size; i++) {
        Node node = move.get(i);
        if (node.cnt == 1) {
          nodes.add(node);
          continue;
        }

        int dir = (node.d == DIFFERENT) ? 1 : 0;
        if (node.m / 5 == 0) {
          continue;
        }
        for (int f = 0; f < 4; f++) {
          nodes.add(new Node(node.r, node.c, node.m / 5, node.s / node.cnt, dir, 1));
          dir += 2;
        }
      }
    }

    int res = 0;
    for (Node node : nodes) {
      res += node.m;
    }

    return res;
  }

  private static class Node {

    int r;
    int c;
    int m; //질량
    int s; //속력
    int d; //방향
    int cnt;

    public Node(int r, int c, int m, int s, int d, int cnt) {
      this.r = r;
      this.c = c;
      this.m = m;
      this.s = s;
      this.d = d;
      this.cnt = cnt;
    }
  }
}
