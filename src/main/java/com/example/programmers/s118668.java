package com.example.programmers;

import java.util.Arrays;

public class s118668 {

  public static int solution(int alp, int cop, int[][] problems) {
    Integer MAX_ALP = alp;
    Integer MAX_COP = cop;
    Node[] nodes = new Node[problems.length];

    for (int i = 0; i < nodes.length; i++) {
      nodes[i] = new Node(i, problems[i][0], problems[i][1], problems[i][2], problems[i][3],
          problems[i][4]);
      MAX_ALP = Math.max(MAX_ALP, nodes[i].alp_req);
      MAX_COP = Math.max(MAX_COP, nodes[i].cop_req);
    }

    Integer[][] dp = new Integer[151][151];
    for (int i = 0; i < 151; i++) {
      Arrays.fill(dp[i], 10000000);
    }

    dp[alp][cop] = 0;

    for (int i = alp; i <= MAX_ALP; i++) {
      for (int j = cop; j <= MAX_COP; j++) {
        if (i + 1 <= MAX_ALP) {
          dp[i + 1][j] = Math.min(dp[i][j] + 1, dp[i + 1][j]);
        }
        if (j + 1 <= MAX_COP) {
          dp[i][j + 1] = Math.min(dp[i][j] + 1, dp[i][j + 1]);
        }

        for (Node node : nodes) {
          if (i >= node.alp_req && j >= node.cop_req) {
            int al = Math.min(i + node.alp_rwd, MAX_ALP);
            int co = Math.min(j + node.cop_rwd, MAX_COP);
            dp[al][co] = Math.min(dp[al][co], dp[i][j] + node.cost);
          }
        }

      }
    }

    return dp[MAX_ALP][MAX_COP];
  }

  private static class Node {

    int idx;
    int alp_req;
    int cop_req;
    int alp_rwd;
    int cop_rwd;
    int cost;

    public Node(int idx, int alp_req, int cop_req, int alp_rwd, int cop_rwd, int cost) {
      this.idx = idx;
      this.alp_req = alp_req;
      this.cop_req = cop_req;
      this.alp_rwd = alp_rwd;
      this.cop_rwd = cop_rwd;
      this.cost = cost;
    }

  }
}
