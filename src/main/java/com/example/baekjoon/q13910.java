package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q13910 {

  private static int N;
  private static int M;
  private static int[] wok;

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
    M = Integer.parseInt(st.nextToken());

    wok = new int[M];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < M; i++) {
      wok[i] = Integer.parseInt(st.nextToken());
    }

    br.close();
  }

  private static int Solution() {
    int[] dp = new int[N + 1];

    Arrays.sort(wok);
    ArrayList<Integer> woks = new ArrayList<>();

    for (int i = 0; i < wok.length; i++) {
      woks.add(wok[i]);
      if (wok[i] <= N) {
        dp[wok[i]] = 1;
      }
    }

    for (int i = 0; i < wok.length; i++) {
      for (int j = i + 1; j < wok.length; j++) {
        if (i != j) {
          woks.add(wok[i] + wok[j]);
        }
      }
    }

    for (int i = 1; i <= N; i++) {
      for (int j = 1; j < i; j++) {
        if (dp[j] != 0 && woks.contains(i - j)) {
          dp[i] = dp[i] == 0 ? dp[j] + 1 : Math.min(dp[i], dp[j] + 1);
        }
      }
    }

    return dp[N];
  }

}
