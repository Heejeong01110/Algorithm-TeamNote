package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class q2109 {

  private static int N;
  private static int[][] lectures;

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
    lectures = new int[N][2];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      lectures[i][0] = Integer.parseInt(st.nextToken());
      lectures[i][1] = Integer.parseInt(st.nextToken());
    }

    br.close();
  }

  private static int Solution() {
    ArrayList<Node> nodes = new ArrayList<>();
    int maxDay = 0;
    for (int i = 0; i < N; i++) {
      nodes.add(new Node(lectures[i][1], lectures[i][0]));
      maxDay = Math.max(maxDay, lectures[i][1]);
    }

    nodes.sort((o1, o2) -> o1.pay == o2.pay ? o1.day - o2.day : o2.pay - o1.pay);
    int[] schedule = new int[maxDay+1];
    int sum = 0;
    for (Node node : nodes) {
      for (int j = node.day; j >= 1; j--) {
        if (schedule[j] == 0) {
          schedule[j] = node.pay;
          sum += node.pay;
          break;
        }
      }
    }

    return sum;
  }

  private static class Node {

    int day;
    int pay;

    public Node(int day, int pay) {
      this.day = day;
      this.pay = pay;
    }
  }

}
