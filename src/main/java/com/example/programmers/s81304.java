package com.example.programmers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class s81304 {

  private static HashMap<Integer, ArrayList<Node>> nodes;

  public static int solution(int n, int start, int end, int[][] roads, int[] traps) {
    int answer = 0;
    nodes = new HashMap<>();

    for (int i = 1; i <= n; i++) {
      nodes.put(i, new ArrayList<>());
    }

    for (int i = 0; i < roads.length; i++) {
      nodes.get(roads[i][0]).add(new Node(roads[i][1], roads[i][2], true, new ArrayList<>()));
      nodes.get(roads[i][1]).add(new Node(roads[i][0], roads[i][2], false, new ArrayList<>()));
    }

    answer = dijkstra(start, end, traps);

    return answer;
  }

  static int dijkstra(int start, int end, int[] traps) {
    int[] cost = new int[nodes.size() + 1];
    int[][] costs = new int[nodes.size() + 1][nodes.size() + 1];
    PriorityQueue<Vert> queue = new PriorityQueue<>(
        Comparator.comparingInt(o -> o.cost));

    for (int i = 0; i < cost.length; i++) {
      cost[i] = Integer.MAX_VALUE;
    }

    for (int i = 0; i < cost.length; i++) {
      for (int j = 0; j < cost.length; j++) {
        costs[i][j] = Integer.MAX_VALUE;
      }
    }

    cost[start] = 0;
    costs[start][start] = 0;
    queue.add(new Vert(0, start, 0, new ArrayList<>()));

    while (!queue.isEmpty()) {
      //1. 최소 비용의 노드 선택
      Vert now = queue.poll(); //기준점에서부터의 길이가 저장됨. 새로 생성하는 벡터

      if (now.nowIdx == end) { //end 지점 도착시 함수 종료
        return costs[now.nowIdx][now.prevIdx];
      }

      if (costs[now.nowIdx][now.prevIdx] < now.cost) { //스킵
        continue;
      }

      //2. 기준점 이웃 노드 중 최소값 구하기
      boolean isNowReverse = now.trapList.contains(now.nowIdx);

      for (int j = 0; j < nodes.get(now.nowIdx).size(); j++) {
        Node next = nodes.get(now.nowIdx).get(j); //커넥트 노드 선택
        boolean isNextReverse = now.trapList.contains(next.index); //next가 현재 함정으로 바뀌어있는가??X
        //next 주변 모든 노드 조사

        if (isNowReverse && !isNextReverse
            || !isNowReverse && isNextReverse) {//now만 reverse, next만 reverse
          if (next.isStart) { //now -> next 방향이 초기 방향일 때 X
            continue;
          }
        } else {// 둘다 reverse, 둘다 정상
          if (!next.isStart) {//now -> next 방향이 초기 방향일 때 O
            continue;
          }
        }

        if (costs[next.index][now.nowIdx] > now.cost + next.cost) { //한바퀴 돌아서 오는 경우 존재
          costs[next.index][now.nowIdx] = now.cost + next.cost;
        if (isTrap(traps, next.index)) { //다음 노드가 함정일 경우
          //이미 포함하고 있는 경우
          if (now.trapList.contains(next.index)) {
            for (int i = 0; i < now.trapList.size(); i++) {
              if (now.trapList.get(i) == next.index) {
                now.trapList.remove(i);
              }
            }
          } else {//없을 경우
            now.trapList.add(next.index);
          }
          queue.add(new Vert(now.nowIdx, next.index, costs[next.index][now.nowIdx], now.trapList));
        } else {
          queue.add(new Vert(now.nowIdx, next.index, costs[next.index][now.nowIdx], now.trapList));
        }
        }
      }
    }

    return cost[end];
  }

  private static boolean isTrap(int[] traps, int index) {
    for (int trap : traps) {
      if (trap == index) {
        return true;
      }
    }
    return false;
  }

  private static class Node {

    int index;
    int cost;
    boolean isStart;
    ArrayList<Integer> trapList;

    public Node(int index, int cost, boolean isStart, ArrayList<Integer> trapList) {
      this.index = index;
      this.cost = cost;
      this.isStart = isStart;
      this.trapList = trapList;
    }
  }

  private static class Vert {

    int prevIdx;
    int nowIdx;
    int cost;
    ArrayList<Integer> trapList;

    public Vert(int prev, int now, int cost, ArrayList<Integer> trapList) {
      this.prevIdx = prev;
      this.nowIdx = now;
      this.cost = cost;
      this.trapList = trapList;
    }
  }
}
