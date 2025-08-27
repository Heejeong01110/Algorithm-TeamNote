package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.StringTokenizer;

public class q2644 {

  private static int N, M, A, B;
  private static HashMap<Integer, Node> map;

  public static void main(String[] args) throws IOException {
    inputData();
    System.out.print(Solution());
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st;
    N = Integer.parseInt(br.readLine());
    map = new HashMap<>();
    for (int i = 1; i <= N; i++) {
      map.put(i, new Node(i, 0, new ArrayList<>()));
    }

    st = new StringTokenizer(br.readLine());
    A = Integer.parseInt(st.nextToken());
    B = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(br.readLine());

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int o1 = Integer.parseInt(st.nextToken());
      int o2 = Integer.parseInt(st.nextToken());
      map.get(o1).children.add(o2);
      map.get(o2).parent = o1;
    }

    br.close();
  }

  private static int Solution() {

    Queue<int[]> queue = new ArrayDeque<>();
    boolean[] visited = new boolean[N + 1];

    queue.add(new int[]{A, 0});
    visited[A] = true;

    int res = -1;
    while (!queue.isEmpty()) {
      int[] now = queue.poll();
      if (now[0] == B) {
        res = now[1];
        break;
      }

      Node node = map.get(now[0]);
      if (node.parent != 0 && !visited[node.parent]) {
        queue.add(new int[]{node.parent, now[1] + 1});
        visited[node.parent] = true;
      }

      for (int child : node.children) {
        if (!visited[child]) {
          visited[child] = true;
          queue.add(new int[]{child, now[1] + 1});
        }
      }
    }

    return res;
  }

  private static class Node {

    int val;
    int parent;
    ArrayList<Integer> children;

    public Node(int val, int parent, ArrayList<Integer> children) {
      this.val = val;
      this.parent = parent;
      this.children = children;
    }
  }

}
