package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q5639 {

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    Solution();
  }

  private static void Solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Node root = new Node(Integer.parseInt(br.readLine()));

    while (true) {
      String str = br.readLine();
      if (str == null || str.equals("")) {
        break;
      }
      int val = Integer.parseInt(str);
      root.insert(val);
    }

    postOrder(root);
    br.close();
  }

  private static void postOrder(Node node) {
    if (node == null) {
      return;
    }

    postOrder(node.left);
    postOrder(node.right);
    System.out.print(node.idx + "\n");
  }

  private static class Node {

    int idx;
    Node left;
    Node right;

    public Node(int idx) {
      this.idx = idx;
    }

    private void insert(int n) {
      if (n < this.idx) {
        if (this.left == null) {
          this.left = new Node(n);
        } else {
          this.left.insert(n);
        }
      } else {
        if (this.right == null) {
          this.right = new Node(n);
        } else {
          this.right.insert(n);
        }
      }
    }
  }

}
