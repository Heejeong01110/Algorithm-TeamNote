package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q13397 {

  private static int N;
  private static int M;
  private static int[] nums;
  private static int answer;

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
    nums = new int[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      nums[i] = Integer.parseInt(st.nextToken());
    }

    br.close();
  }

  private static int Solution() {
    answer = Integer.MAX_VALUE;
    int mid;
    int left = 0;
    int right = Arrays.stream(nums).max().getAsInt();
    while (right >= left) {
      mid = (right + left) / 2;
      if (cal(mid)) {
        answer = Math.min(answer, mid);
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }

    return answer;
  }

  private static boolean cal(int mid) {
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    int cnt = 1;

    for (int i = 0; i < N; i++) {
      max = Math.max(max, nums[i]);
      min = Math.min(min, nums[i]);

      if (max - min > mid) {
        min = nums[i];
        max = nums[i];
        cnt++;
      }
    }
    return cnt<=M;
  }
}
