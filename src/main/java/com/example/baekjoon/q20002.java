package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q20002 {

  private static Integer N;
  private static int[][] map;
  private static int[][] prefixSum;


  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    output(Solution());
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());
    map = new int[N + 1][N + 1];

    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    br.close();
  }

  private static Integer Solution() {
    prefixSum = new int[N + 1][N + 1];

    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= N; j++) {
        prefixSum[i][j] =
            prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1] + map[i][j];
      }
    }

    Integer max = Integer.MIN_VALUE;
    Integer sum = 0;

    for (int i = 0; i < N; i++) { //정사각형 한변의 길이
      for (int j = 1; j <= N - i; j++) {
        for (int k = 1; k <= N - i; k++) {
          //정사각형 시작점 : (j,k), 종료점 : (j+i,k+i)
          sum = prefixSum[j + i][k + i] - prefixSum[j + i][k - 1] - prefixSum[j - 1][k + i]
              + prefixSum[j - 1][k - 1];
          max = Math.max(max, sum);
        }
      }
    }

    return max;
  }

  private static void output(Integer result) {
    System.out.print(result);
  }

}
