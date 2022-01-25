package com.example.algorithm.Graph;

import java.util.Stack;

public class DoublyLinkedList { //s81303 참고
  static Stack<Node> deleteNode;
  public static String solution(int n, int k) {
    // n : 노드 개수
    // k : 처음에 선택된 행의 위치
    String answer = "";
    deleteNode = new Stack<>();
    Node[] nodes = new Node[n];

    for (int i = 0; i < n; i++) {
      nodes[i] = new Node();
      nodes[i].index = i;
    }

    for (int i = 1; i < n; i++) {
      nodes[i].prev = nodes[i - 1];
      nodes[i - 1].next = nodes[i];
    }

    Node currentNode = nodes[k];

    deleteNode(currentNode);
    repairNode();

    return answer;
  }

  private static void repairNode() {
    //노드 원상복구
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

  private static void deleteNode(Node currentNode) {
    //노드 삭제
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


  static class Node {
    int index;
    boolean removed;
    Node prev;
    Node next;
  }
}
