package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q9466 {

  private static int[] students;
  private static boolean[] visited;
  private static boolean[] finished;
  private static int cnt;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());
    for (int t = 0; t < T; t++) {
      int n = Integer.parseInt(br.readLine());
      st = new StringTokenizer(br.readLine());

      students = new int[n + 1];
      visited = new boolean[n + 1];
      finished = new boolean[n + 1];
      for (int i = 1; i <= n; i++) {
        students[i] = Integer.parseInt(st.nextToken());
      }

      cnt = n;
      for (int i = 1; i <= n; i++) {
        if (!visited[i]) {
          dfs(i);
        }
      }

      sb.append(cnt).append("\n");
    }

    br.close();
    System.out.print(sb.toString());
  }

  private static void dfs(int idx) {
    visited[idx] = true;

    int next = students[idx];
    if (!visited[next]) {
      dfs(next);
    } else {//팀 구성 완료
      if (!finished[next]) {
        cnt -= 1;
        while (next != idx) {
          next = students[next];
          cnt -= 1;
        }
      }
    }
    finished[idx] = true;
  }

}
