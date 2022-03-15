package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class q11724 {

  private static int N;
  private static int M;
  private static boolean[][] nodes;
  private static boolean[] visited;

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
    nodes = new boolean[N + 1][N + 1];

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int one = Integer.parseInt(st.nextToken());
      int two = Integer.parseInt(st.nextToken());
      nodes[one][two] = true;
      nodes[two][one] = true;
    }

    br.close();
  }

  private static int Solution() {
    Integer result = 0;
    visited = new boolean[N + 1];

    for (int i = 1; i <= N; i++) {
      if (!visited[i]) {
        result += 1;
        bfs(i);
      }
    }
    return result;
  }

  private static void bfs(int start) {
    Queue<Integer> queue = new ArrayDeque<>();
    queue.add(start);
    visited[start] = true;

    while (!queue.isEmpty()) {
      Integer now = queue.poll();

      for (int i = 1; i <= N; i++) {
        if (!visited[i] && nodes[now][i]) {
          queue.add(i);
          visited[i] = true;
        }
      }
    }
  }

}
