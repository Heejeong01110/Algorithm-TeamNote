package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q2623 {

  private static int N;
  private static int M;
  private static ArrayList<Integer>[] list;
  private static Node[] nodes;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    System.out.print(Solution());
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    list = new ArrayList[M];
    for (int i = 0; i < list.length; i++) {
      list[i] = new ArrayList<>();
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int num = Integer.parseInt(st.nextToken());
      for (int j = 0; j < num; j++) {
        list[i].add(Integer.parseInt(st.nextToken()));
      }
    }

    br.close();
  }


  private static String Solution() {
    StringBuilder sb = new StringBuilder();
    nodes = new Node[N + 1];
    for (int i = 1; i <= N; i++) {
      nodes[i] = new Node(i, new ArrayList<>(), new ArrayList<>());
    }

    for (int i = 0; i < M; i++) {
      for (int j = 0; j < list[i].size() - 1; j++) {
        Integer par = list[i].get(j);
        Integer chi = list[i].get(j + 1);
        insertNodes(nodes[par], nodes[chi]);
      }
    }

    Queue<Node> waitQueue = new ArrayDeque<>();
    boolean check;
    int count = 0;
    boolean[] visited = new boolean[N + 1];
    while (true) {
      check = true;

      for (int i = 1; i <= N; i++) {
        if (nodes[i].input.isEmpty() && !visited[i]) {
          check = false;
          waitQueue.add(nodes[i]);
          visited[i] = true;
          sb.append(i).append("\n");
          count++;

          int size = nodes[i].output.size();
          for (int j = 0; j < size; j++) {
            Node remove = nodes[i].output.get(0);
            nodes[i].output.remove(remove);
            remove.input.remove(nodes[i]);
          }
        }
      }

      if (check) {
        if (count != N) {
          return "0";
        }
        break;
      }
    }

    return sb.toString();
  }

  private static void insertNodes(Node parent, Node child) {
    parent.output.add(child);
    child.input.add(parent);
  }

  private static class Node {

    int index;
    ArrayList<Node> input;
    ArrayList<Node> output;

    public Node(int index, ArrayList<Node> input, ArrayList<Node> output) {
      this.index = index;
      this.input = input;
      this.output = output;
    }
  }


}
