package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q11568 {

  private static int N;
  private static int[] cards;

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
    cards = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      cards[i] = Integer.parseInt(st.nextToken());
    }

    br.close();
  }

  private static int Solution() {
    Integer answer = 1;

    int[] dp = new int[N];
    dp[0] = 1;

    for (int i = 1; i < N; i++) {
      dp[i] = 1;

      for (int j = 0; j < i; j++) {
        if (cards[i] > cards[j] && dp[i] <= dp[j]) {
          dp[i] = dp[j] + 1;
        }
      }

      answer = Math.max(answer, dp[i]);
    }

    return answer;
  }


}
