package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q14719 {

  private static int N;
  private static int M;
  private static int[] ary;

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
    ary = new int[M];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < M; i++) {
      ary[i] = Integer.parseInt(st.nextToken());
    }

    br.close();
  }

  private static int Solution() {
    int answer = 0;
    boolean start = false;
    int index = -1;
    int count = 0;

    for (int i = 1; i <= N; i++) {
      start = false;
      index = -1;
      count = 0;
      for (int j = 0; j < M; j++) {
        if (ary[j] >= i) {
          if (!start) {
            start = true;
            index = j;
          } else if (j == index + 1) {
            index = j;
          } else {
            answer += count;
            count = 0;
            index = j;
          }
        } else {
          if (start) {
            count++;
          }
        }
      }
    }
    return answer;
  }

}
