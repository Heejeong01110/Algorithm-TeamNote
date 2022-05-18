package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class q13905 {

  private static int N;
  private static int M;
  private static int Start;
  private static int End;
  private static ArrayList<Node>[] nodes;

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

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    Start = Integer.parseInt(st.nextToken());
    End = Integer.parseInt(st.nextToken());

    nodes = new ArrayList[N + 1];
    for (int i = 1; i <= N; i++) {
      nodes[i] = new ArrayList<Node>();
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int one = Integer.parseInt(st.nextToken());
      int two = Integer.parseInt(st.nextToken());
      int cost = Integer.parseInt(st.nextToken());

      nodes[one].add(new Node(two, cost));
      nodes[two].add(new Node(one, cost));
    }

    br.close();
  }

  private static int Solution() {
    int answer = 0;

    PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o2.cost - o1.cost);
    boolean[] visited = new boolean[N + 1];
    int[] minScore = new int[N + 1];
    minScore[Start] = Integer.MAX_VALUE;

    ArrayList<Integer> nodeList = new ArrayList<>();
    nodeList.add(Start);
    queue.add(new Node(Start, 0));

    while (!queue.isEmpty()) {
      Node now = queue.poll();
      if (visited[now.index]) {
        continue;
      }

      visited[now.index] = true;

      for (int i = 0; i < nodes[now.index].size(); i++) {
        Node next = nodes[now.index].get(i);
        minScore[next.index] = Math.max(minScore[next.index],
            Math.min(minScore[now.index], next.cost));
        queue.add(next);
      }
    }
    answer = minScore[End];
    return answer;
  }

  private static class Node {

    int index;
    int cost;

    public Node(int index, int cost) {
      this.index = index;
      this.cost = cost;
    }
  }

}
