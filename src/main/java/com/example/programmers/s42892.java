package com.example.programmers;

import java.util.ArrayList;

// 길 찾기 게임
public class s42892 {

  private static Node root; //초기 root

  public static int[][] solution(int[][] nodeinfo) {
    int[][] answer = {};

    ArrayList<Node> nodes = new ArrayList<>();

    for (int i = 0; i < nodeinfo.length; i++) {
      nodes.add(new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]));
    }

    nodes.sort((o1, o2) -> {
      if (o1.level == o2.level) {
        return o2.value - o1.value;
      }
      return o1.level - o2.level;
    });

    root = nodes.get(0);
    int index = 1;

    for (int i = root.level - 1; i > 0; i--) {
      Node parent = nodes.get(index);
      Node current = nodes.get(index);
      while (current.level == i - 1) {

        index += 1;
        current = nodes.get(index);
      }

    }

    return answer;
  }

  private static class Node {

    int index;
    int value;
    int level;

    Node left;
    Node right;

    public Node(int index, int value, int level) {
      this.index = index;
      this.value = value;
      this.level = level;
    }
  }


}
