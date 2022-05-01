package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1561 {

  private static int N;
  private static int M;
  private static int[] nums;

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
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    nums = new int[M + 1];

    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= M; i++) {
      nums[i] = Integer.parseInt(st.nextToken());
    }

    br.close();
  }

  private static int Solution() {

    if (N < M) {
      return N;
    }

    if (M == 1) {
      return M;
    }

    long start = 1;
    long end = nums[1] * Long.parseLong(String.valueOf(N));
    long mid = 0;

    while (start <= end) {
      mid = (start + end) / 2;
      if (playChildrenNumber(mid) < N) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }

    //1. mid 1초 전까지 완료한 인원 수 구하기
    //2. mid 초에 시작하는 기구 중 N번인 거 구하기

    //1.
    mid = start;
    long prevCount = playChildrenNumber(mid - 1);

    for (int i = 1; i <= M; i++) {
      if ((mid - 1) % nums[i] == 0) {
        prevCount++;
      }

      if (prevCount == N) {
        return i;
      }
    }

    return -1;
  }

  private static long playChildrenNumber(long time) {
    long sum = 0;
    for (int i = 1; i <= M; i++) {
      sum += time / nums[i] + (time % nums[i] == 0 ? 0 : 1);
    }
    return sum;
  }


}
