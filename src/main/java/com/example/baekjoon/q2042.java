package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q2042 {

  private static int N, M, K;
  private static long[] nums, tree;
  private static int[][] commands;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();

    tree = new long[N * 4];
    init(1, N, 1);

    StringBuilder sb = new StringBuilder();
    for (int[] command : commands) {
      int a = command[0];
      int b = command[1];
      long c = command[2];

      if (a == 1) {// [1]인덱스 값을 [2]로 바꾸기
        long dif = c - nums[b];
        nums[b] = c;
        update(1, N, 1, b, dif);
      } else if (a == 2) {
        sb.append(sum(1, N, 1, b, (int) c) + "\n");
      }
    }
    System.out.print(sb.substring(0, sb.length() - 1).toString());
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    nums = new long[N + 1];
    commands = new int[M + K][3];
    for (int i = 1; i <= N; i++) {
      nums[i] = Long.parseLong(br.readLine());
    }

    for (int i = 0; i < M + K; i++) {
      st = new StringTokenizer(br.readLine());
      commands[i][0] = Integer.parseInt(st.nextToken());
      commands[i][1] = Integer.parseInt(st.nextToken());
      commands[i][2] = Integer.parseInt(st.nextToken());
    }

    br.close();
  }

  private static long init(int start, int end, int node) {
    if (start == end) {
      return tree[node] = nums[start];
    }

    int mid = (start + end) / 2;

    // 재귀적으로 두 부분으로 나눈 뒤에 그 합을 자기 자신으로 함.
    return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
  }

  private static long sum(int start, int end, int node, int left, int right) {
    if (left > end || right < start) {
      return 0;
    }

    if (left <= start && end <= right) {
      return tree[node];
    }

    int mid = (start + end) / 2;
    return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
  }

  private static void update(int start, int end, int node, int idx, long dif) {
    if (idx < start || idx > end) {
      return;
    }

    tree[node] += dif;
    if (start == end) {
      return;
    }

    int mid = (start + end) / 2;
    update(start, mid, node * 2, idx, dif);
    update(mid + 1, end, node * 2 + 1, idx, dif);
  }
}
