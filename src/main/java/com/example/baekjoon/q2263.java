package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q2263 {

  private static int N;
  private static int[] inOrder;
  private static int[] postOrder;
  private static Node[] nodes;

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
    inOrder = new int[N];
    postOrder = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      inOrder[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      postOrder[i] = Integer.parseInt(st.nextToken());
    }

    br.close();
  }

  private static int Solution() {
    nodes = new Node[N + 1];
    for (int i = 1; i <= N; i++) {
      nodes[i] = createNode(null, i, null);
    }
    for (int i = 0; i < inOrder.length; i++) {
      if (inOrder[i] == postOrder[i]) {

      } else {
        int index = 0;

        while(inOrder[i] != postOrder[i + index]){
          if(inOrder[i] == postOrder[i + index]){
            break;
          }




          index++;
        }

        i += index;
      }

    }

    return 0;
  }

  private static Node createNode(Node left, int data, Node right) {
    Node node = new Node(data);
    node.left = left;
    node.right = right;

    return node;
  }

  private static class Node {

    int data;
    Node left;
    Node right;

    public Node(int data) {
      this.data = data;
    }
  }

}
