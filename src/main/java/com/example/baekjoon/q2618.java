package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q2618 {

  private static int[][] event, dp;
  private static int N, W;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    Solution();
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine()); // 맵 크기
    W = Integer.parseInt(br.readLine()); // 사건 수

    event = new int[1001][2];
    dp = new int[1001][1001];

    for (int i = 1; i <= W; i++) {
      st = new StringTokenizer(br.readLine());

      event[i][0] = Integer.parseInt(st.nextToken());
      event[i][1] = Integer.parseInt(st.nextToken());
    }

    br.close();
  }

  private static void Solution() {

    System.out.println(dfs(1, 0, 0));

    int one = 0;
    int two = 0;
    for (int i = 1; i <= W; i++) {
      int dist = getDistance(1, one, i);

      if (dp[one][two] - dist == dp[i][two]) {
        one = i;
        System.out.println(1);
      } else {
        two = i;
        System.out.println(2);
      }
    }
  }


  public static int dfs(int e, int one, int two) {

    // 모든 사건을 이동했을 경우
    if (e > W) {
      return 0;
    }

    // 이미 값이 존재할 경우
    if (dp[one][two] != 0) {
      return dp[one][two];
    }

    int fir = dfs(e + 1, e, two) + getDistance(1, one, e); // 경찰차 A가 이동했을 경우
    int sec = dfs(e + 1, one, e) + getDistance(2, two, e); // 경찰차 B가 이동했을 경우

    return dp[one][two] = Math.min(fir, sec);
  }

  public static int getDistance(int type, int start, int end) {
    int[] st = event[start];
    int[] ed = event[end];

    // 초기 경찰차 위치 설정
    if (start == 0) {
      if (type == 1) {
        st = new int[]{1, 1};
      } else {
        st = new int[]{N, N};
      }
    }

    return Math.abs(st[0] - ed[0]) + Math.abs(st[1] - ed[1]);
  }
}
