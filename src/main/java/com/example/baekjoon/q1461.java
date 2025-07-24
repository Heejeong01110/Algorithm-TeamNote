package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class q1461 {

  private static int N, M;
  private static int[] inp;

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
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    inp = new int[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      inp[i] = Integer.parseInt(st.nextToken());
    }

    br.close();
  }

  private static int Solution() {
    PriorityQueue<Integer> plus = new PriorityQueue<>((p1, p2) -> p2 - p1);
    PriorityQueue<Integer> minus = new PriorityQueue<>((p1, p2) -> p2 - p1);

    for (int i = 0; i < N; i++) {
      if (inp[i] > 0) {
        plus.add(inp[i]);
      } else {
        minus.add((-1) * inp[i]);
      }
    }

    int max = 0;
    if (plus.isEmpty()) {
      max = minus.peek();
    } else if (minus.isEmpty()) {
      max = plus.peek();
    } else {
      max = Math.max(plus.peek(), minus.peek());
    }

    int ans = 0;
    while (!plus.isEmpty()) {
      int tmp = plus.poll();
      for (int i = 0; i < M - 1; i++) {
        plus.poll();
        if (plus.isEmpty()) {
          break;
        }
      }
      ans += tmp * 2;
    }

    while (!minus.isEmpty()) {
      int tmp = minus.poll();
      for (int i = 0; i < M - 1; i++) {
        minus.poll();
        if (minus.isEmpty()) {
          break;
        }
      }
      ans += tmp * 2;
    }

    return ans - max;
  }

}
