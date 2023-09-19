package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1976 {

  private static int N;
  private static int M;
  private static int[][] inp;
  private static int[] plan;
  private static int[] parents;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    System.out.print(Solution());
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    M = Integer.parseInt(br.readLine());
    inp = new int[N + 1][N + 1];
    plan = new int[M];

    for (int i = 1; i <= N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= N; j++) {
        inp[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < M; i++) {
      plan[i] = Integer.parseInt(st.nextToken());
    }
    br.close();
  }

  private static String Solution() {
    parents = new int[N + 1];
    for (int i = 1; i <= N; i++) {
      parents[i] = i;
    }

    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= N; j++) {
        if (inp[i][j] == 1) {
          union(i, j);
        }
      }
    }

    for (int i = 0; i < M - 1; i++) {
      if (!isSameParent(plan[i], plan[i + 1])) {
        return "NO";
      }
    }

    return "YES";
  }


  private static int find(int num) {
    if (num == parents[num]) {
      return num;
    }
    parents[num] = find(parents[num]);
    return parents[num];
  }

  private static void union(int start, int end) {
    start = find(start);
    end = find(end);
    if (start > end) {
      parents[start] = end;
    } else if (start < end) {
      parents[end] = start;
    }
  }

  private static boolean isSameParent(int start, int end) {
    start = find(start);
    end = find(end);
    if (start == end) {
      return true;
    } else {
      return false;
    }
  }


}
