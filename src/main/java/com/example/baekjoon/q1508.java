package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1508 {

  private static int N, M, K;
  private static int[] inp;
  private static StringBuilder answer;
  private static int max_interval;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    System.out.print(Solution());
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    inp = new int[K];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < K; i++) {
      inp[i] = Integer.parseInt(st.nextToken());
    }

    br.close();
  }

  private static String Solution() {

    int start = 0;
    int end = N;
    int mid = 0, ans = 0;

    while (start <= end) {
      mid = (start + end) / 2;

      if (calc(mid)) {
        ans = mid;
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }

    int pre = 0;
    int cnt = 1;
    StringBuilder res = new StringBuilder("1");
    for (int i = 1; i < K; i++) {
      if (inp[i] - inp[pre] >= ans && cnt < M) {
        res.append("1");
        cnt++;
        pre = i;
      } else {
        res.append("0");
      }
    }

    return res.toString();
  }

  private static boolean calc(int target) {
    int pre = 0;
    int cnt = 1;
    for (int i = 1; i < K; i++) {
      if (inp[i] - inp[pre] >= target) {
        pre = i;
        cnt++;
      }
    }
    return cnt >= M;
  }

  private static void dfs(int now, int nowItv, int checkNum, StringBuilder dict) {
    if (now == K || checkNum >= 2 && max_interval >= nowItv) {
      return;
    }

    if (checkNum == M) {
      max_interval = nowItv;
      answer.setLength(0);
      answer.append(dict);
      return;
    }

    for (int i = now + 1; i < K; i++) {
      int min = checkNum == 0 ? nowItv : Math.min(nowItv, inp[i] - inp[now]);
      dict.replace(i, i + 1, "1");
      dfs(i, min, checkNum + 1, dict);
      dict.replace(i, i + 1, "0");
    }
  }

}
