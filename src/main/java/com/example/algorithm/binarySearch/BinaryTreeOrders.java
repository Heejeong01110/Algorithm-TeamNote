package com.example.algorithm.binarySearch;

public class BinaryTreeOrders {

  private static Node root; //초기 root는 null

  public static void main(String[] args) {
    Node n10 = createNode(null, 10, null);
    Node n11 = createNode(null, 11, null);
    Node n5 = createNode(null, 5, null);
    Node n6 = createNode(null, 6, null);
    Node n7 = createNode(null, 7, null);
    Node n8 = createNode(null, 8, null);
    Node n4 = createNode(n6, 4, n7);
    Node n9 = createNode(n10, 9, n11);
    Node n2 = createNode(n4, 2, n5);
    Node n3 = createNode(n8, 3, n9);
    Node n1 = createNode(n2, 1, n3);

    /*
     *         1
     *    2         3
     *  4   5     8    9
     * 6 7      10 11
     *
     *
     * */
    root = n1;
    inOrder(n1);
    System.out.println("");

    preOrder(n1);
    System.out.println("");

    postOrder(n1);

  }


  private static Node createNode(Node left, int data, Node right) {
    Node node = new Node(data);
    node.left = left;
    node.right = right;

    return node;
  }

  //중위 순회 Inorder = Left -> Root -> Right
  //4 -> 2 -> 5 -> 1 -> 3
  private static void inOrder(Node node) {
    if (node != null) {
      inOrder(node.left);
      System.out.print(node.data + " ");
      inOrder(node.right);
    }
  }

  //전위순회 Preorder = Root -> Left -> Right
  //1 -> 2 -> 4 -> 5 -> 3
  private static void preOrder(Node node) {
    if (node != null) {
      System.out.print(node.data + " ");
      preOrder(node.left);
      preOrder(node.right);
    }
  }

  //후위순회 Postorder = Left -> Right -> Root
  //4 -> 5 -> 2 -> 3 -> 1
  private static void postOrder(Node node) {
    if (node != null) {
      preOrder(node.left);
      preOrder(node.right);
      System.out.print(node.data + " ");
    }
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
