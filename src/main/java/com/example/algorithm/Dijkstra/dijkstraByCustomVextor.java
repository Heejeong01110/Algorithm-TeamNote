package com.example.algorithm.Dijkstra;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class dijkstraByCustomVextor {

  private static HashMap<Integer, ArrayList<CustomVextor>> nodes;

  public static void main(String[] args) {
    int[][] fares = new int[][]{{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24},
        {4, 6, 50},
        {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
    int start = 4;
    int end = 6;
    int allNode = 6; //노드 갯수

    nodes = new HashMap<>();
    for (int i = 1; i <= allNode; i++) {
      nodes.put(i, new ArrayList<>());
    }

    for (int i = 0; i < fares.length; i++) {
      nodes.get(fares[i][0]).add(new CustomVextor(fares[i][1], fares[i][2]));
      nodes.get(fares[i][1]).add(new CustomVextor(fares[i][0], fares[i][2]));
    }

    System.out.println(dijkstra(start, end));

  }

  static int dijkstra(int start, int end) {
    int[] cost = new int[nodes.size()+1];
    PriorityQueue<CustomVextor> minCostQueue = new PriorityQueue<>(
        Comparator.comparingInt(o -> o.cost));

    for (int i = 0; i < cost.length; i++) {
      cost[i] = Integer.MAX_VALUE;
    }

    cost[start] = 0;
    minCostQueue.add(new CustomVextor(start, 0));

    while (!minCostQueue.isEmpty()) {
      //1. 최소 비용의 노드 선택
      CustomVextor currentVextor = minCostQueue.poll(); //기준점에서부터의 길이가 저장됨. 새로 생성하는 벡터
      int currentIndex = currentVextor.index;

      if (currentIndex == end) { //end 지점 도착시 함수 종료
        return cost[currentIndex];
      }

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

    return cost[end];
  }

  static class CustomVextor {

    int index; //이어진 index
    int cost; //요금

    public CustomVextor(int index, int cost) {
      this.index = index;
      this.cost = cost;
    }
  }
}
