package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q1943 {

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    String str = br.readLine();

    while (str != null) {
      int N = Integer.parseInt(str);
      Coin[] coins = new Coin[N];
      int totalPrices = 0;

      for (int i = 0; i < N; i++) {
        st = new StringTokenizer(br.readLine());
        int one = Integer.parseInt(st.nextToken());
        int two = Integer.parseInt(st.nextToken());
        coins[i] = new Coin(one, two);
        for (int j = 0; j < two; j++) {
          totalPrices += one;
        }
      }

      if (totalPrices % 2 == 1) {
        sb.append("0\n");
        str = br.readLine();
        continue;
      }

      totalPrices /= 2;
      Arrays.sort(coins, (o1, o2) -> o2.price - o1.price);

      boolean[][] dp = new boolean[N + 1][100001];

      dp[0][0] = true;

      for (int i = 1; i <= N; i++) {
        int count = coins[i - 1].count;
        int price = coins[i - 1].price;

        for (int j = 0; j <= totalPrices; j++) {

          if (dp[i - 1][j]) {

            for (int k = 0; k <= count; k++) {

              if (j + price * k > totalPrices) {
                break;
              }

              dp[i][j + price * k] = true;
            }
          }
        }
      }

      sb.append(dp[N][totalPrices] ? "1\n" : "0\n");
      str = br.readLine();
    }

    System.out.print(sb);

    br.close();
  }


  private static class Coin {

    int price;
    int count;

    public Coin(int price, int count) {
      this.price = price;
      this.count = count;
    }
  }

}
