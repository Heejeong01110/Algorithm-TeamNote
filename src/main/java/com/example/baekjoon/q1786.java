package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q1786 {

  private static String T, P;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    System.out.print(Solution());
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    T = br.readLine();
    P = br.readLine();
    br.close();
  }

  private static String Solution() {

    //1. lps 배열 만들기
    int[] table = computeLps(P);
    int cnt = 0;
    StringBuilder sb = new StringBuilder();

    int idx = 0; // 현재 대응되는 글자 수
    for (int i = 0; i < T.length(); i++) {
      //불일치 -> 현재 대응된 글자의 수를 table[idx-1]번으로 줄인다.
      while (idx > 0 && T.charAt(i) != P.charAt(idx)) {
        idx = table[idx - 1];
      }
      //일치
      if (T.charAt(i) == P.charAt(idx)) {
        if (idx == P.length() - 1) { //일치
          cnt++;
          sb.append(i - idx + 1 + " ");
          idx = table[idx];
        } else {
          idx += 1;
        }
      }
    }

    sb.insert(0, cnt + "\n");

    return sb.toString();
  }

  private static int[] computeLps(String pattern) {
    int n = pattern.length();
    int[] table = new int[n]; //[0] ~ [i]의 접두사와 접미사가 같은 최대 길이

    int idx = 0;
    for (int i = 1; i < n; i++) {
      // 일치하는 문자가 발생했을 때(idx>0), 연속적으로 더 일치하지 않으면 idx = table[idx-1]로 돌려준다.
      while (idx > 0 && pattern.charAt(i) != pattern.charAt(idx)) {
        idx = table[idx - 1];
      }

      if (pattern.charAt(i) == pattern.charAt(idx)) {
        idx += 1;
        table[i] = idx;
      }
    }
    return table;
  }
}
