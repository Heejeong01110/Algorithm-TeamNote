package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class q1208 {

  private static int N, S;
  private static long cnt;
  private static int[] inp;
  private static HashMap<Integer, Integer> map;

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
    S = Integer.parseInt(st.nextToken());
    inp = new int[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      inp[i] = Integer.parseInt(st.nextToken());
    }

    br.close();
  }

  private static long Solution() {
    Arrays.sort(inp);
    map = new HashMap<>();

    leftSum(0, 0);
    rightSum(N / 2, 0);

    if (S == 0) {
      return cnt - 1;
    }
    return cnt;
  }

  private static void leftSum(int now, int sum) {
    if (now == N / 2) {
      map.put(sum, map.getOrDefault(sum, 0) + 1);
      return;
    }
    leftSum(now + 1, sum);
    leftSum(now + 1, sum + inp[now]);

  }

  private static void rightSum(int now, int sum) {
    if (now == N) {
      cnt += map.getOrDefault(S - sum, 0);
      return;
    }
    rightSum(now + 1, sum);
    rightSum(now + 1, sum + inp[now]);
  }
}
