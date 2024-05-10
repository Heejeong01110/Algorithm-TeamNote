package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class q16890 {

  private static char[] A, B;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    Solution();
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    A = br.readLine().toCharArray();
    B = br.readLine().toCharArray();

    br.close();
  }

  private static void Solution() {

    Deque<Character> listA = new ArrayDeque<>();
    Deque<Character> listB = new ArrayDeque<>();
    int N = A.length;

    Arrays.sort(A);
    Arrays.sort(B);

    for (int i = 0; i < N; i++) {
      listA.add(A[i]);
      listB.add(B[i]);
    }

    Character[] ans = new Character[N];
    int startIdx = 0;
    int lastIdx = N - 1;
    for (int i = 0; i < N; i++) {
      if (lastIdx < startIdx) {
        break;
      }
      if (i % 2 == 0) {
        //listA
        if (listA.peekFirst().compareTo(listB.peekLast()) <= 0 || startIdx == lastIdx) {
          ans[startIdx++] = listA.pollFirst();
        } else {
          ans[lastIdx--] = listA.pollLast();
        }
      } else {
        //listB
        if (listB.peekLast().compareTo(listA.peekFirst()) >= 0 || startIdx == lastIdx) {
          ans[startIdx++] = listB.pollLast();
        } else {
          ans[lastIdx--] = listB.pollFirst();
        }
      }
    }

    for (int i = 0; i < N; i++) {
      System.out.printf(String.valueOf(ans[i]));
    }
    return;
  }

}
