package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q13458 {

  private static int N;
  private static int B;
  private static int C;
  private static int[] A;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    output(Solution());
  }

  private static void output(long result) {
    System.out.print(result);
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st;
    N = Integer.parseInt(br.readLine());
    A = new int[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());
    B = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    br.close();
  }

  private static long Solution() {

    long answer = 0;
    for (int i = 0; i < N; i++) {
      answer += 1;
      if (A[i] > B) {
        int num = A[i] - B;
        answer += (num / C) + (num % C == 0 ? 0 : 1);
      }
    }

    return answer;
  }

}
