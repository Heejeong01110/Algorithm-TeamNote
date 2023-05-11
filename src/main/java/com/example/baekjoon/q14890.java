package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class q14890 {

  private static int N;
  private static int L;
  private static int[][] map;

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
    L = Integer.parseInt(st.nextToken());
    map = new int[N][N];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    br.close();
  }

  private static int Solution() {
    int cnt = 0;
    for (int i = 0; i < N; i++) {

      //1. 높이 정보 저장
      ArrayList<Node> nodes = new ArrayList<>();
      nodes.add(new Node(map[i][0], 1));
      for (int j = 1; j < N; j++) {
        // 222 33 222
        if (nodes.get(nodes.size() - 1).height != map[i][j]) {
          nodes.add(new Node(map[i][j], 1));
        } else {
          nodes.get(nodes.size() - 1).cnt += 1;
        }
      }

      //2. 경사로 놓을 수 있는 곳 확인
      if (isPossible(nodes)) {
        cnt += 1;
      }
    }

    for (int i = 0; i < N; i++) {

      //1. 높이 정보 저장
      ArrayList<Node> nodes = new ArrayList<>();
      nodes.add(new Node(map[0][i], 1));
      for (int j = 1; j < N; j++) {
        // 222 33 222
        if (nodes.get(nodes.size() - 1).height != map[j][i]) {
          nodes.add(new Node(map[j][i], 1));
        } else {
          nodes.get(nodes.size() - 1).cnt += 1;
        }
      }

      //2. 경사로 놓을 수 있는 곳 확인
      if (isPossible(nodes)) {
        cnt += 1;
      }
    }

    return cnt;
  }

  private static boolean isPossible(ArrayList<Node> nodes) {
    //1. 모두 높이 1칸 차이, 바닥너비 L 이상
    for (int j = 1; j < nodes.size(); j++) {
      if ((nodes.get(j - 1).height == nodes.get(j).height + 1 && nodes.get(j).cnt >= L)
          || (nodes.get(j - 1).height + 1 == nodes.get(j).height && nodes.get(j - 1).cnt >= L)) {
      } else {
        return false;
      }
    }

    //2. 오목한 부분에 못놓는 경우
    for (int j = 1; j < nodes.size() - 1; j++) {
      if (nodes.get(j - 1).height == nodes.get(j).height + 1
          && nodes.get(j).height + 1 == nodes.get(j + 1).height && nodes.get(j).cnt < 2 * L) {
        return false;
      }
    }

    return true;
  }

  private static class Node {

    int height;
    int cnt;

    public Node(int height, int cnt) {
      this.height = height;
      this.cnt = cnt;
    }
  }

}
