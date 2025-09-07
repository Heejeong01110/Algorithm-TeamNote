package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1024 {

  private static int N, L;

  public static void main(String[] args) throws IOException {
    inputData();
    Solution();
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    L = Integer.parseInt(st.nextToken());
    br.close();
  }

  private static void Solution() {

    boolean flag = true;
    for (long i = L; i <= 100 && flag; i++) {
      long sum = (i * (i - 1)) / 2;
      long idx = 0;
      while (true) {
        if (sum == N) {
          for (long k = 0; k < i; k++) {
            System.out.print(idx + k + " ");
          }
          flag = false;
          break;
        }

        sum += i;
        idx += 1;
        if (sum > N) {
          break;
        }
      }
    }

    if (flag) {
      System.out.print("-1");
    }
  }

}
