package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q6068 {

  private static int N;
  private static int[] T;
  private static int[] S;
  private static Node[] nodes;

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

    N = Integer.parseInt(br.readLine());
    T = new int[N];
    S = new int[N];
    nodes = new Node[N];

    StringTokenizer st;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      T[i] = Integer.parseInt(st.nextToken());
      S[i] = Integer.parseInt(st.nextToken());

      nodes[i] = new Node(S[i], T[i]);
    }

    br.close();
  }

  private static int Solution() {
    Arrays.sort(nodes, (o1, o2) -> {
      if (o1.endTime == o2.endTime) {
        return o1.time - o2.time;
      }
      return o2.endTime - o1.endTime;
    });

    int startTime = nodes[0].endTime;
    for (int i = 0; i < nodes.length; i++) {
      if (nodes[i].endTime < startTime) {
        startTime = nodes[i].endTime - nodes[i].time;
      } else {
        startTime -= nodes[i].time;
      }
    }

    if (startTime < 0) {
      return -1;
    }
    return startTime;
  }

  private static class Node {

    int endTime;
    int time;

    public Node(int endTime, int time) {
      this.endTime = endTime;
      this.time = time;
    }
  }

}
