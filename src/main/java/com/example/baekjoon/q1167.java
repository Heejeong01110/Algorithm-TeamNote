package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class q1167 {

  private static int V;
  private static int result;
  private static int maxNodeIdx;
  private static HashMap<Integer, ArrayList<CustomVextor>> nodes;

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

    V = Integer.parseInt(br.readLine());
    nodes = new HashMap<>();
    for (int i = 1; i <= V; i++) {
      nodes.put(i, new ArrayList<>());
    }

    StringTokenizer st;
    for (int i = 0; i < V; i++) {
      st = new StringTokenizer(br.readLine());

      int one = Integer.parseInt(st.nextToken());

      int line = Integer.parseInt(st.nextToken());
      while (line != -1) {
        int three = Integer.parseInt(st.nextToken());
        nodes.get(one).add(new CustomVextor(line, three));

        line = Integer.parseInt(st.nextToken());
      }
    }

    br.close();
  }

  private static int Solution() {
    result = 0;
    maxNodeIdx = 1;
    boolean[] visited = new boolean[V + 1];

    visited[1] = true;
    dfs(1, 0, visited);
    visited[1] = false;

    visited[maxNodeIdx] = true;
    dfs(maxNodeIdx, 0, visited);
    visited[maxNodeIdx] = false;

    return result;
  }

  private static void dfs(int now, int cost, boolean[] visited) {
    //근접한 노드에 모두 방문 했을 때, 마지막 노드일 때
    boolean isEnding = true;

    for (int i = 0; i < nodes.get(now).size(); i++) {
      if (!visited[nodes.get(now).get(i).index]) {
        isEnding = false;
      }
    }

    if (isEnding) {
      if (result < cost) {
        result = cost;
        maxNodeIdx = now;
      }

      return;
    }

    for (int i = 0; i < nodes.get(now).size(); i++) {
      int next = nodes.get(now).get(i).index;

      if (!visited[next]) {
        visited[next] = true;
        dfs(next, cost + nodes.get(now).get(i).cost, visited);
        visited[next] = false;
      }
    }


  }


  private static class CustomVextor {

    int index; //이어진 index
    int cost; //요금

    public CustomVextor(int index, int cost) {
      this.index = index;
      this.cost = cost;
    }
  }

}
