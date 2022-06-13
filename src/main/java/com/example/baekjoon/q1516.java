package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q1516 {

  private static int N;
  private static int[] times;
  private static int[] degree;
  private static ArrayList<Integer>[] nodes;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    output(Solution());
  }

  private static void output(String result) {
    System.out.print(result);
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());
    times = new int[N + 1];
    degree = new int[N + 1];
    nodes = new ArrayList[N + 1];

    for (int i = 1; i <= N; i++) {
      nodes[i] = new ArrayList<>();
    }

    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      times[i] = Integer.parseInt(st.nextToken());

      int num = Integer.parseInt(st.nextToken());
      while (num != -1) {
        nodes[num].add(i);
        degree[i]++;
        num = Integer.parseInt(st.nextToken());
      }
    }

    br.close();
  }

  private static String Solution() {
    Queue<Integer> queue = new ArrayDeque<>();
    int[] result = new int[N + 1];

    // 차수가 0인 정점 큐에 넣기
    for (int i = 1; i <= N; i++) {
      if (degree[i] == 0) {
        queue.add(i);
      }
    }

    while (!queue.isEmpty()) {
      Integer now = queue.poll();

      for (int next : nodes[now]) {
        degree[next]--;

        result[next] = Math.max(result[next], result[now] + times[now]);

        if (degree[next] == 0) {
          queue.add(next);
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= N; i++) {
      sb.append(result[i] + times[i]).append("\n");
    }
    return sb.toString();
  }

}
