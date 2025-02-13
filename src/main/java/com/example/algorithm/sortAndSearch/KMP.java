package com.example.algorithm.sortAndSearch;

import java.io.IOException;

public class KMP {

  private static String T, P;

  public static void main(String[] args) throws IOException {
    T = "ABC ABCDAB ABCDABCDABDE";
    P = "ABCDABD";
    Solution();
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
          System.out.println("일치 문자열 발견");
          sb.append(i - idx + 1 + " "); //
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
    int[] table = new int[n]; //[0] ~ [i]의 접두사와 접미사가 같은 최대 길이 (ABCdeABC)

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
