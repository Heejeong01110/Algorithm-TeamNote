package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q13905 {

  private static int N;
  private static int M;
  private static int Start;
  private static int End;

  //kruskal
  private static int parents[];
  private static Edge[] edgeList;

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

    edgeList = new Edge[M];
    parents = new int[N + 1];

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int one = Integer.parseInt(st.nextToken());
      int two = Integer.parseInt(st.nextToken());
      int cost = Integer.parseInt(st.nextToken());

      edgeList[i] = new Edge(one, two, cost);
    }

    br.close();
  }

  private static int Solution() {
    int answer = kruskal();
    return answer;
  }

  private static int kruskal() {
    int minCost = 0;

    Arrays.sort(edgeList, ((o1, o2) -> o2.cost - o1.cost));

    // 정점 초기화
    for (int i = 1; i <= N; i++) {
      parents[i] = i;
    }

    // 주어진 간선을 이어보면서
    for (Edge edge : edgeList) {
      if (union(edge.start, edge.end)) {// 부모가 다를 경우
        minCost = edge.cost;

        if (find(Start) == find(End)) { //모두 이어져 있을 경우 종료
          return minCost;
        }
      }
    }

    return 0;
  }

  private static boolean union(int a, int b) {
    int aRoot = find(a);
    int bRoot = find(b);

    if (aRoot == bRoot) {
      return false;
    }
    parents[aRoot] = bRoot;
    return true;
  }

  private static int find(int a) {
    if (a == parents[a]) {
      return a;
    }
    return parents[a] = find(parents[a]);
  }

  private static class Edge {

    int start;
    int end;
    int cost;

    public Edge(int start, int end, int cost) {
      this.start = start;
      this.end = end;
      this.cost = cost;
    }
  }

}
