package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q10427 {

  private static int T;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    T = Integer.parseInt(br.readLine());
    StringTokenizer st;
    Long[] list;
    for (int t = 0; t < T; t++) {
      st = new StringTokenizer(br.readLine());
      int size = Integer.parseInt(st.nextToken());
      list = new Long[size];
      Long[] result = new Long[size];

      for (int i = 0; i < size; i++) {
        list[i] = Long.parseLong(st.nextToken());
        result[i] = Long.MAX_VALUE;
      }
      Arrays.sort(list);

      Long[] sumList = new Long[size];
      sumList[0] = list[0];
      for (int i = 1; i < size; i++) {
        sumList[i] = sumList[i - 1] + list[i];
      }

      for (int i = 0; i < size; i++) {
        for (int j = i; j < size; j++) {
          result[j - i] = Math.min(result[j - i], calc(sumList, i, j));
        }
      }

      Long sum = 0L;
      for (int i = 0; i < size; i++) {
        sum += result[i];
      }
      System.out.println(sum);

    }

    br.close();
  }

  private static long calc(Long[] sumList, int start, int end) {
    Long max = sumList[end] - (end - 1 >= 0 ? sumList[end - 1] : 0);
    Long sum = sumList[end] - (start - 1 >= 0 ? sumList[start - 1] : 0);
    return max * (end - start + 1) - sum;
  }

}
