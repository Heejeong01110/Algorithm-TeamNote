package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q1253 {

  private static int N, M;
  private static long[] inp;

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
    inp = new long[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      inp[i] = Long.parseLong(st.nextToken());
    }

    br.close();
  }

  private static int Solution() {
    int ans = 0;
    Arrays.sort(inp);
    int start, end;
    for (int i = 0; i < N; i++) {
      start = 0;
      end = N - 1;

      while (true) {
        if (start == i) {
          start++;
        } else if (end == i) {
          end--;
        }

        if (start >= end) {
          break;
        }

        if (inp[start] + inp[end] > inp[i]) {
          end--;
        } else if (inp[start] + inp[end] < inp[i]) {
          start++;
        } else {
          ans++;
          break;
        }
      }
    }

    return ans;
  }
}
