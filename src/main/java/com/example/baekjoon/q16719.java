package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q16719 {

  private static Character[] inputs;
  private static String input;
  private static StringBuilder sb;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    output(Solution());
  }

  private static void output(String result) {
    System.out.print(result);
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    input = br.readLine();

    inputs = new Character[input.length()];
    for (int i = 0; i < inputs.length; i++) {
      inputs[i] = input.charAt(i);
    }

    br.close();
  }

  private static String Solution() {
    sb = new StringBuilder();
    calc(new boolean[input.length()], 0, input.length() - 1);
    return sb.toString();
  }

  private static boolean[] calc(boolean[] result2, int start, int end) {
    if (start > end || start < 0 || end >= input.length()) {
      return result2;
    }

    Integer firstIdx = getFirstChar(start, end);
    result2[firstIdx] = true;
    sb.append(getStr(result2)).append("\n");

    boolean[] backStr = calc(result2, firstIdx + 1, end);
    boolean[] frontStr = calc(backStr, start, firstIdx - 1);

    return frontStr;
  }

  private static String getStr(boolean[] result) {
    StringBuilder str = new StringBuilder();
    for (int i = 0; i < result.length; i++) {
      if (result[i]) {
        str.append(inputs[i]);
      }
    }
    return str.toString();
  }

  private static Integer getFirstChar(int start, int end) {
    Character result = inputs[start];
    Integer index = start;

    for (int i = start; i <= end; i++) {
      if (result > inputs[i]) {
        result = inputs[i];
        index = i;
      }
    }
    return index;
  }
}
