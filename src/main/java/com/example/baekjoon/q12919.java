package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q12919 {

  private static String start, target;
  private static boolean result;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    System.out.print(Solution());
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    start = br.readLine();
    target = br.readLine();
    br.close();
  }

  private static int Solution() {
    result = false;
    dfs(target, 0);
    if (result) {
      return 1;
    }
    return 0;
  }

  private static void dfs(String str, int dir) {
    if (result) {
      return;
    }
    if (str.length() == start.length()) {
      if (isEquals(str, dir, start)) {
        result = true;
      }
      return;
    }

    if (dir == 0) {
      if (str.charAt(0) == 'B') {
        dfs(str.substring(1, str.length()), 1);
      }
      if (str.charAt(str.length() - 1) == 'A') {
        dfs(str.substring(0, str.length() - 1), 0);
      }
    } else {
      if (str.charAt(str.length() - 1) == 'B') {
        dfs(str.substring(0, str.length() - 1), 0);
      }
      if (str.charAt(0) == 'A') {
        dfs(str.substring(1, str.length()), 1);
      }
    }

  }

//  private static void dfs(String str, int dir) {
//    if (result) {
//      return;
//    }
//
//    if (str.length() == target.length()) {
//      if (isEquals(str, dir, target)) {
//        result = true;
//      }
//      return;
//    }
//    if (dir == 0) {
//      dfs(str + "A", 0);
//      dfs(str + "B", 1);
//    } else {
//      dfs("A" + str, 1);
//      dfs("B" + str, 0);
//    }
//  }

  private static boolean isEquals(String str, int dir, String target) {
    if (dir == 0) {
      return str.equals(target);
    }
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) != target.charAt(str.length() - 1 - i)) {
        return false;
      }
    }
    return true;
  }


}
