package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class q15666 {

  private static int N;
  private static int M;
  private static int[] ary;
  private static Set<String> set;
  private static StringBuilder sb;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    Solution();
  }

  private static void output(int result) {
    System.out.print(result);
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    ary = new int[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      ary[i] = Integer.parseInt(st.nextToken());
    }

    br.close();
  }

  private static void Solution() {
    set = new HashSet<>();
    sb = new StringBuilder();

    Arrays.sort(ary);
    comb("", 0, 0);

    return;
  }

  // 서로 다른 n개에서 순서 없이, 중복이 가능하게 r개를 뽑는 경우의 수
  private static void comb(String out, int start, int depth) {
    if (depth == M) {
      if (!set.contains(out)) {
        set.add(out);
        System.out.println(out);
      }
      return;
    }

    for (int i = start; i < ary.length; i++) {
      comb(out + ary[i] + " ", i, depth + 1);
    }
  }
}
