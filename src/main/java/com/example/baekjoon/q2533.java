package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class q2533 {

  private static int N;
  private static int[][] dp;
  private static ArrayList<Integer>[] map;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st;
    N = Integer.parseInt(br.readLine());

    map = new ArrayList[N + 1];
    for (int i = 1; i <= N; i++) {
      map[i] = new ArrayList<>();
    }

    for (int i = 0; i < N - 1; i++) {
      st = new StringTokenizer(br.readLine());
      int o = Integer.parseInt(st.nextToken());
      int t = Integer.parseInt(st.nextToken());
      map[o].add(t);
      map[t].add(o);
    }
    br.close();

    dp = new int[N + 1][2];
    dfs(1, -1);
    System.out.print(Math.min(dp[1][0], dp[1][1]));
  }

  //dp 0:now가 X얼 1:now가 얼 일때
  // 자기 위치까지의 얼리어답터의 수
  private static void dfs(int now, int parent) {
    dp[now][0] = 0;
    dp[now][1] = 1;

    if (map[now].size() == 1 && parent != -1) { //leaf 노드
      return;
    }

    for (Integer child : map[now]) {
      if (child == parent) {
        continue;
      }

      dfs(child, now);
      //1. 자신이 X 일경우 -> 자식, 부모 모두 O여야 함
      dp[now][0] += dp[child][1];
      //2. 자신이 O 일경우 -> 어떤 경우이든지 상관 없음(최소값 더해줌)
      dp[now][1] += Math.min(dp[child][0], dp[child][1]);
    }
  }

}
