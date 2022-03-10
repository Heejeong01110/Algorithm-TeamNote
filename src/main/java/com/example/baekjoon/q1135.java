package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class q1135 {

  private static int N;
  private static int[] list;

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

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    list = new int[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      list[i] = Integer.parseInt(st.nextToken());
    }

    br.close();
  }

  private static int Solution() {
    Integer result = 0;

    Node[] nodes = new Node[N];
    nodes[0] = new Node(0, 0, null, new ArrayList<>());

    for (int i = 1; i < N; i++) {
      Node parent = nodes[list[i]];
      nodes[i] = new Node(i, 0, parent, new ArrayList<>());
      nodes[list[i]].children.add(nodes[i]);
    }

    for (int i = N - 1; i >= 0; i--) {
      if (nodes[i].children.isEmpty()) { //맨 마지막
        nodes[i].minute = 0;
        continue;
      }

      nodes[i].children.sort((o1, o2) -> o2.minute - o1.minute);
      Integer maxMin = 0;
      for (int j = 1; j <= nodes[i].children.size(); j++) {
        maxMin = Math.max(nodes[i].children.get(j - 1).minute + j, maxMin);
      }

      nodes[i].minute = maxMin;

    }

    return nodes[0].minute;
  }

  private static class Node {

    int index;
    int minute;
    Node parent;
    ArrayList<Node> children;

    public Node(int index, int minute, Node parent,
        ArrayList<Node> children) {
      this.index = index;
      this.minute = minute;
      this.parent = parent;
      this.children = children;
    }

  }

}
