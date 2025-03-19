package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q2110 {

  private static int N, C;
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
    C = Integer.parseInt(st.nextToken());
    inp = new int[N];

    for (int i = 0; i < N; i++) {
      inp[i] = Integer.parseInt(br.readLine());
    }

    br.close();
  }

  private static int Solution() {
    Arrays.sort(inp);
    int res = 0;
    int start = 0;
    int end = 1_000_000_000;
    int mid = (start + end) / 2;

    while (start <= end) {
      mid = (start + end) / 2;

      if (sol(mid)) {
        start = mid + 1;
        res = mid;
      } else {
        end = mid - 1;
      }
    }

    return res;
  }

  private static boolean sol(int n) {
    int tmp = inp[0];
    int cnt = 1;
    for (int i = 1; i < N; i++) {
      if (inp[i] - tmp >= n) {
        cnt++;
        tmp = inp[i];
        if (cnt >= C) {
          return true;
        }
      }
    }
    return false;
  }
}
