package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class q14891 {

  private static final int[] Near = new int[]{-1, 1};
  private static int K;
  private static int[][] gears;
  private static int[][] turns;

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
    StringTokenizer st;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    gears = new int[5][8];
    for (int i = 1; i <= 4; i++) {
      String str = br.readLine();
      for (int j = 0; j < 8; j++) {
        gears[i][j] = Integer.parseInt(str.substring(j, j + 1));
      }
    }

    K = Integer.parseInt(br.readLine());
    turns = new int[K][2];
    for (int i = 0; i < K; i++) {
      st = new StringTokenizer(br.readLine());
      turns[i][0] = Integer.parseInt(st.nextToken());
      turns[i][1] = Integer.parseInt(st.nextToken());
    }

    br.close();
  }

  private static int Solution() {
    int[] startIdx = new int[5];

    Queue<Node> queue;
    boolean[] visited;
    boolean[] checkTurn;

    for (int k = 0; k < K; k++) {
      queue = new ArrayDeque<>();
      visited = new boolean[5];
      checkTurn = new boolean[4];

      queue.add(new Node(turns[k][0], turns[k][1]));
      visited[turns[k][0]] = true;

      for (int i = 1; i < 4; i++) {
        if (gears[i][(startIdx[i] + 2) % 8] != gears[i + 1][(startIdx[i + 1] + 6) % 8]) {
          checkTurn[i] = true;
        }
      }

      while (!queue.isEmpty()) {
        Node now = queue.poll();

        if (now.direct == 1) {
          startIdx[now.index] = (startIdx[now.index] + 7) % 8;
        } else {
          startIdx[now.index] = (startIdx[now.index] + 1) % 8;
        }

        for (int i = 0; i < 2; i++) {
          int next = now.index + Near[i];
          if (isPossible(next) && !visited[next] && checkTurn[Math.min(now.index, next)]) {
            queue.add(new Node(next, now.direct * (-1)));
            visited[next] = true;
          }
        }
      }
    }

    int score = 0;
    for (int i = 1; i <= 4; i++) {
      if (gears[i][startIdx[i]] == 1) {
        score += Math.pow(2, i - 1);
      }
    }
    return score;
  }

  private static boolean isPossible(int next) {
    return next >= 1 && next <= 4;
  }

  private static class Node {

    int index;
    int direct;

    public Node(int index, int direct) {
      this.index = index;
      this.direct = direct;
    }
  }

}
