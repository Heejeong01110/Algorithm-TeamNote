package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class q1038 {

  private static int N;
  private static long[] memo;
  private static ArrayList<Long> list;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    System.out.print(Solution());
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    memo = new long[1024];
    br.close();
  }

  private static long Solution() {
    list = new ArrayList<>();

    if (N <= 10) {
      return N;
    } else if (N > 1022) {
      return -1;
    } else {
      for (int i = 0; i < 10; i++) {
        dfs(i, 1);
      }
      Collections.sort(list);
      return list.get(N);
    }
  }

  public static void dfs(long num, int idx) {
    if (idx > 10) {
      return;
    }

    list.add(num);
    for (int i = 0; i < num % 10; i++) {
      dfs((num * 10) + i, idx + 1);
    }
  }
}
