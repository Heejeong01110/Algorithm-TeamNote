package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class q15665 {

  private static int N;
  private static int M;
  private static ArrayList<Integer> nums;
  private static StringBuilder sb;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    Solution();
    output();
  }

  private static void output() {
    System.out.print(sb.toString());
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    nums = new ArrayList<>();
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      int item = Integer.parseInt(st.nextToken());
      if (!nums.contains(item)) {
        nums.add(item);
      }
    }

    br.close();
  }

  private static void Solution() {
    nums.sort(Comparator.naturalOrder());
    sb = new StringBuilder();

    perm(new int[N], 0);
  }

  // 서로 다른 n개에서 중복이 가능하게 r개를 뽑아서 정렬하는 경우의 수
  private static void perm(int[] out, int depth) {
    if (depth == M) {
      for (int i = 0; i < M; i++) {
        sb.append(nums.get(out[i])).append(" ");
      }
      sb.append("\n");
      return;
    }

    int prev = -1;
    for (int i = 0; i < nums.size(); i++) {
      if (prev != i) { // 중복되는 수열 여러번 출력되는거 방지
        prev = i;
        out[depth] = prev;
        perm(out, depth + 1);
      }
    }
  }

}
