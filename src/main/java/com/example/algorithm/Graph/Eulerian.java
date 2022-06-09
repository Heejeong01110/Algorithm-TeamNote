package com.example.algorithm.Graph;

//오일러 경로 : 그래프에 존재하는 모든 간선을 정확히 1번씩만 방문하는 연속된 경로
//오일러 회로 : 위의 조건에서 시작점과 도착점이 같다는 조건이 추가된 경우

import java.util.ArrayList;

//방향이 없는 그래프일 때,
// 차수가 홀수인 정점이 2개일 경우 오일러 경로. 홀수인 정점이 각각 시작점, 종료점
// 차수가 홀수인 정점이 0개일 경우 오일러 회로.
public class Eulerian {

  private static int V;
  private static int E;
  private static boolean isTrail;
  private static ArrayList<Integer>[] nodes;
  private static int[][] circle;

  public static void main(String[] args) {
    int[][] data = new int[][]{{1, 2}, {1, 3}, {1, 4}, {2, 3}, {2, 4}};
    V = 4;
    E = 5;
    isTrail = false;

    nodes = new ArrayList[V + 1];
    for (int i = 1; i <= V; i++) {
      nodes[i] = new ArrayList<>();
    }

    for (int i = 0; i < E; i++) {
      int one = data[i][0];
      int two = data[i][1];

      nodes[one].add(two);
      nodes[two].add(one);
    }

    circle = new int[V + 1][V + 1];
    for (int i = 1; i <= V; i++) { //오일러 경로
      if (nodes[i].size() % 2 == 1) {
        dfs(0, i, i);
      }
    }
    System.out.println("오일러 경로인가? " + isTrail);

    for (int i = 1; i <= V; i++) { //오일러 경로
      if (nodes[i].size() % 2 == 1) {
        System.out.println("오일러 회로인가? false");
        return;
      }
    }
    System.out.println("오일러 회로인가? true");
  }


  private static void dfs(int depth, int now, int num) {
    if (depth == E) {
      isTrail = true;
      return;
    }

    for (int i = 0; i < nodes[now].size(); i++) {
      int next = nodes[now].get(i);

      if (circle[now][next] == num || circle[next][now] == num) {
        continue;
      }

      circle[now][next] = num;
      circle[next][now] = num;
      dfs(depth + 1, next, num);
    }

  }
}
