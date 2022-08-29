package com.example.programmers;

import java.util.HashMap;
import java.util.Map;

public class s60060 {

  private static Trie front;
  private static Trie back;

  public static int[] solution(String[] words, String[] queries) {
    front = new Trie();
    back = new Trie();
    for (String word : words) {
      front.insert(word);
      back.insert(reverseWord(word));
    }

    int[] answer = new int[queries.length];
    for (int i = 0; i < queries.length; i++) {
      if (queries[i].charAt(0) == '?') {
        answer[i] = back.find(reverseWord(queries[i]), 0);
      } else {
        answer[i] = front.find(queries[i], 0);
      }
    }

    return answer;
  }

  private static String reverseWord(String str) {
    return new StringBuilder(str).reverse().toString();
  }


  private static class Trie {

    Map<Integer, Integer> lenMap = new HashMap<>();
    Trie[] child = new Trie[26];//알파벳 갯수만큼 초기화

    void insert(String str) {
      Trie node = this;
      int len = str.length();

      lenMap.put(len, lenMap.getOrDefault(len, 0) + 1);

      for (int i = 0; i < len; i++) {
        char ch = str.charAt(i);
        int idx = ch - 'a';
        if (node.child[idx] == null) {
          node.child[idx] = new Trie();
        }

        node = node.child[idx];
        node.lenMap.put(len, node.lenMap.getOrDefault(len, 0) + 1);
      }
    }

    int find(String str, int strIdx) {
      if (str.charAt(strIdx) == '?') {
        return lenMap.getOrDefault(str.length(), 0);
      }

      int idx = str.charAt(strIdx) - 'a';
      if (child[idx] == null) {
        return 0;
      }
      return child[idx].find(str, strIdx + 1);
    }
  }
}
