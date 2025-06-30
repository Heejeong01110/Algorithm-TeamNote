package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class q2108 {

  private static int N;
  private static int[] inp;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    Solution();
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    inp = new int[N];

    for (int i = 0; i < N; i++) {
      inp[i] = Integer.parseInt(br.readLine());
    }

    br.close();
  }

  private static void Solution() {
    Arrays.sort(inp);
    double sum = 0;

    int[][] memo = new int[8002][2];
    // -4000 ~ -1 : 0 ~ 3999
    //0 : 4000
    //1 ~ 4000 : 4001 ~ 8000

    for (int i = 0; i < N; i++) {
      int idx = inp[i] + 4000;
      memo[idx][0] = idx;
      memo[idx][1] += 1;
      sum += inp[i];
    }

    Arrays.sort(memo, (o1, o2) -> {
      if (o1[1] == o2[1]) {
        return o1[0] - o2[0];
      }
      return o2[1] - o1[1];
    });

    int minCnt = 0;
    int res = 0;
    for (int i = 0; i < 8002; i++) {
      if (minCnt != 0) {
        if (minCnt == memo[i][1]) {
          res = memo[i][0] - 4000;
        }
        break;
      }
      if (memo[i][0] != 0 || memo[i][1] != 0) {
        minCnt = memo[i][1];
        res = memo[i][0] - 4000;
      }
    }

    System.out.print((int) Math.round(sum / N) + "\n");//1
    System.out.print(inp[N / 2] + "\n");//2
    System.out.print(res + "\n");//3
    System.out.print(inp[N - 1] - inp[0] + "\n");//4
  }

}
