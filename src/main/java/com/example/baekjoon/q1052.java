package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class q1052 {

  private static int N, L;
  private static int[][] inp;

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
    L = Integer.parseInt(st.nextToken());
    inp = new int[N][2];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      inp[i][0] = Integer.parseInt(st.nextToken());
      inp[i][1] = Integer.parseInt(st.nextToken());
    }

    br.close();
  }

  private static int Solution() {
    Arrays.sort(inp, Comparator.comparingInt(o -> o[0]));

    int cover = 0;
    int cnt = 0;
    for (int i = 0; i < inp.length; i++) {
      if (inp[i][1] <= cover) {
        continue;
      }
      int s = Math.max(cover, inp[i][0]);
      int n = ((inp[i][1] - s) / L) + ((inp[i][1] - s) % L == 0 ? 0 : 1);
      cnt += n;
      cover = s + L * n;
    }

    return cnt;
  }

}
