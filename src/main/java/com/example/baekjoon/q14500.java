package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q14500 {

  private static final int[][] direct = {{0, 1}, {1, 0}, {-1, 0}};
  private static final int[][] shape = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}, {0, 1}, {-1, 0}};
  private static int N;
  private static int M;
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
    M = Integer.parseInt(st.nextToken());
    map = new int[N][M];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    br.close();
  }

  private static int Solution() {

    int result = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        result = Math.max(bfs(i, j), result);
      }
    }

    return result;
  }

  private static int bfs(int row, int col) {
    Queue<Item> queue = new ArrayDeque<>();
    int maxResult = 0;

    Item now = new Item(row, col, new ArrayList<>());
    for (int i = 0; i < 4; i++) {
      Item[] items = new Item[3];
      for (int j = 0; j < 3; j++) {
        items[j] = new Item(row + shape[i + j][0], col + shape[i + j][1], null);
      }

      if (checkShape(items)) {
        Integer sum = 0;
        for (int j = 0; j < 3; j++) {
          sum += map[items[j].row][items[j].col];
        }
        sum += map[now.row][now.col];
        maxResult = Math.max(maxResult, sum);
      }
    }

    queue.add(now);

    while (!queue.isEmpty()) {
      Item item = queue.poll();

      ArrayList<Item> visited = (ArrayList<Item>) item.visited.clone();
      visited.add(item);

      for (int i = 0; i < 3; i++) {
        int moveR = item.row + direct[i][0];
        int moveC = item.col + direct[i][1];

        if (check(moveR, moveC, visited)) {
          if (visited.size() == 3) {
            Integer sum = 0;
            for (int j = 0; j < 3; j++) {
              sum += map[visited.get(j).row][visited.get(j).col];
            }
            sum += map[moveR][moveC];
            maxResult = Math.max(maxResult, sum);
          } else {
            Item newItem = new Item(moveR, moveC, visited);
            queue.add(newItem);
          }
        }
      }
    }

    return maxResult;
  }

  private static boolean checkShape(Item[] items) {
    for (int i = 0; i < 3; i++) {
      if (items[i].row < 0 || items[i].row >= N || items[i].col < 0 || items[i].col >= M) {
        return false;
      }
    }
    return true;
  }


  private static boolean check(int moveR, int moveC, ArrayList<Item> visited) {
    if (moveR < 0 || moveR >= N || moveC < 0 || moveC >= M) {
      return false;
    }
    for (Item item : visited) {
      if (item.row == moveR && item.col == moveC) {
        return false;
      }
    }
    return true;
  }

  private static class Item {

    ArrayList<Item> visited;
    int row;
    int col;

    public Item(int row, int col, ArrayList<Item> visited) {
      this.row = row;
      this.col = col;
      this.visited = visited;
    }
  }

}
