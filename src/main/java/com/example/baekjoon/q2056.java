package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q2056 {

  private static int N;
  private static int[] time;
  private static int[] degree;
  private static ArrayList<Integer>[] list;

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

    N = Integer.parseInt(br.readLine());
    time = new int[N + 1];
    degree = new int[N + 1];
    list = new ArrayList[N + 1];
    for (int i = 1; i <= N; i++) {
      list[i] = new ArrayList<>();
    }

    StringTokenizer st;
    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      int t = Integer.parseInt(st.nextToken());
      time[i] = t;

      int count = Integer.parseInt(st.nextToken());
      for (int j = 0; j < count; j++) {
        int connect = Integer.parseInt(st.nextToken());
        list[connect].add(i);
        degree[i]++;
      }
    }

    br.close();
  }

  private static int Solution() {

    Queue<Integer> queue = new ArrayDeque<>();
    int[] dp = new int[N + 1];
    for (int i = 1; i <= N; i++) {
      if (degree[i] == 0) {
        queue.add(i);
        dp[i] = time[i];
      }
    }

    while (!queue.isEmpty()) {
      int now = queue.poll();

      for (int next : list[now]) {
        degree[next]--;
        dp[next] = Math.max(dp[next], dp[now]);

        if (degree[next] == 0) {
          queue.add(next);
          dp[next] += time[next];
        }
      }
    }

    int answer = 0;
    for (int i = 1; i <= N; i++) {
      answer = Math.max(answer, dp[i]);
    }

    return answer;
  }

}
