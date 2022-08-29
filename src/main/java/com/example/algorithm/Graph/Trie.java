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

    Trie2 trie2 = new Trie2();
    trie2.insert("structure");
    trie2.insert("structures");
    trie2.insert("ride");
    trie2.insert("riders");
    trie2.insert("stress");
    trie2.insert("solstice");
    trie2.insert("ridiculous");

    System.out.println(trie2.find("rid", 0));
    System.out.println(trie2.find("stress", 0));
  }

  // Trie에 문자열 저장
  private static void insert(String str) {
    Node node = rootNode; // Trie자료구조는 항상 rootNode부터 시작

    for (int i = 0; i < str.length(); i++) {// 문자열의 각 단어마다 가져와서 자식노드 중에 있는지 체크
      node = node.childNode.computeIfAbsent(str.charAt(i),
          key -> new Node(new HashMap<>(), false));// 없으면 자식노드 새로 생성
    }

    node.endOfword = true;//저장 할 문자열의 마지막 단어에 매핑되는 노드에 단어의 끝임을 명시
  }

  // Trie에서 문자열 검색
  private static boolean search(String str) {
    Node node = rootNode; // Trie자료구조는 항상 rootNode부터 시작

    for (int i = 0; i < str.length(); i++) {// 문자열의 각 단어마다 노드가 존재하는지 체크
      node = node.childNode.getOrDefault(str.charAt(i), null);

      if (node == null) {// node가 null이면 현재 Trie에 해당 문자열은 없음
        return false;
      }
    }

    return node.endOfword;//마지막 글자의 노드가 end일 경우만 참
  }


  private static class Node {

    Map<Character, Node> childNode;
    boolean endOfword;

    public Node(Map<Character, Node> childNode, boolean endOfword) {
      this.childNode = childNode;
      this.endOfword = endOfword;
    }
  }


  private static class Trie2 {

    Map<Integer, Integer> lenMap = new HashMap<>();
    Trie2[] child = new Trie2[26];//알파벳 갯수만큼 초기화

    void insert(String str) {
      Trie2 node = this;
      int len = str.length();

      lenMap.put(len, lenMap.getOrDefault(len, 0) + 1);

      for (int i = 0; i < len; i++) {
        char ch = str.charAt(i);
        int idx = ch - 'a';
        if (node.child[idx] == null) {
          node.child[idx] = new Trie2();
        }

        node = node.child[idx];
        node.lenMap.put(len, node.lenMap.getOrDefault(len, 0) + 1);
      }
    }

    int find(String str, int strIdx) { //찾는 문자열 갯수 출력

      int idx = str.charAt(strIdx) - 'a';
      if (strIdx == str.length() - 1) {
        return lenMap.get(idx);
      }
      if (child[idx] == null) {
        return 0;
      }
      return child[idx].find(str, strIdx + 1);
    }
  }
}
