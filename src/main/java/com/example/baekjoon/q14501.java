package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q14501 {

  private static int N;
  private static int result;
  private static int[][] prices;

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
    result = 0;
    prices = new int[N][2];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      prices[i][0] = Integer.parseInt(st.nextToken());
      prices[i][1] = Integer.parseInt(st.nextToken());
    }

    br.close();
  }

  private static int Solution() {

    dfs(0, 0);
    return result;
  }

  private static void dfs(int idx, int sum){
    if(idx == N){
      result = Math.max(result, sum);
      return;
    }

    for(int i=idx;i<N;i++){
      if(i + prices[i][0] <= N){
        dfs(i + prices[i][0] , sum + prices[i][1]);
      }else{
        result = Math.max(result, sum);
      }
    }


  }
}
