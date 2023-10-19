package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q2293 {

  private static int N, K;
  private static int[] inp;

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
    K = Integer.parseInt(st.nextToken());
    inp = new int[N];

    for (int i = 0; i < N; i++) {
      inp[i] = Integer.parseInt(br.readLine());
    }

    br.close();
  }

  private static int Solution() {
    int[] dp = new int[K + 1];
    Arrays.sort(inp);

    for (int i = 0; i < N; i++) {
      for (int j = 1; j <= K; j++) {
        if (j - inp[i] > 0) {
          dp[j] += dp[j - inp[i]];
        } else if (j - inp[i] == 0) {
          dp[j] += 1;
        }
      }
    }

    return dp[K];
  }
}
