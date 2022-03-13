package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class q20551 {

  private static int N;
  private static int M;
  private static int[] sortA;
  private static int[] D;
  private static StringBuilder sb;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    Solution();
    output();
  }

  private static void output() {
    System.out.print(sb.toString());
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    sortA = new int[N];
    D = new int[M];

    for (int i = 0; i < N; i++) {
      int item = Integer.parseInt(br.readLine());
      sortA[i] = item;
    }

    for (int i = 0; i < M; i++) {
      D[i] = Integer.parseInt(br.readLine());
    }

    br.close();
  }

  private static StringBuilder Solution() {
    sb = new StringBuilder();
    Arrays.sort(sortA);

    HashMap<Integer, Integer> aMap = new HashMap<>();

    for (int i = 0; i < N; i++) {
      aMap.put(sortA[i], Math.min(aMap.getOrDefault(sortA[i], Integer.MAX_VALUE), i));
    }

    for (int i = 0; i < M; i++) {
      sb.append(aMap.getOrDefault(D[i], -1) + "\n");
    }

    return sb;
  }

}
