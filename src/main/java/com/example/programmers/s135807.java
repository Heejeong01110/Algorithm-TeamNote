package com.example.programmers;

import java.util.Arrays;

public class s135807 {

  public int solution(int[] arrayA, int[] arrayB) {
    int answer = 0;

    //1. 최대공약수 구하기
    int gcdA = arrayA[0];
    int gcdB = arrayB[0];
    for (int i = 1; i < arrayA.length; i++) {
      gcdA = gcd(gcdA, arrayA[i]);
      gcdB = gcd(gcdB, arrayB[i]);
    }

    if (isPossible(arrayB, gcdA)) {
      answer = gcdA;
    }
    if (isPossible(arrayA, gcdB)) {
      answer = Math.max(answer, gcdB);
    }

    return answer;
  }

  private boolean isPossible(int[] array, int num) {
    for (int i = 0; i < array.length; i++) {
      if (array[i] % num == 0) {
        return false;
      }
    }
    return true;
  }

  public int gcd(int a, int b) {
    if (a % b == 0) {
      return b;
    }
    return gcd(b, a % b);
  }

}
