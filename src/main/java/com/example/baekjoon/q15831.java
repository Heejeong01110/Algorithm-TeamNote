package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q15831 {

  private static int N;
  private static int B;
  private static int W;
  private static boolean[] road;

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
    B = Integer.parseInt(st.nextToken());
    W = Integer.parseInt(st.nextToken());
    road = new boolean[N];

    String str = br.readLine();
    for (int i = 0; i < N; i++) {
      road[i] = str.charAt(i) == 'W';
    }

    br.close();
  }

  private static int Solution() {
    int start = 0;
    int end = 0;

    int black = road[0] ? 0 : 1;
    int white = road[0] ? 1 : 0;
    int result = 0;

    while (end < N) {

      if (white >= W && black <= B) {
        result = Math.max(result, end - start + 1);
      }

      if (black > B) {
        if (road[start]) {
          white--;
        } else {
          black--;
        }
        start++;
      } else {
        end++;
        if(end == N){
          continue;
        }

        if (road[end]) {
          white++;
        } else {
          black++;
        }
      }

    }

    return result;
  }

}
