package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q15664 {

  private static int N;
  private static int M;
  private static int[] inputAry;
  private static ArrayList<Integer[]> array;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    output(Solution());
  }

  private static void output(ArrayList<Integer[]> result) {
    for (int i = 0; i < result.size(); i++) {
      System.out.println(print(result.get(i)));
    }
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    inputAry = new int[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      inputAry[i] = Integer.parseInt(st.nextToken());
    }

    br.close();
  }

  private static ArrayList<Integer[]> Solution() {
    Arrays.sort(inputAry);
    array = new ArrayList<>();

    permutation(new Integer[M], new boolean[N], 0);

    return array;
  }

  // 서로 다른 n개 에서 r개를 뽑아서 정렬하는 경우의 수 + 사전순
  private static void permutation(Integer[] out, boolean[] visited, int depth) {
    if (depth == M) {
      Integer[] item = out.clone();
      if (!isContains(item)) {
        array.add(item);
      }

      return;
    }

    int prev = -1;
    if (depth - 1 >= 0) {
      prev = out[depth - 1];
    }

    for (int i = 0; i < inputAry.length; i++) {
      if (!visited[i] && prev <= inputAry[i]) {
        visited[i] = true;
        out[depth] = inputAry[i];
        permutation(out, visited, depth + 1);
        visited[i] = false;
      }
    }
  }

  private static boolean isContains(Integer[] item) {
    for (int i = 0; i < array.size(); i++) {
      if (Arrays.equals(array.get(i), item)) {
        return true;
      }
    }
    return false;
  }

  private static String print(Integer[] ary) {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < ary.length; i++) {
      builder.append(ary[i]).append(" ");
    }
    builder.delete(builder.length() - 1, builder.length());
    return builder.toString();
  }
}
