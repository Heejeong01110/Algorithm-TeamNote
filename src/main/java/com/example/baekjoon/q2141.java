package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q2141 {

  private static int N;
  private static Node[] nodes;
  private static long result;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    System.out.print(Solution());
  }

  private static void output(int result) {
    System.out.print(result);
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    nodes = new Node[N];
    result = 0;

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int loc = Integer.parseInt(st.nextToken());
      int val = Integer.parseInt(st.nextToken());
      nodes[i] = new Node(loc, val);
      result += val;
    }

    br.close();
  }

  private static long Solution() {
    Arrays.sort(nodes, (o1, o2) -> {
      if (o1.loc == o2.loc) {
        return o1.val > o2.val ? 1 : -1;
      }
      return o1.loc > o2.loc ? 1 : -1;
    });

    long sum = 0;
    for (int i = 0; i < N; i++) {
      sum += nodes[i].val;
      if (sum >= (result + 1) / 2) {
        return nodes[i].loc;
      }
    }

    return 0;
  }

  private static class Node {

    long loc;
    long val;

    public Node(long loc, long val) {
      this.loc = loc;
      this.val = val;
    }
  }

}
