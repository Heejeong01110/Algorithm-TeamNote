package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class q1036 {

  private static int N, K;
  private static String[] inp;
  private static Map<Character, int[]> map;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    System.out.print(Solution());
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    map = new HashMap<>();
    inp = new String[N];

    for (int i = 0; i < N; i++) {
      inp[i] = br.readLine();
      int len = inp[i].length();
      for (int j = 0; j < len; j++) {
        char c = inp[i].charAt(len - 1 - j);
        int[] counts = map.getOrDefault(c, new int[51]);
        counts[j]++;
        map.put(c, counts);
      }
    }
    K = Integer.parseInt(br.readLine());
    br.close();
  }

  private static String Solution() {
    // 1) 각 문자별 이득을 “36진수 문자열”로 미리 계산
    Map<Character, String> gainStr = new HashMap<>();
    for (Map.Entry<Character, int[]> e : map.entrySet()) {
      char c = e.getKey();
      int diffVal = 35 - toNum(c);
      // toNumeral: diffVal × 36^i 를 자리 문자열로 만들어 전부 더한 결과
      String gs = toNumeral(diffVal, e.getValue());
      // 불필요한 앞 ‘0’ 제거
      while (gs.length() > 1 && gs.charAt(0) == '0') {
        gs = gs.substring(1);
      }
      gainStr.put(c, gs);
    }

    // 2) 등장한 문자들만 리스트로 추출, “이득 문자열” 기준으로 내림차순 정렬
    List<Character> digits = new ArrayList<>(map.keySet());
    digits.sort((a, b) -> {
      String sa = gainStr.get(a), sb = gainStr.get(b);
      if (sa.length() != sb.length()) {
        return Integer.compare(sb.length(), sa.length());
      }
      return sb.compareTo(sa);
    });

    // 3) 정렬된 순서대로 첫 K개는 Z(35)로, 나머지는 원래 숫자로 기여값 더하기
    String result = "0";
    int replaced = 0;
    for (char d : digits) {
      int val = (replaced < K ? 35 : toNum(d));
      if (replaced < K) {
        replaced++;
      }
      result = plus(result, toNumeral(val, map.get(d)));
    }
    return result;
  }

  private static String toNumeral(int idx, int[] counts) {
    String res = "0";
    String str = toChar(idx);
    for (int i = 0; i < counts.length; i++) {
      for (int j = 0; j < counts[i]; j++) {
        res = plus(res, str + "0".repeat(i));
      }
    }
    return res;
  }

  private static String plus(String one, String two) {
    StringBuilder res = new StringBuilder();
    if (one.length() > two.length()) {
      two = "0".repeat(one.length() - two.length()) + two;
    } else if (one.length() < two.length()) {
      one = "0".repeat(two.length() - one.length()) + one;
    }

    int carry = 0; //올림 수 저장
    for (int i = one.length() - 1; i >= 0; i--) {
      int a = toNum(one.charAt(i));
      int b = toNum(two.charAt(i));
      int sum = a + b + carry;
      carry = sum / 36;
      res.insert(0, toChar(sum % 36));
    }
    if (carry > 0) {
      res.insert(0, toChar(carry));
    }
    return res.toString();
  }

  private static String toChar(int sum) {
    if (sum >= 10) {
      return String.valueOf((char) ('A' + sum - 10));
    }
    return String.valueOf((char) ('0' + sum));
  }

  private static int toNum(Character c) {
    if (c >= 'A' && c <= 'Z') {
      return c - 'A' + 10;
    }
    return c - '0';
  }
}
