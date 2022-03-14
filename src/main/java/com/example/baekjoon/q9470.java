package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class q9470 {

  private static int T;
  private static int[] K;
  private static int[] M;
  private static int[] depth;
  private static HashMap<Integer, Node>[] nodes;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    output(Solution());
  }

  private static void output(StringBuilder result) {
    System.out.print(result.toString());
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    T = Integer.parseInt(br.readLine());
    K = new int[T + 1];
    M = new int[T + 1];
    nodes = new HashMap[T + 1];

    for (int i = 1; i <= T; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      K[i] = Integer.parseInt(st.nextToken());
      M[i] = Integer.parseInt(st.nextToken());
      Integer P = Integer.parseInt(st.nextToken());

      nodes[i] = new HashMap<>();

      for (int j = 1; j <= M[i]; j++) {
        Node node = new Node(j, new ArrayList<>(), new ArrayList<>());
        nodes[i].put(j, node);
      }

      for (int j = 0; j < P; j++) {
        st = new StringTokenizer(br.readLine());
        Integer A = Integer.parseInt(st.nextToken());
        Integer B = Integer.parseInt(st.nextToken());

        Node ANode = nodes[i].get(A);
        Node BNode = nodes[i].get(B);
        ANode.nextNodes.add(BNode);
        BNode.prevNodes.add(ANode);
        nodes[i].put(A, ANode);
        nodes[i].put(B, BNode);
      }
    }

    br.close();
  }

  private static StringBuilder Solution() {
    StringBuilder sb = new StringBuilder();
    for (int t = 1; t <= T; t++) {
      depth = new int[M[t] + 1];
      Integer result = getDepth(t, M[t]);
      sb.append(K[t]).append(" ").append(result).append("\n");
    }
    return sb;
  }

  private static Integer getDepth(int t, int current) {
    if (depth[current] != 0) {
      return depth[current];
    }

    if (nodes[t].get(current).prevNodes.isEmpty()) {
      depth[current] = 1;
      nodes[t].get(current).depth = 1;
      return 1;
    }

    Integer maxDepth = -1;
    Integer count = 0;
    for (int j = 0; j < nodes[t].get(current).prevNodes.size(); j++) {
      Integer depth = getDepth(t, nodes[t].get(current).prevNodes.get(j).index);
      if (maxDepth < depth) {
        maxDepth = depth;
        count = 1;
      } else if (maxDepth.equals(depth)) {
        count++;
      }
    }

    if (count >= 2) {
      depth[current] = maxDepth + 1;
    } else {
      depth[current] = maxDepth;
    }

    return depth[current];
  }

  private static class Node {

    int index;
    int depth;
    ArrayList<Node> prevNodes;
    ArrayList<Node> nextNodes;

    public Node(int index, ArrayList<Node> prevNodes, ArrayList<Node> nextNodes) {
      this.index = index;
      this.prevNodes = prevNodes;
      this.nextNodes = nextNodes;
    }
  }

}
