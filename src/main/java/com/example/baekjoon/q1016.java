package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1016 {

  private static long min;
  private static long max;

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
    min = Long.parseLong(st.nextToken());
    max = Long.parseLong(st.nextToken());

    br.close();
  }

  private static int Solution() {
    int result = (int) (max - min + 1);
    int sqrt = ((int) Math.sqrt(max));

    boolean[] checks = new boolean[result]; // 제곱 ㄴㄴ수가 아님을 체크. false : 제곱ㄴㄴ수, true : 제곱ㄴㄴ수가 아님.
    long[] num = new long[result];

    for (long i = 2; i <= sqrt; i++) {
      long squared = i * i;
      long start = min % squared == 0 ? min / squared : (min / squared) + 1;
      for(long j = start; j * squared <= max; j ++) {	// 몫을 1씩 증가시킴( j가 몫 )
        checks[(int) ( (j * squared) - min)] = true;
      }
    }

    return result;
  }

}
