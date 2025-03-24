package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class q1202 {

  private static int N, K;
  private static int[] bags;
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

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    nodes = new Node[N];
    bags = new int[K];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      nodes[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    }

    for (int i = 0; i < K; i++) {
      bags[i] = Integer.parseInt(br.readLine());
    }
    br.close();
  }

  private static long Solution() {
    Arrays.sort(nodes, ((o1, o2) -> {
      if (o2.m == o1.m) {
        return o2.v - o1.v;
      }
      return o1.m - o2.m;
    }));

    Arrays.sort(bags);
    PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
    long ans = 0;
    int idx = 0;

    for (int i = 0; i < K; i++) {
      while (idx < N) {
        if (bags[i] < nodes[idx].m) {
          break;
        }
        pq.add(nodes[idx++].v);
      }

      if (!pq.isEmpty()) {
        ans += pq.poll();
      }
    }

    return ans;
  }

  private static class Node {

    int m; //무게
    int v; //가격

    public Node(int m, int v) {
      this.m = m;
      this.v = v;
    }
  }
}
