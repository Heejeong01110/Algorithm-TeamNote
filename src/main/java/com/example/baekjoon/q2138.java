package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q2138 {

  private static int N;
  private static StringBuilder origin, origin1, target;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    output(Solution());
  }

  private static void output(int result) {
    System.out.print(result);
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    origin = new StringBuilder(br.readLine());
    target = new StringBuilder(br.readLine());
    origin1 = new StringBuilder(origin);
    br.close();
  }

  private static int Solution() {
    int cnt = 1, cnt1 = 0;
    origin.setCharAt(0, origin.charAt(0) == '1' ? '0' : '1');
    origin.setCharAt(1, origin.charAt(1) == '1' ? '0' : '1');
    for (int i = 1; i < N; i++) {

      //1. 첫번째 스위치를 킨 경우
      if (origin.charAt(i - 1) != target.charAt(i - 1)) {
        if (i == N - 1) {
          origin.setCharAt(i - 1, origin.charAt(i - 1) == '1' ? '0' : '1');
          origin.setCharAt(i, origin.charAt(i) == '1' ? '0' : '1');
        } else {
          origin.setCharAt(i - 1, origin.charAt(i - 1) == '1' ? '0' : '1');
          origin.setCharAt(i, origin.charAt(i) == '1' ? '0' : '1');
          origin.setCharAt(i + 1, origin.charAt(i + 1) == '1' ? '0' : '1');
        }
        cnt++;
      }

      //2. 안킨 경우
      if (origin1.charAt(i - 1) != target.charAt(i - 1)) {
        if (i == N - 1) {
          origin1.setCharAt(i - 1, origin1.charAt(i - 1) == '1' ? '0' : '1');
          origin1.setCharAt(i, origin1.charAt(i) == '1' ? '0' : '1');
        } else {
          origin1.setCharAt(i - 1, origin1.charAt(i - 1) == '1' ? '0' : '1');
          origin1.setCharAt(i, origin1.charAt(i) == '1' ? '0' : '1');
          origin1.setCharAt(i + 1, origin1.charAt(i + 1) == '1' ? '0' : '1');
        }
        cnt1++;
      }
    }

    if (!origin.toString().equals(target.toString())) {
      cnt = Integer.MAX_VALUE;
    }
    if (!origin1.toString().equals(target.toString())) {
      cnt1 = Integer.MAX_VALUE;
    }
    int answer = Math.min(cnt, cnt1);
    if (answer == Integer.MAX_VALUE) {
      return -1;
    }

    return answer;
  }

}
