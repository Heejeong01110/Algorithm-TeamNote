package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q11725 {

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine());
    ArrayList<Integer>[] ary = new ArrayList[N+1];

    for (int i = 1; i <= N; i++) {
      ary[i] = new ArrayList<>();
    }

    for (int i = 0; i < N - 1; i++) {
      st = new StringTokenizer(br.readLine());
      int one = Integer.parseInt(st.nextToken());
      int two = Integer.parseInt(st.nextToken());
      ary[one].add(two);
      ary[two].add(one);
    }

    int[] parent = new int[N + 1];
    boolean[] visited = new boolean[N + 1];
    parent[1] = -1;

    Queue<Integer> queue = new ArrayDeque<>();
    queue.add(1);
    parent[1] = -1;
    visited[1] = true;

    while (!queue.isEmpty()) {
      Integer now = queue.poll();
      for (int i = 0; i < ary[now].size(); i++) {
        Integer current = ary[now].get(i);
        if (!visited[current]) {
          queue.add(current);
          visited[current] = true;
          parent[current] = now;
        }
      }
    }

    for (int i = 2; i <= N; i++) {
      sb.append(parent[i]).append("\n");
    }

    System.out.print(sb);
    br.close();

  }
}
