package com.example.programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class s1837 {

  private static final int INF = 10000000;
  private static ArrayList<Integer>[] nodes;
  private static int result;

  public static int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
    nodes = new ArrayList[n + 1];
    for (int i = 1; i <= n; i++) {
      nodes[i] = new ArrayList<>();
    }

    for (int i = 0; i < edge_list.length; i++) {
      nodes[edge_list[i][0]].add(edge_list[i][1]);
      nodes[edge_list[i][1]].add(edge_list[i][0]);
    }

    int[][] dp = new int[k][n + 1];
    for (int i = 0; i < k; i++) {
      Arrays.fill(dp[i], INF);
    }
    dp[0][gps_log[0]] = 0;

    for (int i = 1; i < k; i++) {
      for (int j = 1; j <= n; j++) {
        //dp[i][j] : i번째 순서에서 j번째 노드에 위치하기 위해 변경한 갯수
        //1. 이전 순서에서 이번 순서로 이동하는 경우 중(제자리, 연결 노드에서 이동) 가장 적은 변경갯수를 가지는 수를 구함
        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j]);//이동하지 않을 경우

        for (int l = 0; l < nodes[j].size(); l++) { //연결된 노드에서 이동하는 경우 중 최소값
          dp[i][j] = Math.min(dp[i][j], dp[i - 1][nodes[j].get(l)]);
        }

        //2. 현재 노드가 log과 다를 경우 이번 순서에 변경한 것으로 기록
        if (gps_log[i] != j) {
          dp[i][j] += 1;
        }
      }
    }

    if (dp[k - 1][gps_log[k - 1]] >= INF) {
      return -1;
    }
    return dp[k - 1][gps_log[k - 1]];
  }

}
