package com.example.programmers;

import java.util.ArrayDeque;
import java.util.Deque;

public class s118670 {

  private static int N, M;
  private static Deque<Integer> left, right;
  private static Deque<Deque<Integer>> middle;

  public static int[][] solution(int[][] rc, String[] operations) {
    N = rc.length;
    M = rc[0].length;

    left = new ArrayDeque<>();
    right = new ArrayDeque<>();
    middle = new ArrayDeque<>();

    for (int i = 0; i < N; i++) {
      left.addLast(rc[i][0]);
      right.addLast(rc[i][M - 1]);
      Deque<Integer> mid = new ArrayDeque<>();
      for (int j = 1; j < M - 1; j++) {
        mid.addLast(rc[i][j]);
      }
      middle.addLast(mid);
    }

    for (String operation : operations) {
      if (operation.equals("ShiftRow")) {
        middle.addFirst(middle.pollLast());
        left.addFirst(left.pollLast());
        right.addFirst(right.pollLast());
      } else if (operation.equals("Rotate")) {
        middle.getFirst().addFirst(left.pollFirst());
        right.addFirst(middle.getFirst().pollLast());
        middle.getLast().addLast(right.pollLast());
        left.addLast(middle.getLast().pollFirst());
      }
    }

    int[][] answer = new int[N][M];
    for (int i = 0; i < N; i++) {
      answer[i][0] = left.pollFirst();
      answer[i][M - 1] = right.pollFirst();
      Deque<Integer> now = middle.pollFirst();
      for (int j = 1; j < M - 1; j++) {
        answer[i][j] = now.pollFirst();
      }
    }

    return answer;
  }

}
