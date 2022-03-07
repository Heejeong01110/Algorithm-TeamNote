package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.StringTokenizer;

public class q17471 {

  private static int N;
  private static HashMap<Integer, Node> nodes;
  private static int result;


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
    nodes = new HashMap<>();

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      nodes.put(i, new Node(i, Integer.parseInt(st.nextToken()), new ArrayList<>()));
    }
    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());

      int count = Integer.parseInt(st.nextToken());
      for (int j = 1; j <= count; j++) {
        nodes.get(i).neighbors.add(Integer.parseInt(st.nextToken()));
      }
    }

    br.close();
  }

  private static int Solution() {
    result = Integer.MAX_VALUE;

    for (int i = 1; i <= N / 2; i++) {
      comb(new boolean[N + 1], 1, 0, i);
    }

    if (result == Integer.MAX_VALUE) {
      result = -1;
    }

    return result;
  }

  private static void comb(boolean[] visited, int start, int depth, int r) {
    if (depth == r) {
      ArrayList<Integer> aAry = new ArrayList<>();
      ArrayList<Integer> bAry = new ArrayList<>();
      for (int i = 1; i <= N; i++) {
        if (visited[i]) {
          aAry.add(i);
        } else {
          bAry.add(i);
        }
      }

      if (isConnect(aAry) && isConnect(bAry)) {
        Integer a = 0;
        Integer b = 0;
        for (int i = 1; i <= N; i++) {
          if (visited[i]) {
            a += nodes.get(i).value;
          } else {
            b += nodes.get(i).value;
          }
        }

        int inter = Math.abs(a - b);
        result = Math.min(result, inter);
      }
      return;
    }

    for (int i = start; i <= N; i++) {
      if (!visited[i]) {
        visited[i] = true;
        comb(visited, i + 1, depth + 1, r);
        visited[i] = false;
      }
    }

  }

  private static boolean isConnect(ArrayList<Integer> ary) {
    Queue<Integer> queue = new ArrayDeque<>();
    boolean[] visited = new boolean[N + 1];
    queue.add(ary.get(0));

    while (!queue.isEmpty()) {
      Integer now = queue.poll();
      visited[now] = true;

      for (int j = 0; j < nodes.get(now).neighbors.size(); j++) {
        if (ary.contains(nodes.get(now).neighbors.get(j)) && !visited[nodes.get(now).neighbors.get(
            j)]) {
          queue.add(nodes.get(now).neighbors.get(j));
        }
      }
    }

    for (int i = 1; i <= N; i++) {
      if (ary.contains(i) && !visited[i]) {
        return false;
      }
    }

    return true;
  }


  private static class Node {

    Integer index;
    Integer value;
    ArrayList<Integer> neighbors;

    public Node(int index, int value, ArrayList<Integer> neighbors) {
      this.index = index;
      this.value = value;
      this.neighbors = neighbors;
    }
  }

}
