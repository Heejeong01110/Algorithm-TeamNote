package com.example.programmers;

import java.util.ArrayList;

public class s72416 {
  private static int[][] dp;

  public static int solution(int[] sales, int[][] links) {
    Node[] nodes = new Node[sales.length + 1];

    for (int i = 1; i <= sales.length; i++) {
      nodes[i] = new Node(i, sales[i - 1], new ArrayList<>());
    }

    for (int[] link : links) {
      nodes[link[0]].children.add(link[1]);
    }

    dp = new int[nodes.length][2];
    dfs(nodes, 1);
    int answer = Math.min(dp[1][0], dp[1][1]);

    return answer;
  }

  private static void dfs(Node[] nodes, int now) {
    dp[now][0] = 0; //참석X
    dp[now][1] = nodes[now].cost; //참석O
    if (nodes[now].children.isEmpty()) {
      return;
    }

    int minCost = Integer.MAX_VALUE;
    for (int i = 0; i < nodes[now].children.size(); i++) {
      int child = nodes[now].children.get(i);
      dfs(nodes, child);

      if (dp[child][0] < dp[child][1]) { //해당 직원이 참석 안하는게 비용이 적을 경우
        dp[now][0] = dp[now][0] + dp[child][0];
        dp[now][1] = dp[now][1] + dp[child][0];
        minCost = Math.min(minCost, dp[child][1] - dp[child][0]);//팀장이 참석하지 않을 때 팀원의 최소값 구해두기
      } else {//참석하는게 적을 경우
        dp[now][0] = dp[now][0] + dp[child][1];
        dp[now][1] = dp[now][1] + dp[child][1];
        minCost = 0;//누군가 1명이상 참석할 경우 팀장이 참석하지 않을경우가 괜찮아짐
      }
    }
    dp[now][0] += minCost;//if문에서 dp[child][0]를 이미 더했으니 -dp[child][0]+dp[child][1]값을 미리 구해두기


  }

  private static class Node {

    int index;
    int cost;
    ArrayList<Integer> children;

    public Node(int index, int cost, ArrayList<Integer> children) {
      this.index = index;
      this.cost = cost;
      this.children = children;
    }
  }
}
