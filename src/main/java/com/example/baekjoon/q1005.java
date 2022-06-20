package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q1005 {

  private static int T;
  private static int N;
  private static int K;
  private static int target;
  private static int[] times;
  private static int[] degree;
  private static ArrayList<Integer>[] nodes;
  private static StringBuilder sb;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    sb = new StringBuilder();

    T = Integer.parseInt(br.readLine());

    for (int t = 0; t < T; t++) {
      st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      K = Integer.parseInt(st.nextToken());

      nodes = new ArrayList[N + 1];
      times = new int[N + 1];
      degree = new int[N + 1];
      for (int i = 1; i <= N; i++) {
        nodes[i] = new ArrayList<>();
      }

      st = new StringTokenizer(br.readLine());
      for (int i = 1; i <= N; i++) {
        times[i] = Integer.parseInt(st.nextToken());
      }

      for (int i = 0; i < K; i++) {
        st = new StringTokenizer(br.readLine());
        int one = Integer.parseInt(st.nextToken());
        int two = Integer.parseInt(st.nextToken());
        nodes[one].add(two);
        degree[two]++;
      }
      target = Integer.parseInt(br.readLine());

      Solution();
    }
    System.out.print(sb);

    br.close();
  }

  private static void Solution() {
    int[] result = new int[N + 1];

    Queue<Integer> queue = new ArrayDeque<>();

    for (int i = 1; i <= N; i++) {
      if (degree[i] == 0) {
        queue.add(i);
      }
    }

    while (!queue.isEmpty()) {
      int now = queue.poll();

      if (now == target) {
        sb.append(result[target] + times[target]).append("\n");
        return;
      }

      for (int next : nodes[now]) {
        degree[next]--;

        result[next] = Math.max(result[next], result[now] + times[now]);
        if (degree[next] == 0) {
          queue.add(next);
        }
      }
    }
  }

}
