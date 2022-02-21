package com.example.programmers;

import java.util.ArrayList;

//뉴스 클러스터링
public class s17677 {

  static final int NUMBER = 65536;

  public static int solution(String str1, String str2) {
    int answer = 0;

    str1 = str1.toLowerCase();
    str2 = str2.toLowerCase();

    ArrayList<String> ary1 = new ArrayList<>();
    ArrayList<String> ary2 = new ArrayList<>();

    for (int i = 0; i < str1.length() - 1; i++) {
      if (Character.isAlphabetic(str1.charAt(i)) && Character.isAlphabetic(str1.charAt(i + 1))) {
        ary1.add(str1.substring(i, i + 2));
      }
    }
    for (int i = 0; i < str2.length() - 1; i++) {
      if (Character.isAlphabetic(str2.charAt(i)) && Character.isAlphabetic(str2.charAt(i + 1))) {
        ary2.add(str2.substring(i, i + 2));
      }
    }

    int common = 0;
    int total = ary1.size() + ary2.size();
    for (String s : ary1) {
      if (ary2.contains(s)) {
        common++;
        ary2.remove(s);
      }
    }

    total -= common;
    if (common == 0 && total == 0) {
      return NUMBER;
    } else {
      return NUMBER * (common) / total;
    }
  }
}
