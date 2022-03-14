package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q2003 {

  private static int N;
  private static int M;
  private static int[] A;

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
    A = new int[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
    }

    br.close();
  }

  private static int Solution() {
    Integer answer = 0;
    Integer start = 0;
    Integer end = 0;
    Integer sum = 0;

    while (end <= N) {
      if (sum < M) {
        if (end >= N) {
          break;
        }
        sum += A[end];
        end++;
      } else {
        if (sum == M) {
          answer++;
        }
        sum -= A[start];
        start += 1;
      }
    }

    return answer;
  }

}
