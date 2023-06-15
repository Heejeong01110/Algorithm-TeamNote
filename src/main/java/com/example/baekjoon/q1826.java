package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class q1826 {

  private static int N;
  private static int[][] ary;
  private static int L, P;

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
    st = new StringTokenizer(br.readLine());
    L = Integer.parseInt(st.nextToken());
    P = Integer.parseInt(st.nextToken());

    br.close();
  }

  private static int Solution() {
    ArrayList<Node> nodes = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      nodes.add(new Node(ary[i][0], ary[i][1]));
    }
    nodes.sort((o1, o2) -> o1.dist - o2.dist == 0 ? o2.fuel - o1.fuel : o1.dist - o2.dist);
    PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

    int nl = P, np = 0, cnt = 0;
    while (nl < L) {
      while (np < N && nodes.get(np).dist <= nl) {
        queue.add(nodes.get(np).fuel);
        np++;
      }

      if (queue.isEmpty()) {
        cnt = -1;
        break;
      }

      nl += queue.poll();
      cnt++;
    }

    return cnt;
  }

  private static class Node {

    int dist;
    int fuel;

    public Node(int dist, int fuel) {
      this.dist = dist;
      this.fuel = fuel;
    }
  }

}
