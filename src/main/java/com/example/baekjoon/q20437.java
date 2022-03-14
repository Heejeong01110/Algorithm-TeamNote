package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class q20437 {

  private static int N;
  private static String[] strings;
  private static int[] counts;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    output(Solution());
  }

  private static void output(StringBuilder result) {
    System.out.print(result.toString());
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    strings = new String[N];
    counts = new int[N];

    for (int i = 0; i < N; i++) {
      strings[i] = br.readLine();
      counts[i] = Integer.parseInt(br.readLine());
    }

    br.close();
  }

  private static StringBuilder Solution() {
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < N; i++) {
      HashMap<Character, Integer> map = new HashMap<>();

      for (int j = 0; j < strings[i].length(); j++) {
        map.put(strings[i].charAt(j), map.getOrDefault(strings[i].charAt(j), 0) + 1);
      }

      sb.append(findMin(i, map)).append("\n");
    }

    return sb;
  }

  private static String findMin(int index, HashMap<Character, Integer> map) {

    Integer min = Integer.MAX_VALUE;
    Integer max = Integer.MIN_VALUE;

    Character now;
    for (int i = 0; i < strings[index].length(); i++) {
      now = strings[index].charAt(i);
      if (map.get(now) < counts[index]) {
        continue;
      }

      Integer count = 0;
      for (int j = i; j < strings[index].length(); j++) {
        if (now == strings[index].charAt(j)) {
          count++;

          if (counts[index] == count) {
            min = Math.min(min, j - i + 1);
            max = Math.max(max, j - i + 1);
          }
        }
      }
    }

    if (min == Integer.MAX_VALUE) {
      return "-1";
    }

    return min + " " + max;
  }

}
