package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class q2143 {

  private static int T, N, M;
  private static int[] A, B;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    System.out.print(Solution());
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st;
    T = Integer.parseInt(br.readLine());
    N = Integer.parseInt(br.readLine());
    A = new int[N + 1];
    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
    }

    M = Integer.parseInt(br.readLine());
    B = new int[M + 1];
    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= M; i++) {
      B[i] = Integer.parseInt(st.nextToken());
    }

    br.close();
  }

  private static long Solution() {
    int[] AList = new int[N + 1];
    int[] BList = new int[M + 1];

    for (int i = 1; i <= N; i++) {
      AList[i] = AList[i - 1] + A[i];
    }

    for (int i = 1; i <= M; i++) {
      BList[i] = BList[i - 1] + B[i];
    }

    HashMap<Integer, Long> aMap = new HashMap<>();
    HashMap<Integer, Long> bMap = new HashMap<>();
    for (int i = 1; i <= N; i++) {
      for (int j = i; j <= N; j++) {
        int sum = AList[j] - AList[i - 1];
        aMap.put(sum, aMap.getOrDefault(sum, 0L) + 1);
      }
    }
    for (int i = 1; i <= M; i++) {
      for (int j = i; j <= M; j++) {
        int sum = BList[j] - BList[i - 1];
        bMap.put(sum, bMap.getOrDefault(sum, 0L) + 1);
      }
    }

    long ans = 0;
    for (Map.Entry<Integer, Long> item : aMap.entrySet()) {
      ans += item.getValue() * bMap.getOrDefault(T - item.getKey(),0L);
    }

    return ans;
  }

}
