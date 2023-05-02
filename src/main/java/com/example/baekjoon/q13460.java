package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class q13460 {

  private static int[][] directs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
  private static int N;
  private static int M;
  private static Character[][] map;
  private static Node start;
  private static int er;
  private static int ec;


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
    map = new Character[N][M];
    start = new Node(-1, -1, -1, -1, 0);
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      String s = st.nextToken();
      for (int j = 0; j < M; j++) {
        map[i][j] = s.charAt(j);
        if (map[i][j] == 'B') {
          start.br = i;
          start.bc = j;
        } else if (map[i][j] == 'R') {
          start.rr = i;
          start.rc = j;
        } else if (map[i][j] == 'O') {
          er = i;
          ec = j;
        }
      }
    }

    br.close();
  }

  private static int Solution() {

    int answer = -1;
    PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
    boolean[][][][] visited = new boolean[N][M][N][M];
    visited[start.rr][start.rc][start.br][start.bc] = true;
    queue.add(start);

    while (!queue.isEmpty()) {
      Node now = queue.poll();

      if (now.cost >= 10) {
        break;
      }

      if (now.rr == er && now.rc == ec) {
        answer = now.cost;
        break;
      }

      for (int i = 0; i < 4; i++) {
        Node next = getNextNode(now, directs[i]);

        if (!visited[next.rr][next.rc][next.br][next.bc] && !(next.br == er && next.bc == ec)) {
          visited[next.rr][next.rc][next.br][next.bc] = true;
          next.cost = now.cost + 1;
          queue.add(next);
        }

      }


    }

    return answer;
  }

  private static Node getNextNode(Node now, int[] direct) {
    int len = N;
    Node next = new Node(now.rr, now.rc, now.br, now.bc, now.cost);
    if (direct[0] == 0) {
      len = M;
    } else {
      len = N;
    }

    boolean whole = false;
    for (int i = len - 1; i > 0; i--) {
      if (!isPossible(now.rr + direct[0] * i, now.rc + direct[1] * i)) {
        continue;
      }

      if (map[now.rr + direct[0] * i][now.rc + direct[1] * i] == '#') {
        next.rr = now.rr + direct[0] * (i - 1);
        next.rc = now.rc + direct[1] * (i - 1);
        whole = false;
      } else if (map[now.rr + direct[0] * i][now.rc + direct[1] * i] == 'O') {
        next.rr = now.rr + direct[0] * i;
        next.rc = now.rc + direct[1] * i;
        whole = true;
      } else if (now.rr + direct[0] * i == now.br && now.rc + direct[1] * i == now.bc) {
        if (!whole) {
          next.rr -= direct[0];
          next.rc -= direct[1];
        }
      }
    }

    whole = false;
    for (int i = len - 1; i > 0; i--) {
      if (!isPossible(now.br + direct[0] * i, now.bc + direct[1] * i)) {
        continue;
      }

      if (map[now.br + direct[0] * i][now.bc + direct[1] * i] == '#') {
        next.br = now.br + direct[0] * (i - 1);
        next.bc = now.bc + direct[1] * (i - 1);
        whole = false;
      } else if (map[now.br + direct[0] * i][now.bc + direct[1] * i] == 'O') {
        next.br = now.br + direct[0] * i;
        next.bc = now.bc + direct[1] * i;
        whole = true;
      } else if (now.br + direct[0] * i == now.rr && now.bc + direct[1] * i == now.rc) {
        if (!whole) {
          next.br -= direct[0];
          next.bc -= direct[1];
        }
      }
    }

    return next;
  }

  private static boolean isPossible(int row, int col) {
    return row >= 0 && row < N && col >= 0 && col < M;
  }

  private static class Node {

    int rr;
    int rc;
    int br;
    int bc;
    int cost;

    public Node(int rr, int rc, int br, int bc, int cost) {
      this.rr = rr;
      this.rc = rc;
      this.br = br;
      this.bc = bc;
      this.cost = cost;
    }
  }
}
