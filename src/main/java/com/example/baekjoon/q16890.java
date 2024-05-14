package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class q16890 {

  private static char[] inpA, inpB;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    Solution();
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    inpA = br.readLine().toCharArray();
    inpB = br.readLine().toCharArray();

    br.close();
  }

  private static void Solution() {

    Deque<Character> A = new ArrayDeque<>();
    Deque<Character> B = new ArrayDeque<>();
    int N = inpA.length;

    Arrays.sort(inpA);
    Arrays.sort(inpB);

    for (int i = 0; i < N; i++) {
      A.add(inpA[i]);
      B.add(inpB[N - 1 - i]);
    }

    for (int i = 0; i < (N + 1) / 2; i++) {
      A.addLast(inpA[i]);
    }

    for (int i = 0; i < N / 2; i++) {
      B.addLast(inpA[N - 1 - i]);
    }

    String front = "";
    String back = "";

    for (int i = 0; i < N; i++) {
      if (i % 2 == 0) { //구사과
        if (B.isEmpty() || A.peekFirst() < B.peekFirst()) {
          front += A.pollFirst();
        } else {
          back += A.pollLast();
        }
      } else { //큐브러버
        if (A.isEmpty() || A.peekFirst() < B.peekFirst()) {
          front += B.pollFirst();
        } else {
          back += B.pollLast();
        }
      }
    }

    System.out.printf(front);
    for (int i = back.length(); i > 0; i--) {
      System.out.printf(back.substring(i - 1, i));
    }
  }

}
