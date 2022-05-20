package com.example.algorithm.Graph;

import java.util.HashMap;
import java.util.Map;

//Trie는 다수의 문자열을 한 단어씩 노드에 저장하는 트리. 문자열 정렬
//다음 단어로 뭐가 나오는지에 따라 tree가 생성됨
public class Trie {

  private static Node rootNode;

  public static void main(String[] args) {
    rootNode = new Node(new HashMap<>(), false);

    insert("structure");
    insert("structures");
    insert("ride");
    insert("riders");
    insert("stress");
    insert("solstice");
    insert("ridiculous");

    System.out.println(search("rid"));
    System.out.println(search("stress"));

  }

  // Trie에 문자열 저장
  private static void insert(String str) {
    Node node = rootNode; // Trie자료구조는 항상 rootNode부터 시작

    for (int i = 0; i < str.length(); i++) {// 문자열의 각 단어마다 가져와서 자식노드 중에 있는지 체크
      node = node.chiledNode.computeIfAbsent(str.charAt(i),
          key -> new Node(new HashMap<>(), false));// 없으면 자식노드 새로 생성
    }

    node.endOfword = true;//저장 할 문자열의 마지막 단어에 매핑되는 노드에 단어의 끝임을 명시
  }

  // Trie에서 문자열 검색
  private static boolean search(String str) {
    Node node = rootNode; // Trie자료구조는 항상 rootNode부터 시작

    for (int i = 0; i < str.length(); i++) {// 문자열의 각 단어마다 노드가 존재하는지 체크
      node = node.chiledNode.getOrDefault(str.charAt(i), null);

      if (node == null) {// node가 null이면 현재 Trie에 해당 문자열은 없음
        return false;
      }
    }

    return node.endOfword;//마지막 글자의 노드가 end일 경우만 참
  }


  private static class Node {

    Map<Character, Node> chiledNode;
    boolean endOfword;

    public Node(Map<Character, Node> chiledNode, boolean endOfword) {
      this.chiledNode = chiledNode;
      this.endOfword = endOfword;
    }
  }
}
