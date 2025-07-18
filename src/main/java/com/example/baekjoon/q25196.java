package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q25196 {

  private static int[][] inp;

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
    inp = new int[3][3];

    for (int i = 0; i < 3; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 3; j++) {
        inp[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    br.close();
  }

  private static long Solution() {
    Arrays.sort(inp, (o1, o2) -> {
      if (o1[0] == o2[0]) {
        return o2[1] - o1[1];
      }
      return o2[0] - o1[0];
    });

    long len = ((long) inp[0][0]) * inp[1][0] * inp[2][0];
    for (long i = 0; i <= len; i++) {
      long[] nums = new long[3];
      for (int j = 0; j < 3; j++) {
        nums[j] = i % inp[j][0];
      }

      if (inp[0][1] <= nums[0] && nums[0] <= inp[0][2] && inp[1][1] <= nums[1]
          && nums[1] <= inp[1][2]
          && inp[2][1] <= nums[2] && nums[2] <= inp[2][2]) {
        return i;
      }

      long plus = 0;
      for (int j = 0; j < 3; j++) {
        if (nums[j] < inp[j][1]) {
          plus = Math.max(plus, inp[j][1] - nums[j]);
        } else if (nums[j] > inp[j][2]) {
          plus = Math.max(plus, inp[j][0] + inp[j][1] - nums[j]);
        }
      }
      i += (plus - 1);
    }

    return -1;
  }


}
