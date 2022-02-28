package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class q11000 {

  private static int N;
  private static int[] S;
  private static int[] T;

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

    S = new int[N];
    T = new int[N];

    StringTokenizer st;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      S[i] = Integer.parseInt(st.nextToken());
      T[i] = Integer.parseInt(st.nextToken());
    }

    br.close();
  }

  private static int Solution() {

    int[][] map = new int[N][2];
    for (int i = 0; i < N; i++) {
      map[i][0] = S[i];
      map[i][1] = T[i];
    }

    Arrays.sort(map, (o1, o2) -> {
      if (o1[0] == o2[0]) {
        return o1[1] - o2[1];
      }
      return o1[0] - o2[0];
    });

    PriorityQueue<Integer> queue = new PriorityQueue<>();

    queue.add(map[0][1]);//

    for (int i = 1; i < N; i++) {
      if (queue.peek() <= map[i][0]) { //이번 시작시간이 저번 종료시간보다 클 경우 --> 강의실 증가X
        queue.poll();
        queue.add(map[i][1]);
      } else {//저번 종료시간보다 먼저 시간 --> 강의실 증가O
        queue.add(map[i][1]);
      }
    }

    return queue.size();
  }

}
