package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class q22866 {

  private static int N;
  private static Building[] buildings;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    output(Solution());
  }

  private static void output(String result) {
    System.out.print(result);
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    buildings = new Building[N + 1];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      buildings[i] = new Building(i, Integer.parseInt(st.nextToken()));
    }

    br.close();
  }

  private static String Solution() {
    StringBuilder sb = new StringBuilder();

    Stack<Building> stack;
    int[] count = new int[N + 1];
    int[][] near = new int[N + 1][2]; //0-가까운건물번호, 1-거리

    for (int[] ary : near) {
      Arrays.fill(ary, 100001);
    }
    stack = new Stack<>();
    for (int i = 1; i <= N; i++) {
      while (!stack.isEmpty() && stack.peek().height <= buildings[i].height) {
        stack.pop();
      }
      count[i] += stack.size();

      if (!stack.isEmpty()) {
        int gap = Math.abs(stack.peek().index - i);
        if (gap < near[i][1]) {
          near[i][0] = stack.peek().index;
          near[i][1] = gap;
        } else if (gap == near[i][1] && stack.peek().index < near[i][0]) {
          near[i][0] = stack.peek().index;
        }
      }

      stack.push(buildings[i]);
    }

    stack = new Stack<>();
    for (int i = N; i >= 1; i--) {
      while (!stack.isEmpty() && stack.peek().height <= buildings[i].height) {
        stack.pop();
      }
      count[i] += stack.size();

      if (!stack.isEmpty()) {
        int gap = Math.abs(stack.peek().index - i);
        if (gap < near[i][1]) {
          near[i][0] = stack.peek().index;
          near[i][1] = gap;
        } else if (gap == near[i][1] && stack.peek().index < near[i][0]) {
          near[i][0] = stack.peek().index;
        }
      }

      stack.push(buildings[i]);
    }

    for (int i = 1; i <= N; i++) {
      if (count[i] == 0)
        sb.append(0);
      else
        sb.append(count[i]).append(' ').append(near[i][0]);
      sb.append('\n');
    }

    return sb.toString();
  }

  private static class Building {

    int index;
    int height;

    public Building(int index, int height) {
      this.index = index;
      this.height = height;
    }
  }

}
