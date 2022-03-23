package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q21943 {

  private static int N;
  private static int plus;
  private static int dup;
  private static Integer[] X;

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
    X = new Integer[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      X[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());
    plus = Integer.parseInt(st.nextToken());
    dup = Integer.parseInt(st.nextToken());

    br.close();
  }

  private static int Solution() {
    Integer result = 0;
    result = dfs(new int[dup + 1], 0);

    return result;
  }

  private static int dfs(int[] rounds, int depth) {
    if (depth == N) {
      int ans = 1;
      for (int i = 0; i <= dup; ++i) {
        ans *= rounds[i];
      }
      return ans;
    }

    int ans = 0;
    for (int i = 0; i <= dup; i++) {
      rounds[i] += X[depth];
      ans = Math.max(ans, dfs(rounds, depth + 1));
      rounds[i] -= X[depth];
    }
    return ans;
  }

}
