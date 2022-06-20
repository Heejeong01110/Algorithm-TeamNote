package com.example.algorithm.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

//위상정렬
//사이클이 없는 방향 그래프가 있을 때 전체 작업 순서를 정렬하는 알고리즘
public class topologySort {

  private static ArrayList<Integer>[] nodes;
  private static int[] degree;
  private static int N;
  private static int[] times;

  public static void main(String[] args) {
    int[][] fares = new int[][]{{1, 4}, {4, 3}, {6, 2}, {2, 5},
        {5, 4}, {2, 3}};
    times = new int[]{5, 10, 4, 7, 15, 2};
    N = 6;
    degree = new int[N + 1];

    nodes = new ArrayList[N + 1];
    for (int i = 0; i < nodes.length; i++) {
      nodes[i] = new ArrayList<>();
    }
    for (int i = 0; i < fares.length; i++) {
      int one = fares[i][0];
      int two = fares[i][1];
      nodes[one].add(two);
      degree[two]++;
    }

    topology();

  }

  private static void topology() {

    Queue<Integer> queue = new ArrayDeque<>();
    Queue<Integer> result = new ArrayDeque<>();
    int[] resultValue = new int[N + 1]; //최소 소요시간
    
    // 차수가 0인 정점 큐에 넣기
    for (int i = 1; i <= N; i++) {
      if (degree[i] == 0) {
        queue.add(i);
      }
    }

    while (!queue.isEmpty()) {
      int now = queue.poll();
      result.add(now);

      for (int next : nodes[now]) {
        degree[next]--;

        resultValue[next] = Math.max(resultValue[next], resultValue[now] + times[now]);
        if (degree[next] == 0) {
          queue.add(next);
        }
      }
    }
    System.out.println(result);

  }
}
