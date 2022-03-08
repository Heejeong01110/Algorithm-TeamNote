package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class q1343 {

  final private static String[] Polyomino = {"AAAA", "BB"};
  private static String board;

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
    board = br.readLine();

    br.close();
  }

  private static String Solution() {
    HashMap<Integer, Integer> pos = new HashMap<>();
    Integer idx = 0;
    for (int i = 0; i < board.length(); i++) {
      if (board.charAt(i) == 'X') {
        pos.put(idx, pos.getOrDefault(idx, 0) + 1);
      } else {
        idx++;
        pos.put(idx, pos.getOrDefault(idx, 0));
      }
    }

    StringBuilder resultBuilder = new StringBuilder();
    for (int i = 0; i <= idx; i++) {
      int A = pos.getOrDefault(i, 0) / 4;
      int B = (pos.getOrDefault(i, 0) % 4) / 2;
      int C = pos.getOrDefault(i, 0) % 2;
      if (C > 0) {
        return "-1";
      }
      resultBuilder.append(Polyomino[0].repeat(Math.max(0, A)));
      resultBuilder.append(Polyomino[1].repeat(Math.max(0, B)));
      resultBuilder.append(".");
    }

    return resultBuilder.substring(0, resultBuilder.length() - 1);
  }

}
