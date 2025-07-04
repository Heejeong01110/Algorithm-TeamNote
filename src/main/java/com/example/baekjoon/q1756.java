package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1756 {

  private static int N, D;
  private static int[] oven, pizza;
  private static boolean[] visited;

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
    D = Integer.parseInt(st.nextToken()); //오븐의 깊이
    N = Integer.parseInt(st.nextToken()); //피자 반죽의 갯수

    oven = new int[D];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < D; i++) {
      oven[i] = Integer.parseInt(st.nextToken());
    }

    pizza = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      pizza[i] = Integer.parseInt(st.nextToken());
    }

    br.close();
  }

  private static int Solution() {
    visited = new boolean[D];
    int[] minOven = new int[D];
    minOven[0] = oven[0];
    for (int i = 1; i < D; i++) {
      minOven[i] = Math.min(minOven[i - 1], oven[i]);
    }

    int maxDepth = D - 1;
    for (int i = 0; i < N; i++) {
      int start = 0, end = maxDepth, res = -1;
      int mid = (start + end) / 2;

      while (start <= end) {
        mid = (start + end) / 2;

        if (minOven[mid] < pizza[i]) {
          end = mid - 1;
        } else {
          res = mid;
          start = mid + 1;
        }
      }

      if (res == -1) {
        return 0;
      }
      maxDepth = res - 1;
    }

    return maxDepth + 2;
  }

}
