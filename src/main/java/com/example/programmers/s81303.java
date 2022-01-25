package com.example.programmers;

import java.util.Stack;

public class s81303 {

  //표 편집
  public static String solution(int n, int k, String[] cmd) {
    // n : 표의 행 개수
    // k : 처음에 선택된 행의 위치
    String answer = "";

    Node[] nodes = new Node[n];
    for (int i = 0; i < n; i++) {
      nodes[i] = new Node();
      nodes[i].index = i;
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

          Node prev = currentNode.prev;
          if(prev != null){
            prev.next = currentNode.next;
          }
          Node next = currentNode.next;
          if(next != null){
            next.prev = currentNode.prev;
            deleteNode.push(currentNode);
            currentNode = next;
          }else{
            deleteNode.push(currentNode);
            currentNode = prev;
          }
        }

        case "Z" -> {
          Node repair = deleteNode.pop();

          repair.removed = false;

          Node prev = repair.prev;
          if(prev != null){
            prev.next = repair;
          }
          Node next = repair.next;
          if(next != null){
            next.prev = repair;
          }
        }
      }

    }

    for (int i = 0; i < n; i++) {
      if (nodes[i].removed) {
        answer += "X";
      } else {
        answer += "O";
      }
    }

    return answer;
  }

  static class Node {
    int index;
    boolean removed;
    Node prev;
    Node next;
  }
}
