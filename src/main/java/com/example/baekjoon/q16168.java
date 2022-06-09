package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class q16168 {

  private static int V;
  private static int E;
  private static ArrayList<Integer>[] nodes;
  private static String result;
  private static int[][] circle;

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

    StringTokenizer st = new StringTokenizer(br.readLine());
    V = Integer.parseInt(st.nextToken());
    E = Integer.parseInt(st.nextToken());

    nodes = new ArrayList[V + 1];

    for (int i = 1; i <= V; i++) {
      nodes[i] = new ArrayList<>();
    }

    for (int i = 0; i < E; i++) {
      st = new StringTokenizer(br.readLine());
      int one = Integer.parseInt(st.nextToken());
      int two = Integer.parseInt(st.nextToken());

      nodes[one].add(two);
      nodes[two].add(one);
    }

    br.close();
  }

  private static String Solution() {
    result = "NO";
    circle = new int[V + 1][V + 1];

    for (int i = 1; i <= V; i++) {
      dfs(0, i, i);
      if (result.equals("YES")) {
        break;
      }
    }
    return result;
  }

  private static void dfs(int depth, int now, int num) {
    if (depth == E) {
      result = "YES";
      return;
    }

    for (int i = 0; i < nodes[now].size(); i++) {
      int next = nodes[now].get(i);

      if (circle[now][next] == num || circle[next][now] == num) {
        continue;
      }

      circle[now][next] = num;
      circle[next][now] = num;
      dfs(depth + 1, next, num);
    }

  }

}
