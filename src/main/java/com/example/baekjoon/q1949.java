package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class q1949 {

  private static int N;
  private static int[] costs;
  private static int[][] inp;

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

    StringTokenizer st;
    N = Integer.parseInt(br.readLine());
    costs = new int[N + 1];
    inp = new int[N][2];

    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      costs[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < N - 1; i++) {
      st = new StringTokenizer(br.readLine());
      inp[i][0] = Integer.parseInt(st.nextToken());
      inp[i][1] = Integer.parseInt(st.nextToken());
    }

    br.close();
  }

  private static int Solution() {
    HashMap<Integer, ArrayList<Integer>> maps = new HashMap<>();

    for (int i = 0; i < N - 1; i++) {
      ArrayList<Integer> one = maps.getOrDefault(inp[i][0], new ArrayList<>());
      ArrayList<Integer> two = maps.getOrDefault(inp[i][1], new ArrayList<>());
      one.add(inp[i][1]);
      two.add(inp[i][0]);
      maps.put(inp[i][0], one);
      maps.put(inp[i][1], two);
    }

    int[][] dp = new int[N + 1][2];
    dfs(1, 0, maps, dp);

    return Math.max(dp[1][0], dp[1][1]);
  }

  private static void dfs(int now, int parent, HashMap<Integer, ArrayList<Integer>> maps,
      int[][] dp) {
    for (Integer near : maps.getOrDefault(now, new ArrayList<>())) {
      if (near != parent) {
        dfs(near, now, maps, dp);
        dp[now][0] += Math.max(dp[near][0], dp[near][1]);
        dp[now][1] += dp[near][0];
      }
    }
    dp[now][1] += costs[now];
  }

}
