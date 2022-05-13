package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q {

  private int N;
  private int M;
  private int[] ary;

  public void main(String[] args) throws IOException {
    run();
  }

  public void run() throws IOException {
    inputData();
    output(Solution());
  }

  private void output(int result) {
    System.out.print(result);
  }

  private void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    ary = new int[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      ary[i] = Integer.parseInt(st.nextToken());
    }
    
    br.close();
  }

  private int Solution() {
    return 0;
  }

}
