package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class q2179 {

  private static int N;
  private static String[] inp;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    Solution();
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    inp = new String[N];

    for (int i = 0; i < N; i++) {
      inp[i] = br.readLine();
    }

    br.close();
  }

  private static int Solution() {
    int idx1 = 0;
    int idx2 = 0;
    int max = 0;

    for (int i = 0; i < N - 1; i++) {
      for (int j = i + 1; j < N; j++) {
        int len = getLen(inp[i], inp[j]);
        if (len > max) {
          idx1 = i;
          idx2 = j;
          max = len;
        }
      }
    }

    System.out.print(inp[idx1] + "\n" + inp[idx2]);

    return 0;
  }

  private static int getLen(String s1, String s2) {
    int size = Math.min(s1.length(), s2.length());
    int cnt = 0;
    for (int i = 0; i < size; i++) {
      if (s1.charAt(i) != s2.charAt(i)) {
        return cnt;
      }
      cnt++;
    }
    return cnt;
  }
}
