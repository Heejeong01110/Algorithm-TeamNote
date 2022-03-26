package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class q15686 {

  private static int N;
  private static int M;
  private static int originM;
  private static int originN;
  private static int[][] map;
  private static Node[] chickens;
  private static Node[] houses;
  private static int result;
  private static int[][] memo;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    output(Solution());
  }

  private static void output(int result) {
    System.out.print(result);
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new int[N + 1][N + 1];

    originM = 0;
    originN = 0;
    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
        if (map[i][j] == 2) {
          originM++;
        } else if (map[i][j] == 1) {
          originN++;
        }
      }
    }

    br.close();
  }

  private static int Solution() {
    chickens = new Node[originM];
    houses = new Node[originN];
    result = Integer.MAX_VALUE;

    int cIndex = 0, hIndex = 0;
    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= N; j++) {
        if (map[i][j] == 2) {
          originM++;
          chickens[cIndex++] = new Node(i, j, 2, new ArrayList<>(), null);
        } else if (map[i][j] == 1) {
          houses[hIndex++] = new Node(i, j, 1, null, new ArrayList<>());
        }
      }
    }

    memo = new int[houses.length][chickens.length];
    for (int i = 0; i < houses.length; i++) {
      for (int j = 0; j < chickens.length; j++) {
        memo[i][j] =
            Math.abs(houses[i].row - chickens[j].row) + Math.abs(houses[i].col - chickens[j].col);
      }
    }

    comb(new boolean[chickens.length], 0, 0);

    return result;
  }

  // 서로 다른 n개에서 순서 없이 r개를 뽑는 경우의 수
  private static void comb(boolean[] visited, int start, int depth) {
    if (depth == M) {
      result = Math.min(getMinRange(visited), result);
      return;
    }

    for (int i = start; i < chickens.length; i++) {
      if (!visited[i]) {
        visited[i] = true;
        comb(visited, i + 1, depth + 1);
        visited[i] = false;
      }
    }
  }

  private static Integer getMinRange(boolean[] visited) {
    Integer sum = 0;
    for (int i = 0; i < houses.length; i++) {
      Integer distinct = Integer.MAX_VALUE;
      for (int j = 0; j < visited.length; j++) {
        if (visited[j]) {
          distinct = Math.min(distinct, memo[i][j]);
        }
      }
      sum += distinct;
    }
    return sum;
  }

  private static class Node {

    int row;
    int col;
    int type; //1 : 집 2 : 치킨
    ArrayList<Node> connectHouse; //치킨일 경우 활성화
    ArrayList<Node> connectChicken; //집일 경우 활성화

    public Node(int row, int col, int type,
        ArrayList<Node> connectHouse,
        ArrayList<Node> connectChicken) {
      this.row = row;
      this.col = col;
      this.type = type;
      this.connectHouse = connectHouse;
      this.connectChicken = connectChicken;
    }
  }

}
