package com.example.programmers;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class s1839 {

  private static final int[][] direct = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

  public static int[] solution(int n, int m, int s, int[][] time_map) {

    long[][][] dp = new long[n][m][2501];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        Arrays.fill(dp[i][j], Long.MAX_VALUE);
      }
    }

    Queue<Node> queue = new ArrayDeque<>();
    queue.add(new Node(0,0,0));
    dp[0][0][0] = 0;

    while(!queue.isEmpty()){
      Node now = queue.poll();

      if(dp[now.row][now.col][now.len] > s){
        continue;
      }

      for (int k = 0; k < 4; k++) {
        int pr = now.row + direct[k][0];
        int pc = now.col + direct[k][1];
        if (isPossible(pr, pc, n, m) //유효한 좌표
            && time_map[pr][pc] != -1
            && dp[now.row][now.col][now.len] + time_map[pr][pc] < dp[pr][pc][now.len+1]) { //최대 값을 넘지 않는지
          dp[pr][pc][now.len+1] = dp[now.row][now.col][now.len] + time_map[pr][pc];
          queue.add(new Node(pr, pc, now.len+1));
        }
      }
    }

    int[] answer = new int[]{0,0} ;
    for (int i = 0; i < 2501; i++) {
      if(dp[n-1][m-1][i] > s) continue;
      if(dp[n-1][m-1][i] != Long.MAX_VALUE){
        answer = new int[]{i, (int)dp[n-1][m-1][i]};
        break;
      }
    }
    return answer;
  }

  private static class Node{
    int row;
    int col;
    int len;

    public Node(int row, int col, int len) {
      this.row = row;
      this.col = col;
      this.len = len;
    }
  }

  private static boolean isPossible(int row, int col, int n, int m) {
    return row >= 0 && row < n && col >= 0 && col < m;
  }

}
