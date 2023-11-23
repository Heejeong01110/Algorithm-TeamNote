package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class q2668 {

  private static int N, M;
  private static int[] inp;
  private static boolean result;
  private static ArrayList<Integer> resList;
  private static boolean[] visited;


  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    Solution();
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    inp = new int[N + 1];

    for (int i = 1; i <= N; i++) {
      inp[i] = Integer.parseInt(br.readLine());
    }

    br.close();
  }

  private static void Solution() {
    resList = new ArrayList<>();
    visited = new boolean[N + 1];
    for (int i = 1; i <= N; i++) {
      visited[i] = true;
      dfs(i, i);
      visited[i] = false;
    }

    resList.sort(Comparator.naturalOrder());
    System.out.println(resList.size());
    for (int i = 0; i < resList.size(); i++) {
      System.out.println(resList.get(i));

    }
  }

  private static void dfs(int start, int target) {
    if (!visited[inp[start]]) {
      visited[inp[start]] = true;
      dfs(inp[start], target);
      visited[inp[start]] = false;
    }
    if (inp[start] == target) {
      resList.add(target);
    }
  }

}
