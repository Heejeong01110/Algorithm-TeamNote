package com.example.algorithm.sortAndSearch;

public class TwoPointer {

  public static void main(String[] args) {
    int N = 8;
    int M = 10;
    int[] A = {1, 3, 4, 6, 7, 2, 5, 8};

    Integer answer = 0;
    Integer start = 0;
    Integer end = 0;
    Integer sum = 0;

    //부분 수열 중 합이 10인 갯수(길이가 가변적) --> 슬라이딩 윈도우 : 길이가 고정적
    while (end <= N) {
      if (sum < M) {
        if (end >= N) {
          break;
        }
        sum += A[end];
        end++;
      } else {
        if (sum == M) {
          answer++;
        }
        sum -= A[start];
        start += 1;
      }
    }
  }
}
