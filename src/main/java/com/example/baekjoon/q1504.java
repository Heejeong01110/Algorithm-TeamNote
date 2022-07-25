package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class q1504 {

  private static int N;
  private static int E;
  private static ArrayList<Node>[] nodes;
  private static int[] layover;

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
    E = Integer.parseInt(st.nextToken());

    nodes = new ArrayList[N + 1];
    for (int i = 1; i <= N; i++) {
      nodes[i] = new ArrayList<>();
    }

    for (int i = 0; i < E; i++) {
      st = new StringTokenizer(br.readLine());
      int one = Integer.parseInt(st.nextToken());
      int two = Integer.parseInt(st.nextToken());
      int three = Integer.parseInt(st.nextToken());

      nodes[one].add(new Node(two, three));
      nodes[two].add(new Node(one, three));
    }

    layover = new int[2];
    st = new StringTokenizer(br.readLine());
    layover[0] = Integer.parseInt(st.nextToken());
    layover[1] = Integer.parseInt(st.nextToken());

    br.close();
  }

  private static int Solution() {
    int[] v1 = dijkstra(layover[0]);
    int[] v2 = dijkstra(layover[1]);

    if (v1[1] == Integer.MAX_VALUE || v1[N] == Integer.MAX_VALUE
        || v1[layover[1]] == Integer.MAX_VALUE) {
      return -1;
    }

    int result = 0;
    if (v1[1] + v2[N] > v2[1] + v1[N]) {
      result += v2[1] + v1[N];
    } else {
      result += v1[1] + v2[N];
    }

    int min = v1[layover[1]];
    for (int i = 1; i <= N; i++) {
      min = Math.min(v1[i] + v2[i], min);
    }
    result += min;
    return result;
  }

  private static int[] dijkstra(int start) {
    int[] cost = new int[N + 1];
    PriorityQueue<Node> queue = new PriorityQueue<>(
        Comparator.comparingInt(o -> o.cost));

    for (int i = 1; i < cost.length; i++) {
      cost[i] = Integer.MAX_VALUE;
    }

    cost[start] = 0;
    queue.add(new Node(start, 0));

    while (!queue.isEmpty()) {
      //1. 최소 비용의 노드 선택
      Node now = queue.poll(); //기준점에서부터의 길이가 저장됨. 새로 생성하는 벡터

      //모든 정점 방문 시 종료

      if (cost[now.index] < now.cost) { //스킵
        continue;
      }

      //2. 기준점 이웃 노드 중 최소값 구하기
      for (int j = 0; j < nodes[now.index].size(); j++) {
        Node next = nodes[now.index].get(j); //커넥트 노드 선택

        if (cost[next.index] > now.cost + next.cost) {
          cost[next.index] = now.cost + next.cost;
          // 갱신된 경우에만 큐에 넣는다.
          queue.add(new Node(next.index, cost[next.index]));
        }
      }
    }

    return cost;
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
