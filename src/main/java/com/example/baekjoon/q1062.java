package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1062 {

  private static int N;
  private static int K;
  private static String[] ary;
  private static int result;

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

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    ary = new String[N];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      ary[i] = st.nextToken();
    }

    br.close();
  }

  private static int Solution() {

    if (K < 5) {
      return 0;
    } else if (K == 26) {
      return N;
    }

    boolean[] visited = new boolean[26];
    visited['a' - 'a'] = true;
    visited['n' - 'a'] = true;
    visited['t' - 'a'] = true;
    visited['i' - 'a'] = true;
    visited['c' - 'a'] = true;

    for (int i = 0; i < N; i++) {
      ary[i].replace("anta", "");
      ary[i].replace("tica", "");
    }

    combination(visited, 0, 5, K);

    return result;
  }

  private static void combination(boolean[] visited, int start, int depth, int r) {
    if (depth == r) {
      int count = 0;
      for (int i = 0; i < N; i++) {
        boolean isRead = true;
        for (int j = 0; j < ary[i].length(); j++) {
          if (!visited[ary[i].charAt(j) - 'a']) {
            isRead = false;
            break;
          }
        }
        if (isRead)
          count++;
      }
      result = Math.max(result, count);
      return;
    }

    for (int i = start; i < 26; i++) {
      if (!visited[i]) {
        visited[i] = true;
        combination(visited, i + 1, depth + 1, r);
        visited[i] = false;
      }
    }
  }
}
