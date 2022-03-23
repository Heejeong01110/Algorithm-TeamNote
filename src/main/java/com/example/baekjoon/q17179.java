package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q17179 {

  private static int N;
  private static int M;
  private static int L;

  private static int[] input;
  private static int[] cut;
  private static int[] result;
  private static StringBuilder sb;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    output(Solution());
  }

  private static void output(String result) {
    System.out.print(result);
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    L = Integer.parseInt(st.nextToken());

    input = new int[M + 2];
    cut = new int[N];

    input[0] = 0;
    for (int i = 1; i <= M; i++) {
      input[i] = Integer.parseInt(br.readLine());
    }
    input[M + 1] = L;

    for (int i = 0; i < N; i++) {
      cut[i] = Integer.parseInt(br.readLine());
    }

    br.close();
  }

  private static String Solution() {
    sb = new StringBuilder();
    result = new int[N];

    for (int t = 0; t < N; t++) {
      int left = 0;
      int right = L;
      int answer = 0;

      while (left <= right) {
        int mid = (left + right) / 2;
        int prev = input[0];
        int numOfCut = 0;
        for (int i = 1; i <= M + 1; i++) {
          if (input[i] - prev >= mid) {
            numOfCut++;
            prev = input[i];
          }
        }

        if (numOfCut > cut[t]) {
          left = mid + 1;
          answer = Math.max(answer, mid);
        } else {
          right = mid - 1;
        }

      }

      result[t] = answer;
      sb.append(result[t]).append("\n");
    }
    return sb.toString();
  }

}
