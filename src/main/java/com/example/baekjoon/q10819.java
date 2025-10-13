package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q10819 {

  private static int N, arr[], cal[];
  private static int result = 0;
  private static boolean visit[];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    arr = new int[N];
    cal = new int[N];
    visit = new boolean[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    back(0);
    System.out.println(result);
  }

  private static void back(int depth) {
    if (depth == N) {
      int sum = 0;
      for (int i = 0; i < N - 1; i++) {
        sum += Math.abs(cal[i] - cal[i + 1]);
      }
      result = Math.max(result, sum);
      return;
    }

    for (int i = 0; i < N; i++) {
      if (!visit[i]) {
        visit[i] = true;
        cal[depth] = arr[i];
        back(depth + 1);
        visit[i] = false;
      }
    }
  }
}
