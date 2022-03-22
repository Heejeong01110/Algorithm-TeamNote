package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class q1411 {

  private static int N;
  private static String[] Strings;

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
    Strings = new String[N];

    for (int i = 0; i < N; i++) {
      Strings[i] = br.readLine();
    }

    br.close();
  }

  private static int Solution() {
    String[] nums = new String[N];

    for (int i = 0; i < N; i++) {
      nums[i] = check(Strings[i]);
    }

    Integer result = 0;
    for (int i = 0; i < N; i++) {
      for (int j = i + 1; j < N; j++) {
        if (nums[i].equals(nums[j])) {
          result += 1;
        }
      }
    }

    return result;
  }

  private static String check(String str) {
    StringBuilder result = new StringBuilder();
    ArrayList<Character> count = new ArrayList<>();
    for (int i = 0; i < str.length(); i++) {
      Character s = str.charAt(i);
      if (!count.contains(s)) {
        count.add(s);
      }
      result.append(count.indexOf(s));
    }
    return result.toString();
  }

}
