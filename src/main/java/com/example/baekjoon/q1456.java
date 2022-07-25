package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class q1456 {

  private static final int MAX = 10_000_000;
  private static long A;
  private static long B;

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

    StringTokenizer st = new StringTokenizer(br.readLine());
    A = Long.parseLong(st.nextToken());
    B = Long.parseLong(st.nextToken());

    br.close();
  }

  private static int Solution() {
    boolean[] prime = new boolean[MAX + 1];
    ArrayList<Double> primeList = new ArrayList<>();

    for (int i = 2; i <= MAX; i++) {
      for (int j = i * 2; j <= MAX; j += i) {
        prime[j] = true;
      }
    }

    for (int i = 2; i < MAX; i++) {
      if (!prime[i]) {
        for (int j = 2; j < MAX; j++) {
          if (Math.pow(i, j) > B) {
            break;
          }
          primeList.add(Math.pow(i, j));
        }
      }
    }

    primeList.sort(Comparator.naturalOrder());
    int left = 0;
    int right = primeList.size() - 1;

    while (left <= right) {
      int mid = (left + right) / 2;
      if (primeList.get(mid) >= A) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }

    }

    return primeList.size() - left;
  }

}
