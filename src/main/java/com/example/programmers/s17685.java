package com.example.programmers;

import java.util.HashMap;
import java.util.Map;

public class s17685 {

  public static int solution(String[] words) {

    Trie trie = new Trie();
    for (String word : words) {
      trie.insert(word);
    }

    int answer = 0;
    for (String word : words) {
      answer += trie.getMinTypingCount(word);
    }

    return answer;
  }

  private static class Node {

    public Map<Character, Node> childNodes = new HashMap(); // 하위 문자 관리
    public int count; // 하위 단어들의 수
    public boolean isLast; // 마지막 문자인가?
  }

  private static class Trie {

    Node root;

    public Trie() {
      this.root = new Node();
    }

    void insert(String word) {
      Node node = this.root;

      // 첫번째 문자부터 하위로 가면서, 파생단어의 수와 마지막 단어임을 기록
      for (int i = 0; i < word.length(); i++) {
        node.count++;
        node = node.childNodes.computeIfAbsent(word.charAt(i), c -> new Node());
      }
      node.count++;
      node.isLast = true;
    }

    int getMinTypingCount(String word) {
      Node node = this.root;

      int length = word.length();
      int last = length;

      for (int i = 0; i < length; i++) {
        // 남은 하위 단어가 1개라면, 현재 입력으로 결정된다
        if (node.count == 1) {
          last = i;
          break;
        }
        node = node.childNodes.get(word.charAt(i));
      }
      return last;
    }
  }


}
