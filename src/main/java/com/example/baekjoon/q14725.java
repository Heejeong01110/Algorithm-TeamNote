package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;

public class q14725 {

  private static final String dash = "--";
  private static int N;
  private static HashMap<Node, ArrayList<Node>> nodes;
  private static StringBuilder sb;


  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    N = Integer.parseInt(br.readLine());
    nodes = new HashMap<>();

    Node oldKey;
    ArrayList<Node> oldValue;
    Node newKey;
    ArrayList<Node> newValue;
    for (int t = 0; t < N; t++) {
      st = new StringTokenizer(br.readLine());

      int count = Integer.parseInt(st.nextToken());
      newKey = new Node(st.nextToken(), 0, null);
      newValue = nodes.getOrDefault(newKey, new ArrayList<>());
      if (!nodes.containsKey(newKey)) {
        nodes.put(newKey, newValue);
      }

      for (int i = 1; i < count; i++) {
        oldKey = newKey;
        oldValue = newValue;

        newKey = new Node(st.nextToken(), i, oldKey);
        newValue = nodes.getOrDefault(newKey, new ArrayList<>());
        if (!nodes.containsKey(newKey)) {
          nodes.put(newKey, newValue);
        }

        oldValue.add(newKey);
        nodes.put(oldKey, oldValue);

      }
    }

    List<Map.Entry<Node, ArrayList<Node>>> entryList = new LinkedList<>(nodes.entrySet());
    entryList.sort((o1, o2) -> {
      if (o1.getKey().depth != o2.getKey().depth) {
        return o1.getKey().depth - o2.getKey().depth;
      }
      return o1.getKey().name.compareTo(o2.getKey().name);
    });

    sb = new StringBuilder();

    for (int t = 0; t < entryList.size(); t++) {
      if (entryList.get(t).getKey().depth == 0) {
        dfs(entryList, t);
      }
    }

    System.out.print(sb.toString());
    br.close();
  }

  private static void dfs(List<Map.Entry<Node, ArrayList<Node>>> entryList, Integer key) {

    sb.append(dash.repeat(entryList.get(key).getKey().depth));
    sb.append(entryList.get(key).getKey().name).append("\n");


    for (int i = 0; i < entryList.size(); i++) {
      if(entryList.get(key).getValue().contains(entryList.get(i).getKey())){
        dfs(entryList, i);
      }
    }


  }


  private static class Node {

    String name;
    int depth;
    Node parent;


    public Node(String name, int depth, Node parent) {
      this.name = name;
      this.depth = depth;
      this.parent = parent;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof Node)) {
        return false;
      }
      Node node = (Node) o;
      return depth == node.depth && name.equals(node.name)
          && Objects.equals(parent, node.parent);
    }

    @Override
    public int hashCode() {
      return Objects.hash(name, depth, parent);
    }
  }

}
