package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

public class q3089 {

  private static int N, M;
  private static int[][] clovers;
  private static int[] commands;
  private static int[][] dir = new int[][]{{0, -1}, {0, 1}, {1, 0}, {-1, 0}};

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    System.out.print(Solution());
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    clovers = new int[N][2];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      clovers[i][0] = Integer.parseInt(st.nextToken());
      clovers[i][1] = Integer.parseInt(st.nextToken());
    }
    String inpStr = br.readLine();
    char[] charArray = inpStr.toCharArray();
    commands = new int[M];
    for (int i = 0; i < M; i++) {
      if (charArray[i] == 'L') {
        commands[i] = 0;
      } else if (charArray[i] == 'R') {
        commands[i] = 1;
      } else if (charArray[i] == 'U') {
        commands[i] = 2;
      } else if (charArray[i] == 'D') {
        commands[i] = 3;
      }
    }
    br.close();
  }

  private static String Solution() {
    HashMap<Integer, ArrayList<Integer>> xLoc = new HashMap<>();
    HashMap<Integer, ArrayList<Integer>> yLoc = new HashMap<>();

    for (int[] clover : clovers) {
      ArrayList<Integer> xList = xLoc.getOrDefault(clover[0], new ArrayList<>());
      xList.add(clover[1]);
      xLoc.put(clover[0], xList);
      ArrayList<Integer> yList = yLoc.getOrDefault(clover[1], new ArrayList<>());
      yList.add(clover[0]);
      yLoc.put(clover[1], yList);
    }

    for (int key : xLoc.keySet()) {
      xLoc.get(key).sort(Comparator.naturalOrder());
    }
    for (int key : yLoc.keySet()) {
      yLoc.get(key).sort(Comparator.naturalOrder());
    }

    int nx = 0, ny = 0;
    for (int d : commands) {
      //1. 가장 가까운 네잎클로버 찾기
      if (d < 2) { //x축 움직이기
        nx = getLoc(yLoc.getOrDefault(ny, new ArrayList<>()), dir[d][1], nx);
      } else { //y축 움직이기
        ny = getLoc(xLoc.getOrDefault(nx, new ArrayList<>()), dir[d][0], ny);
      }
    }

    return nx + " " + ny;
  }

  private static int getLoc(ArrayList<Integer> list, int d, int start) {
    int idx = Collections.binarySearch(list, start);
    return list.get(idx + d);
  }

}
