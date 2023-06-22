package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q14267 {

  private static int N;
  private static int M;
  private static int[] relations;
  private static int[][] comps;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    ArrayList<Integer>[] maps = new ArrayList[N + 1];

    for (int i = 1; i <= N; i++) {
      maps[i] = new ArrayList<>();
    }

    for (int i = 1; i <= N; i++) {
      if (relations[i] != -1) {
        maps[relations[i]].add(i);
      }
    }

    int[] dp = new int[N + 1];

    for (int i = 0; i < M; i++) {
      dp[comps[i][0]] += comps[i][1];
    }

    boolean[] visited = new boolean[N + 1];
    for (int i = 1; i < N; i++) {
      if (visited[i]) {
        continue;
      }

      Queue<Integer> queue = new LinkedList<>();
      queue.add(i);
      visited[i] = true;

      while (!queue.isEmpty()) {
        Integer now = queue.poll();
        for (Integer next : maps[now]) {
          int plus = relations[next] == -1 ? 0 : dp[relations[next]];
          dp[next] += plus;
          visited[next] = true;
          queue.add(next);
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= N; i++) {
      sb.append(dp[i]).append(" ");
    }
    System.out.print(sb.substring(0, sb.length() - 1));
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    relations = new int[N + 1];
    comps = new int[M][2];

    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      relations[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      comps[i][0] = Integer.parseInt(st.nextToken());
      comps[i][1] = Integer.parseInt(st.nextToken());
    }

    br.close();
  }

}
