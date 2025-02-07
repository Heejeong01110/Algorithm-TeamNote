package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class q25970 {

  private static int bLen, nLen;
  private static String[] bLow, bHigh; //길이 3 ~ 50의 비트. 중복 없음.
  private static String[] N; //최대 250.
  private static List<Node> nodes;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    Solution();
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    bLen = Integer.parseInt(br.readLine());
    nodes = new ArrayList<>();
    for (int i = 0; i < bLen; i++) {
      nodes.add(new Node(br.readLine(), -1));
    }
    for (int i = 0; i < bLen; i++) {
      nodes.add(new Node(br.readLine(), 1));
    }

    nLen = Integer.parseInt(br.readLine());
    N = new String[nLen];
    for (int i = 0; i < nLen; i++) {
      N[i] = br.readLine();
    }

    br.close();
  }

  private static void Solution() {
    nodes.sort(Comparator.comparingInt(o -> o.data.length()));
    for (String data : N) {
      int result = 0;

      for (int i = 0; i < data.length(); i++) {
        for (Node now : nodes) {
          if (i + now.data.length() <= data.length()
              && data.startsWith(now.data, i)) {
            result += now.type;
          }
        }
      }

      System.out.print(getRes(result) + "\n");

    }
  }

  private static String getRes(int result) {
    if (result == 0) {
      return "GOOD";
    }
    if (result > 0) {
      return "LOW " + result;
    }
    return "HIGH " + Math.abs(result);
  }

  private static class Node {

    String data;
    int type;

    public Node(String data, int type) {
      this.data = data;
      this.type = type;
    }
  }

}
