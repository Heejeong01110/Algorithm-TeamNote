package com.example.programmers;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class s1837 {

  private static ArrayList<Integer>[] nodes;
  private static int result;

  public static int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
    result = Integer.MAX_VALUE;

    nodes = new ArrayList[n + 1];
    for (int i = 1; i <= n; i++) {
      nodes[i] = new ArrayList<>();
    }

    for (int i = 0; i < edge_list.length; i++) {
      nodes[edge_list[i][0]].add(edge_list[i][1]);
      nodes[edge_list[i][1]].add(edge_list[i][0]);
    }

    for (int c = 0; c <= k - 2; c++) { //c : 바꿀 데이터 갯수
      comb(gps_log, new boolean[k], 1, 0, c);
    }

    if(result == Integer.MAX_VALUE){
      return -1;
    }
    return result;
  }

  private static void comb(int[] gps_log, boolean[] visited, int start, int depth, int r) {
    if (result != Integer.MAX_VALUE) {
      return;
    }

    if (depth == r) {
      checkConnection(gps_log, visited, r);
      return;
    }

    //출발지, 도착지는 포함 X
    for (int i = start; i < gps_log.length - 1; i++) {
      if (!visited[i]) {
        visited[i] = true;
        comb(gps_log, visited, i + 1, depth + 1, r);
        visited[i] = false;
      }
    }
  }

  private static void checkConnection(int[] gps_log, boolean[] changeIdx, int changeCnt) {
    Queue<Integer> queue = new ArrayDeque<>();
    queue.add(gps_log[0]);
    int idx = 1;

    while (!queue.isEmpty()) {
      //중복 제거
      int size = queue.size();
      for (int s = 0; s < size; s++) {
        int now = queue.poll();
        if (!queue.contains(now)) {
          queue.add(now);
        }
      }

      size = queue.size();
      for (int s = 0; s < size; s++) {
        int now = queue.poll();

        if (now == gps_log[gps_log.length - 1] && idx == gps_log.length) {
          result = changeCnt;
          return;
        }

        if (changeIdx[idx]) { //1. 경로를 변경 O인 경우
          for (int i = 0; i < nodes[now].size(); i++) { //연결 노드
            int next = nodes[now].get(i);
            if (next != gps_log[idx]) {
              queue.add(next);
            }
          }

          if (now != gps_log[idx]) {//제자리 대기
            queue.add(now);
          }

        } else { //2. 경로 변경 X
          if (nodes[now].contains(gps_log[idx]) || now == gps_log[idx]) { //연결된 길일 경우만 계속 진행
            queue.add(gps_log[idx]);
          }
        }
      }
      idx++;
    }


  }
}
