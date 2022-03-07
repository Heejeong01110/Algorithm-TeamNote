package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class q17471 {

  private static int N;
  private static HashMap<Integer, Node> nodes;
  private static int result;
  private static ArrayList<String> partMemo;


  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    output(Solution());
  }

  private static void output(int result) {
    System.out.print(result);
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    nodes = new HashMap<>();

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      nodes.put(i, new Node(i, Integer.parseInt(st.nextToken()), new ArrayList<>()));
    }
    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());

      int count = Integer.parseInt(st.nextToken());
      for (int j = 1; j <= count; j++) {
        nodes.get(i).neighbors.add(Integer.parseInt(st.nextToken()));
      }
    }

    br.close();
  }

  private static int Solution() {
    result = Integer.MAX_VALUE;
    partMemo = new ArrayList<>();
    HashMap<Integer, Node> memoMap = new HashMap<>();
    for (int i = 1; i <= N; i++) {
      memoMap.put(i, nodes.get(i));
      dfs(i, memoMap);
      memoMap.remove(i);
    }

    if (result == Integer.MAX_VALUE) {
      result = -1;
    }
    return result;
  }

  private static void dfs(int currentIndex, HashMap<Integer, Node> memo) {
    String listStr = "";
    List<Map.Entry<Integer, Node>> entryList = new LinkedList<>(memo.entrySet());
    entryList.sort(Comparator.comparingInt(Map.Entry::getKey));

    for (Map.Entry<Integer, Node> entry : entryList) {
      listStr = listStr + entry.getKey() + " ";
    }

    if (partMemo.contains(listStr)) {
      return;
    }

    partMemo.add(listStr);
    Integer a = 0;
    Integer b = 0;
    if (memo.size() > 0 && memo.size() < N) {
      if (isConnectB(memo)) {
        for (int i = 1; i <= N; i++) {
          if (memo.containsKey(i)) {
            a += memo.get(i).value;
          } else {
            b += nodes.get(i).value;
          }
        }

        int inter = Math.abs(a - b);
        result = Math.min(result, inter);
      }
    }

    for (int i = 0; i < nodes.get(currentIndex).neighbors.size(); i++) {
      if (!memo.containsKey(nodes.get(currentIndex).neighbors.get(i))) {
        memo.put(nodes.get(currentIndex).neighbors.get(i),
            nodes.get(nodes.get(currentIndex).neighbors.get(i)));
        dfs(nodes.get(currentIndex).neighbors.get(i), memo);
        memo.remove(nodes.get(currentIndex).neighbors.get(i));
      }
    }


  }

  private static boolean isConnectB(HashMap<Integer, Node> memo) {
    HashMap<Integer, Node> bNeighbors = new HashMap<>();
    Integer anyKey = -1;
    for (int i = 1; i <= N; i++) {
      if (!memo.containsKey(i)) {
        bNeighbors.put(i, nodes.get(i));
        anyKey = i;
      }
    }

    Queue<Node> queue = new ArrayDeque<>();
    boolean[] visited = new boolean[N + 1];

    queue.add(bNeighbors.get(anyKey));

    while (!queue.isEmpty()) {
      Node now = queue.poll();
      visited[now.index] = true;

      for (int j = 0; j < now.neighbors.size(); j++) {
        if (bNeighbors.containsKey(now.neighbors.get(j)) && !visited[now.neighbors.get(j)]) {
          queue.add(nodes.get(now.neighbors.get(j)));
        }
      }
    }
    for (int i = 1; i <= N; i++) {
      if (bNeighbors.containsKey(i) && !visited[i]) {
        return false;
      }
    }

    return true;
  }

  private static class Node {

    Integer index;
    Integer value;
    ArrayList<Integer> neighbors;

    public Node(int index, int value, ArrayList<Integer> neighbors) {
      this.index = index;
      this.value = value;
      this.neighbors = neighbors;
    }
  }

}
