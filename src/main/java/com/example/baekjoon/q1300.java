package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//다시 풀어보기
//K번째 수
public class q1300 {

  private static final int max = 1_000_000_000;
  private static int N;
  private static int k;

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

    N = Integer.parseInt(br.readLine());
    k = Integer.parseInt(br.readLine());
    br.close();
  }

  private static long Solution() {
    long mid;
    long left = 1;
    long right = k;

    while (right > left) {
      mid = (right + left) / 2;

      long count = 0;
      for (int i = 1; i <= N; i++) {
        count += Math.min(mid / i, N);
      }

      if (count >= k) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }

    return left;
  }

}
