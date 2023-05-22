package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class q1049 {

  private static int N;
  private static int M;
  private static int[][] packages;

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
    packages = new int[M][2];

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      packages[i][0] = Integer.parseInt(st.nextToken());
      packages[i][1] = Integer.parseInt(st.nextToken());
    }

    br.close();
  }

  private static int Solution() {
    ArrayList<Integer> arrays_s = new ArrayList<>();
    ArrayList<Integer> arrays_o = new ArrayList<>();
    for (int i = 0; i < M; i++) {
      arrays_s.add(packages[i][0]);
      arrays_o.add(packages[i][1]);
    }
    arrays_s.sort(Comparator.naturalOrder());
    arrays_o.sort(Comparator.naturalOrder());

    if (arrays_s.get(0) < arrays_o.get(0) * 6) {
      return (N / 6) * arrays_s.get(0) + Math.min((N % 6) * arrays_o.get(0), arrays_s.get(0));
    }
    return N * arrays_o.get(0);
  }

}
