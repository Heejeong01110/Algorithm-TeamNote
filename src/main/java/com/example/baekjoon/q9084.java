package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class q9084 {

  private static int T;
  private static ArrayList<int[]> Coins;
  private static int[] TargetPrices;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < T; i++) {
      sb.append(Solution(Coins.get(i), TargetPrices[i])).append("\n");
    }
    output(sb);
  }

  private static void output(StringBuilder result) {
    System.out.print(result.toString());
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    T = Integer.parseInt(br.readLine());
    Coins = new ArrayList<>();
    TargetPrices = new int[T];

    for (int i = 0; i < T; i++) {
      int count = Integer.parseInt(br.readLine());
      Coins.add(new int[count]);
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < count; j++) {
        Coins.get(i)[j] = Integer.parseInt(st.nextToken());
      }
      TargetPrices[i] = Integer.parseInt(br.readLine());
    }

    br.close();
  }

  private static Integer Solution(int[] coins, int targetPrice) {
    int[] dp = new int[targetPrice + 1];

    dp[0] = 1;

    for (int i = 0; i < coins.length; i++) {
      for (int j = coins[i]; j <= targetPrice; j++) {
        dp[j] += dp[j - coins[i]];
      }
    }

    return dp[targetPrice];
  }

}
