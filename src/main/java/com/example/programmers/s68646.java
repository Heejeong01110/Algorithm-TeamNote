package com.example.programmers;

public class s68646 {

  public static int solution(int[] a) {
    int size = a.length;
    if (size < 3) {
      return size;
    }

    int[] left = new int[size];
    int[] right = new int[size];

    left[0] = a[0];
    for (int i = 1; i < size; i++) {
      left[i] = Math.min(left[i - 1], a[i]);
    }

    right[size - 1] = a[size - 1];
    for (int i = size - 2; i >= 0; i--) {
      right[i] = Math.min(right[i + 1], a[i]);
    }

    int answer = 2;

    for (int i = 1; i < size - 1; i++) {
      if (left[i - 1] > a[i] || right[i + 1] > a[i]) {
        answer++;
      }
    }

    return answer;
  }
}
