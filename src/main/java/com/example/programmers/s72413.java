package com.example.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

//합승 택시 요금
public class s72413 {

  private static HashMap<Integer, ArrayList<CustomVextor>> nodes;

  public static int solution(int n, int s, int a, int b, int[][] fares) {
    //n : 지점의 수 1 ~ n
    //s : 출발지점
    //a : 도착지점
    //fares : 지점 사이의 예상 택시요금
    nodes = new HashMap<>();
    for (int i = 1; i <= n; i++) {
      nodes.put(i, new ArrayList<>());
    }

    for (int[] fare : fares) {
      nodes.get(fare[0]).add(new CustomVextor(fare[1], fare[2]));
      nodes.get(fare[1]).add(new CustomVextor(fare[0], fare[2]));
    }

    int[] startDijk = createDijkstraList(s);


    Integer answer = Integer.MAX_VALUE;
    for(int i=1;i<=n;i++){
      int totalCost = startDijk[i] + dijkstra(i,a) + dijkstra(i,b);
      answer = Math.min(answer, totalCost);
    }



    return answer;
  }

  static int dijkstra(int start, int end) {
    int[] cost = new int[nodes.size()+1];
    PriorityQueue<CustomVextor> minCostQueue = new PriorityQueue<>(
        Comparator.comparingInt(o -> o.cost));

    Arrays.fill(cost, Integer.MAX_VALUE);

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

  static int[] createDijkstraList(int start) {
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

      if (cost[currentIndex] < currentVextor.cost) { //스킵
        continue;
      }

      //2. 기준점 이웃 노드 cost 갱신
      for (int j = 0; j < nodes.get(currentIndex).size(); j++) {
        CustomVextor connectVex = nodes.get(currentIndex).get(j); //커넥트 노드 선택

        if (cost[connectVex.index] > currentVextor.cost + connectVex.cost) {
          cost[connectVex.index] = currentVextor.cost + connectVex.cost;
          // 갱신된 경우에만 큐에 넣는다.
          minCostQueue.offer(new CustomVextor(connectVex.index, cost[connectVex.index]));
        }
      }
    }

    return cost;
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
