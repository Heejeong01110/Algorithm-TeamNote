package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;

public class q1036 {

  private static int N, K;
  private static String[] inp;

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
    inp = new String[N];

    for (int i = 0; i < N; i++) {
      inp[i] = br.readLine();
    }
    K = Integer.parseInt(br.readLine());
    br.close();
  }

  private static String Solution() {
    int result = 0;
    // gain[d]: d(0~35)을 'Z'(35)로 바꿀 때 얻는 이득
    BigInteger[] gain = new BigInteger[36];
    Arrays.fill(gain, BigInteger.ZERO);

    BigInteger total = BigInteger.ZERO;
    BigInteger BASE = BigInteger.valueOf(36);

    // 각 숫자에 대해 자리값 계산
    for (String s : inp) {
      int len = s.length();
      for (int i = 0; i < len; i++) {
        char c = s.charAt(len - 1 - i);
        int v = Character.isDigit(c) ? c - '0' : c - 'A' + 10;
        BigInteger place = BASE.pow(i);
        // 원래 합계에 추가
        total = total.add(place.multiply(BigInteger.valueOf(v)));
        // 이득 계산: (35 - v) * 36^i
        BigInteger delta = place.multiply(BigInteger.valueOf(35 - v));
        gain[v] = gain[v].add(delta);
      }
    }

    Arrays.sort(gain, Comparator.reverseOrder());
    for (int i = 0; i < K; i++) {
      if (gain[i].compareTo(BigInteger.ZERO) == 0) {
        break;
      }
      total = total.add(gain[i]);
    }

    String ans = total.equals(BigInteger.ZERO) ? "0" : total.toString(36).toUpperCase();
    return ans;
  }

}
