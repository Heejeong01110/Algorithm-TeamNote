package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q15918 {

  private static int N;
  private static int X;
  private static int Y;

  private static int answer;

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
    X = Integer.parseInt(st.nextToken());
    Y = Integer.parseInt(st.nextToken());

    br.close();
  }

  private static int Solution() {
    int[] result = new int[2 * N + 1];
    boolean[] visited = new boolean[N + 1];

    answer = 0;

    int usedNum = Math.abs(X - Y) - 1;
    result[X] = usedNum;
    result[Y] = usedNum;
    visited[usedNum] = true;
    dfs(result, visited, 1, 1);

    return answer;
  }

  private static void dfs(int[] result, boolean[] visited, int count, int start) {

    if (count >= N) {
      answer += 1;
      return;
    }

    while (start <= 2 * N) {
      if (result[start] == 0) {
        break;
      }
      start++;
    }

    for (int i = 1; i <= N; i++) {
      if (visited[i]) {
        continue;
      }

      if (start + i + 1 <= 2 * N && result[start] == 0 && result[start + i + 1] == 0) {
        result[start] = i;
        result[start + i + 1] = i;
        visited[i] = true;
        dfs(result, visited, count + 1, start + 1);
        result[start] = 0;
        result[start + i + 1] = 0;
        visited[i] = false;
      }

    }
  }

}
