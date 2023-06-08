package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class q13904 {

  private static int N;
  private static int[][] ary;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    output(Solution());
  }

  private static void output(int result) {
    System.out.print(result);
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st;
    N = Integer.parseInt(br.readLine());
    ary = new int[N][2];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      ary[i][0] = Integer.parseInt(st.nextToken());
      ary[i][1] = Integer.parseInt(st.nextToken());
    }

    br.close();
  }

  private static int Solution() {
    ArrayList<Node> nodes = new ArrayList<>();
    int maxDay = 0;
    for (int i = 0; i < N; i++) {
      nodes.add(new Node(ary[i][0], ary[i][1]));
      maxDay = Math.max(maxDay, ary[i][0]);
    }
    nodes.sort((o1, o2) -> o1.score == o2.score ? o1.day - o2.day : o2.score - o1.score);
    int sum = 0;
    int[] scores = new int[maxDay + 1];

    for (Node node : nodes) {

      for (int i = node.day; i > 0; i--) {
        if (scores[i] == 0) {
          scores[i] = node.score;
          sum += scores[i];
          break;
        }
      }
    }

    return sum;
  }

  private static class Node {

    int day;
    int score;

    public Node(int day, int score) {
      this.day = day;
      this.score = score;
    }
  }

}
