package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q1248 {

  private static int N;
  private static Character[][] map;
  private static Integer[] answer;

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
    String str = br.readLine();
    map = new Character[N][N];

    int index = 0;
    for (int i = 0; i < N; i++) {
      for (int j = i; j < N; j++) {
        map[i][j] = str.charAt(index);
        map[j][i] = str.charAt(index);
        index++;
      }
    }

    br.close();
  }

  private static int Solution() {
    answer = new Integer[N];
    dfs(0, new Integer[N]);
    return 0;
  }

  private static void dfs(int index, Integer[] result) {
    if (index >= N) {
      StringBuilder sb = new StringBuilder();
      for (Integer num : result) {
        sb.append(num).append(" ");
      }
      System.out.print(sb);
      System.exit(0);
      return;
    }

    for (int i = -10; i <= 10; i++) {
      result[index] = i;
      if(isPossible(index+1, result)){
        dfs(index + 1, result);
      }
    }
  }

  private static boolean isPossible(int index, Integer[] result) {
    int sum = 0;
    for (int i = index - 1; i >= 0; i--) {
      sum += result[i];

      if ((map[index - 1][i] == '+' && sum <= 0) || (map[index - 1][i] == '-' && sum >= 0)
          || (map[index - 1][i] == '0' && sum != 0)) {
        return false;
      }
    }
    return true;
  }


}
