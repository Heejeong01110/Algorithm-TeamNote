package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class q2212 {

  private static int N;
  private static int K;
  private static int[] sensors;

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
    K = Integer.parseInt(br.readLine());
    sensors = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      sensors[i] = Integer.parseInt(st.nextToken());
    }

    br.close();
  }

  private static int Solution() {
    if (N <= K) {
      return 0;
    }
    Arrays.sort(sensors);

    int AllLen = sensors[sensors.length - 1] - sensors[0];
    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 1; i < sensors.length; i++) {
      list.add(sensors[i] - sensors[i - 1]);
    }
    list.sort(Comparator.reverseOrder());

    int sum = 0;
    for (int i = 0; i < K - 1; i++) {
      sum += list.get(i);
    }

    return AllLen - sum;

  }
}
