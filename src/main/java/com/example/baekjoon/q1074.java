package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1074 {
  
  private static int N, r, c;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    System.out.print(Solution());
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    r = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());
    br.close();
  }

  private static long Solution() {
    return dfs(N, r, c);
  }

  private static int dfs(int n, int r, int c) {
    if (n == 0) {
      return 0;
    }

    int middle = 1 << (n - 1);
    int size = middle * middle;

    if (r < middle && c < middle) {
      return dfs(n - 1, r, c);  // 1사분면
    } else if (r < middle && c >= middle) {
      return size + dfs(n - 1, r, c - middle); // 2사분면
    } else if (r >= middle && c < middle) {
      return size * 2 + dfs(n - 1, r - middle, c); // 3사분면
    }
    return size * 3 + dfs(n - 1, r - middle, c - middle); // 4사분면
  }

}
