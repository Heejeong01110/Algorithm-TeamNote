package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class q5670 {

  private static Node rootNode;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();

    int N = 0;

    while (str != null) {
      N = Integer.parseInt(str);
      String[] dict = new String[N];
      for (int i = 0; i < N; i++) {
        dict[i] = br.readLine();
      }

      System.out.println(solution(N, dict));

      str = br.readLine();
    }
    br.close();
  }

  private static String solution(int N, String[] dict) {
    rootNode = new Node(new HashMap<>(), false);

    for (int i = 0; i < N; i++) {
      insert(dict[i]);
    }

    double sum = 0;
    for (int i = 0; i < N; i++) {
      sum += calc(dict[i]);
    }

    double avg = sum / N;

    return String.format("%.2f", avg);
  }

  private static void insert(String str) {
    Node node = rootNode;

    for (int i = 0; i < str.length(); i++) {
      node = node.chiledNode.computeIfAbsent(str.charAt(i),
          key -> new Node(new HashMap<>(), false));// 없으면 자식노드 새로 생성
    }

    node.endOfword = true;
  }

  private static double calc(String str) {
    Node node = rootNode;
    double count = 1;
    node = node.chiledNode.getOrDefault(str.charAt(0), null);

    for (int i = 1; i < str.length(); i++) {// 문자열의 각 단어마다 노드가 존재하는지
      if (node.chiledNode.size() >= 2) {
        count++;
      } else if (node.endOfword && node.chiledNode.size() == 1) {
        count++;
      }
      node = node.chiledNode.getOrDefault(str.charAt(i), null);

    }

    return count;
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
