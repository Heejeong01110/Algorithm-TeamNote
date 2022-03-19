package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q20114 {

  private static int N;
  private static int H;
  private static int W;
  private static String[] strings;

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

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    H = Integer.parseInt(st.nextToken());
    W = Integer.parseInt(st.nextToken());
    strings = new String[H];

    for (int i = 0; i < H; i++) {
      strings[i] = br.readLine();
    }

    br.close();
  }

  private static String Solution() {
    Character[] charAry = new Character[N];
    StringBuilder result = new StringBuilder();

    for (int i = 0; i < H; i++) {
      for (int j = 0; j < W * N; j++) {
        if (charAry[j / W] == null) {
          charAry[j / W] = '?';
        }
        if (strings[i].charAt(j) != '?' && charAry[j / W] == '?') {
          charAry[j / W] = strings[i].charAt(j);
        }
      }
    }

    for (int i = 0; i < N; i++) {
      result.append(charAry[i]);
    }

    return result.toString();
  }

}
