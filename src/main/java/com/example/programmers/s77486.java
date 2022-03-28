package com.example.programmers;

import java.util.HashMap;

public class s77486 {

  public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
    HashMap<String, Node> nodes = new HashMap<>();

    for (int i = 0; i < enroll.length; i++) {
      nodes.put(enroll[i], new Node(i, enroll[i], null));
    }

    for (int i = 0; i < enroll.length; i++) {
      Node parent;
      if (referral[i].equals( "-")) {
        parent = null;
      } else {
        parent = nodes.get(referral[i]);
      }

      if (nodes.containsKey(enroll[i])) {
        nodes.get(enroll[i]).index = i;
        nodes.get(enroll[i]).parent = parent;
      }
    }

    int[] result = new int[nodes.size()];
    Node now;
    int nowAmount;

    for (int i=0;i<seller.length;i++) {
      now = nodes.get(seller[i]);
      nowAmount = amount[i] * 100;

      while (now.parent != null) {
        result[now.index] += (nowAmount - nowAmount / 10);
        nowAmount = nowAmount / 10;
        now = now.parent;
      }
      result[now.index] += (nowAmount - nowAmount / 10);
    }

    return result;
  }

  private static class Node {

    int index;
    String name;
    Node parent;

    public Node(int index, String name, Node parent) {
      this.index = index;
      this.name = name;
      this.parent = parent;
    }
  }
}
