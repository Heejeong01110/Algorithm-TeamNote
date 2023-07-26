package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class q3687 {

  private static final int[] matches = new int[]{6, 2, 5, 5, 4, 5, 6, 3, 7, 6};
  private static HashMap<Integer, ArrayList<Integer>> map;


  /*
  2 : 1
  3 : 7
  4 : 4
  5 : 2 3 5
  6 : 0 6 9
  7 : 8
  */


  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    map = new HashMap<>();
    for (int i = 0; i < 10; i++) {
      ArrayList<Integer> ary = map.getOrDefault(matches[i], new ArrayList<>());
      ary.add(i);
      map.put(matches[i], ary);
    }

    long[] dp = new long[101];
    Arrays.fill(dp, Long.MAX_VALUE);
    dp[2] = 1;
    dp[3] = 7;
    dp[4] = 4;
    dp[5] = 2;
    dp[6] = 6;
    dp[7] = 8;
    dp[8] = 10;
    String[] arr = new String[]{"1", "7", "4", "2", "0", "8"};

    for (int i = 9; i <= 100; i++) {
      for (int j = 2; j <= 7; j++) {
        String line = dp[i - j] + arr[j - 2];
        dp[i] = Math.min(Long.parseLong(line), dp[i]);
      }
    }

    int T = Integer.parseInt(br.readLine());
    for (int t = 0; t < T; t++) {
      int N = Integer.parseInt(br.readLine());
      long min = dp[N];
      String max = getMax(N);

      System.out.println(min + " " + max);
    }

    br.close();
  }

  private static String getMax(int num) {
    String max = "";
    int s = num / 2;
    if (num % 2 == 1) {
      max = "7";
    } else {
      max = "1";
    }
    for (int i = 1; i < s; i++) {
      max += 1;
    }
    return max;
  }

}
