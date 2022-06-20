package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q2458 {

  private static int N;
  private static int M;
  private static int[] degree;
  private static ArrayList<Integer>[] nodes;
  private static ArrayList<Integer>[] reverseNodes;

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
    M = Integer.parseInt(st.nextToken());
    degree = new int[N + 1];

    nodes = new ArrayList[N + 1];
    reverseNodes = new ArrayList[N + 1];
    for (int i = 1; i <= N; i++) {
      nodes[i] = new ArrayList<>();
      reverseNodes[i] = new ArrayList<>();
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int one = Integer.parseInt(st.nextToken());
      int two = Integer.parseInt(st.nextToken());
      nodes[one].add(two);
      reverseNodes[two].add(one);
      degree[two]++;
    }

    br.close();
  }

  private static int Solution() {
    int result = 0;
    for (int i = 1; i <= N; i++) {
      if (check(i)) {
        result++;
      }
    }
    return result;
  }

  private static boolean check(int idx) {
    return getCount(idx, nodes) + getCount(idx, reverseNodes) == N - 1;
  }

  private static int getCount(int idx, ArrayList<Integer>[] nowNode) {
    Queue<Integer> queue = new ArrayDeque<>();
    boolean[] visited = new boolean[N + 1];

    int count = 0;
    visited[idx] = true;

    for (int i = 0; i < nowNode[idx].size(); i++) {
      queue.add(nowNode[idx].get(i));
      visited[nowNode[idx].get(i)] = true;
    }

    while (!queue.isEmpty()) {
      int now = queue.poll();
      count++;

      for (int i = 0; i < nowNode[now].size(); i++) {
        if (visited[nowNode[now].get(i)]) {
          continue;
        }
        queue.add(nowNode[now].get(i));
        visited[nowNode[now].get(i)] = true;
      }
    }
    return count;
  }

}
