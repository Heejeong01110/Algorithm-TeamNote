package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q2170 {

  private static int N;
  private static int[][] inp;

  private static Node[] nodes;

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
    nodes = new Node[N];

    StringTokenizer st;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      nodes[i] = new Node(
          Integer.parseInt(st.nextToken()),
          Integer.parseInt(st.nextToken()));
    }

    br.close();
  }

  private static int Solution() {
    Arrays.sort(nodes, (o1, o2) -> {
      if (o1.s == o2.s) {
        return o1.e - o2.e;
      }
      return o1.s - o2.s;
    });

    int min = nodes[0].s;
    int max = nodes[0].e;
    int ans = max - min;

    for (int i = 1; i < N; i++) {
      int s = nodes[i].s;
      int e = nodes[i].e;

      if (min <= s && max >= e) {
        continue;
      } else if (s < max) {
        ans += e - max;
      } else {
        ans += e - s;
      }
      min = s;
      max = e;
    }

    return ans;
  }

  private static class Node {

    int s;
    int e;

    public Node(int s, int e) {
      this.s = s;
      this.e = e;
    }
  }
}
