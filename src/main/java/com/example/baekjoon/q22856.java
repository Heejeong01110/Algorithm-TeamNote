package com.example.baekjoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q22856 {

  private static int N;
  private static int result;
  private static int lastIdx;
  private static Node[] nodes;
  private static TreeN[] treeNs;

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
    nodes = new Node[N + 1];
    treeNs = new TreeN[N + 1];

    for (int i = 1; i <= N; i++) {
      nodes[i] = new Node(i, -1, -1);
      treeNs[i] = new TreeN(i);
    }

    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      int one = Integer.parseInt(st.nextToken());
      int two = Integer.parseInt(st.nextToken());
      int thr = Integer.parseInt(st.nextToken());

      nodes[one].left = two;
      nodes[one].right = thr;

      if (two != -1) {
        nodes[two].parent = one;
      }

      if (thr != -1) {
        nodes[thr].parent = one;
      }

      treeNs[one].left = two != -1 ? treeNs[two] : null;
      treeNs[one].right = thr != -1 ? treeNs[thr] : null;
    }

    br.close();
  }

  private static int Solution() {
    inOrder(treeNs[1]);
    dfs(1, new boolean[N + 1][2], 0);
    return 0;
  }

  private static void dfs(int now, boolean[][] visited, int count) {
    if (!visited[now][0] && nodes[now].left != -1) {//왼
      visited[now][0] = true;
      dfs(nodes[now].left, visited, count + 1);
    } else if (!visited[now][1] && nodes[now].right != -1) {//오른
      visited[now][1] = true;
      dfs(nodes[now].right, visited, count + 1);
    } else if (nodes[now].parent != -1) {//모두 방문
      if (now == lastIdx) {
        System.out.println(count);
        System.exit(0);
        return;
      }
      dfs(nodes[now].parent, visited, count + 1);
    }
  }

  private static void inOrder(TreeN node) {
    if (node != null) {
      inOrder(node.left);
      lastIdx = node.index;
      inOrder(node.right);
    }
  }


  private static class Node {

    int index;
    int parent;
    int left;
    int right;

    public Node(int index, int left, int right) {
      this.index = index;
      this.left = left;
      this.right = right;
    }
  }

  private static class TreeN {

    int index;
    TreeN left;
    TreeN right;

    public TreeN(int index) {
      this.index = index;
    }
  }

}
