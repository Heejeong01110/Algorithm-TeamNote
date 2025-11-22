package com.example.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class q1512 {

  private static int[] d;
  private static int N;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    d = new int[N];
    int count = 0;

    for (int i = 0; i < N; i++) {
      d[i] = sc.nextInt();
    }

    int M = sc.nextInt();
    Arrays.sort(d);

    int mid = 0;
    int start = 0;
    int end = d[N - 1];
    int answer = 0;

    while (start <= end) {
      mid = (start + end) / 2;
      answer = calc(mid);
      if (answer < M) {
        start = mid + 1;
      } else if (answer > M) {
        end = mid - 1;
      } else {
        break;
      }

    }
    if (answer > M) {
      mid--;
    }
    System.out.println(mid);

  }

  private static int calc(int num) {
    int sum = 0;
    for (int i = 0; i < N; i++) {
      if (d[i] <= num) {
        sum += d[i];
      } else {
        sum += num * (N - i);
        break;
      }
    }
    return sum;

  }
}
