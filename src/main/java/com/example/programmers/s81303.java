package com.example.programmers;

import java.util.Stack;

public class s81303 {

  //표 편집
  public static String solution(int n, int k, String[] cmd) {
    // n : 표의 행 개수
    // k : 처음에 선택된 행의 위치

    Node[] nodes = new Node[n];
    for (int i = 0; i < n; i++) {
      nodes[i] = new Node();
    }

    for (int i = 1; i < n; i++) {
      nodes[i].prev = nodes[i - 1];
      nodes[i - 1].next = nodes[i];
    }

    Stack<Node> deleteNode = new Stack<>();
    Node currentNode = nodes[k];

    for (int i = 0; i < cmd.length; i++) {
      String[] split = cmd[i].split(" ");

      switch (split[0]) {
        case "U" -> {
          for (int j = 0; j < Integer.parseInt(split[1]); j++) {
            currentNode = currentNode.prev;
          }
        }
        case "D" -> {
          for (int j = 0; j < Integer.parseInt(split[1]); j++) {
            currentNode = currentNode.next;
          }
        }
        case "C" -> {
          currentNode.removed = true;
          deleteNode.push(currentNode);

          Node prev = currentNode.prev;
          Node next = currentNode.next;

          if (prev != null) {
            prev.next = next;
          }

          if (next != null) {
            next.prev = prev;
            currentNode = next;
          } else {
            currentNode = prev;
          }
        }

        case "Z" -> {
          Node repair = deleteNode.pop();

          Node prev = repair.prev;
          Node next = repair.next;

          repair.removed = false;
          if (prev != null) {
            prev.next = repair;
          }

          if (next != null) {
            next.prev = repair;
          }
        }
      }

    }

    StringBuilder answer = new StringBuilder();

    for (int i = 0; i < n; i++) {
      if (nodes[i].removed) {
        answer.append("X");
      } else {
        answer.append("O");
      }
    }

    return answer.toString();
  }

  private static class Node {

    boolean removed;
    Node prev;
    Node next;
  }
}
