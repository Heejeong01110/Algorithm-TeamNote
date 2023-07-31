package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q24337 {

  private static int N, a, b;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();

    if (a + b > N + 1) {
      System.out.print("-1");
      return;
    }

    int[] answer = new int[N];
    Arrays.fill(answer, 1);

    for (int i = 1; i < b; i++) {
      int idx = N - i;
      answer[idx] = i;
    }

    if(a == 1){
      answer[0] = b;
    }else{
      answer[N - b] = Math.max(a, b);
      for (int i = 1; i <= a - 1; i++) {
        int idx = (N - b) - i;
        answer[idx] = a - i;
      }
    }



    StringBuilder sb = new StringBuilder();
    for (int n : answer) {
      sb.append(n).append(" ");
    }
    System.out.print(sb.substring(0, sb.length() - 1));
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    a = Integer.parseInt(st.nextToken());
    b = Integer.parseInt(st.nextToken());
    br.close();
  }

}
