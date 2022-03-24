package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q17610 {

  private static int N;
  private static int allGram;
  private static int[] nums;
  private static boolean[] checkList;

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

    N = Integer.parseInt(br.readLine());
    nums = new int[N * 2];
    allGram = 0;

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N * 2; i += 2) {
      nums[i] = Integer.parseInt(st.nextToken());
      nums[i + 1] = -nums[i];
      allGram += nums[i];
    }

    br.close();
  }

  private static int Solution() {
    checkList = new boolean[allGram + 1];

    dfs(0, 0);

    Integer result = 0;
    for (int i = 1; i < allGram + 1; i++) {
      if (!checkList[i]) {
        result += 1;
      }
    }
    return result;
  }

  private static void dfs(int allSum, int start) {
    if (allSum >= 1 && allSum <= allGram) {
      checkList[allSum] = true;
    }

    if (start >= N * 2) {
      return;
    }


    dfs(allSum + nums[start], start + 1);
    dfs(allSum, start + 1);

  }

}
