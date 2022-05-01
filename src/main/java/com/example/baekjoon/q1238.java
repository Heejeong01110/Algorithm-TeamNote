package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class q1238 {

  private static int N;
  private static int M;
  private static int X;

  private static HashMap<Integer, ArrayList<CustomVextor>> nodes;
  private static HashMap<Integer, ArrayList<CustomVextor>> reverseNodes;


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
    X = Integer.parseInt(st.nextToken());

    nodes = new HashMap<>();
    reverseNodes = new HashMap<>();
    for (int i = 1; i <= N; i++) {
      nodes.put(i, new ArrayList<>());
      reverseNodes.put(i, new ArrayList<>());
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int one = Integer.parseInt(st.nextToken());
      int two = Integer.parseInt(st.nextToken());
      int three = Integer.parseInt(st.nextToken());
      nodes.get(one).add(new CustomVextor(two, three));
      reverseNodes.get(two).add(new CustomVextor(one, three));
    }

    br.close();
  }

  private static int Solution() {

    int[] list = getListDijkstra(nodes);
    int[] reverseList = getListDijkstra(reverseNodes);

    int result = 0;
    for (int i = 1; i <= N; i++) {
      result = Math.max(result, list[i] + reverseList[i]);
    }
    return result;
  }

  private static int[] getListDijkstra(HashMap<Integer, ArrayList<CustomVextor>> nodes) {
    int[] cost = new int[nodes.size() + 1];
    PriorityQueue<CustomVextor> minCostQueue = new PriorityQueue<>(
        Comparator.comparingInt(o -> o.cost));

    for (int i = 0; i < cost.length; i++) {
      cost[i] = Integer.MAX_VALUE;
    }

    cost[X] = 0;
    minCostQueue.add(new CustomVextor(X, 0));

    while (!minCostQueue.isEmpty()) {
      //1. 최소 비용의 노드 선택
      CustomVextor currentVextor = minCostQueue.poll(); //기준점에서부터의 길이가 저장됨. 새로 생성하는 벡터
      int currentIndex = currentVextor.index;

      //모든 정점 방문 시 종료

      if (cost[currentIndex] < currentVextor.cost) { //스킵
        continue;
      }

      //2. 기준점 이웃 노드 중 최소값 구하기
      for (int j = 0; j < nodes.get(currentIndex).size(); j++) {
        CustomVextor connectVex = nodes.get(currentIndex).get(j); //커넥트 노드 선택

        if (cost[connectVex.index] > currentVextor.cost + connectVex.cost) {
          cost[connectVex.index] = currentVextor.cost + connectVex.cost;
          // 갱신된 경우에만 큐에 넣는다.
          minCostQueue.add(new CustomVextor(connectVex.index, cost[connectVex.index]));
        }
      }
    }

    return cost;
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
