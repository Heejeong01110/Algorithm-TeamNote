package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;

public class q10800 {

  private static int N, M;
  private static int[][] inp;
  private static Map<Integer, ArrayList<Integer>> map;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    System.out.print(Solution());
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st;
    N = Integer.parseInt(br.readLine());
    inp = new int[N + 1][3];

    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      inp[i][0] = Integer.parseInt(st.nextToken());
      inp[i][1] = Integer.parseInt(st.nextToken());
      inp[i][2] = i;
    }

    br.close();
  }

  private static String Solution() {
    Arrays.sort(inp, (o1, o2) -> {
      if (o1[1] == o2[1]) {
        return o1[0] - o2[0];
      }
      return o1[1] - o2[1];
    });

    int[] res = new int[N + 1];
    int[] sumList = new int[N + 1];
    int[] sameSizes = new int[2001];
    int[] sameColors = new int[N + 1];
    int sameSizeColorSum = 0;
    int preSize = 0;
    int preColor = 0;

    for (int i = 1; i <= N; i++) {
      sumList[i] = sumList[i - 1] + inp[i][1];
      sameSizes[inp[i][1]] += 1;
      if (preSize == inp[i][1] && preColor == inp[i][0]) {
        sameSizeColorSum += 1;
      } else {
        sameSizeColorSum = 0;
        preSize = inp[i][1];
        preColor = inp[i][0];
      }
      sameColors[inp[i][0]] += inp[i][1];
      res[inp[i][2]] = sumList[i]
          - sameColors[inp[i][0]]
          - sameSizes[inp[i][1]] * inp[i][1]
          + inp[i][1] * (sameSizeColorSum + 1);
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= N; i++) {
      sb.append(res[i]).append("\n");
    }
    return sb.substring(0, sb.length() - 1);
  }

}
