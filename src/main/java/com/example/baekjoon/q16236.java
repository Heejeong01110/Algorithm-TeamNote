package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class q16236 {

  private static final int[][] direct = new int[][]{{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
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
    M = 0;
    map = new int[N][N];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
        if (map[i][j] != 0 && map[i][j] != 9) {
          M++;
        }
      }
    }

    br.close();
  }

  private static int Solution() {
    if (M == 0) {
      return 0;
    }



    Node baby = null;
    ArrayList<Node> foods = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (map[i][j] == 9) {
          baby = new Node(i, j, 2);
          map[i][j] = 2;
        } else if (map[i][j] != 0 && map[i][j] != 9) {
          foods.add(new Node(i, j, map[i][j]));
        }
      }
    }

    int result = 0;
    int eatFood = 0;
    Node nextNode = null;
    while (!foods.isEmpty()) {

      Queue<Node> aryQueue = new ArrayDeque<>();
      boolean temp = false;
      aryQueue.add(baby);
      boolean[][] visited = new boolean[N][N];
      visited[baby.row][baby.col] = true;
      PriorityQueue<Node> pq;


      while (!aryQueue.isEmpty()) {
        int size = aryQueue.size();

        pq = new PriorityQueue<>((o1, o2) -> {
          if (o1.row == o2.row) {
            return o1.col - o2.col;
          }
          return o1.row - o2.row;
        });
        pq.addAll(aryQueue);
        aryQueue.clear();

        for (int t = 0; t < size; t++) {
          Node n = pq.poll();
          if (n.size != 0 && n.size < baby.size) {
            nextNode = n;
            map[baby.row][baby.col] = 0;
            map[n.row][n.col] = 9;
            foods.remove(n);
            result += (Math.abs(baby.row - n.row) + Math.abs(baby.col - n.col));
            temp = true;
            t = size;
            break;
          } else if (n.size > baby.size) {
            continue;
          }

          for (int i = 0; i < 4; i++) {
            int nr = n.row + direct[i][0];
            int nc = n.col + direct[i][1];
            if (isPossible(nr, nc) && !visited[nr][nc] && map[nr][nc] <= baby.size) {
              aryQueue.add(new Node(nr, nc, map[nr][nc]));
              visited[nr][nc] = true;
            }
          }
        }
      }

      if (temp) { //먹고 나올경우
        nextNode.size = baby.size;
        baby = nextNode;
        eatFood += 1;
        if (baby.size == eatFood) {
          baby.size += 1;
          eatFood = 0;
        }
        map[baby.row][baby.col] = baby.size;
      } else { //못먹고 나올경우
        break;
      }

    }

    return result;
  }

  private static boolean isPossible(int nr, int nc) {
    return nr >= 0 && nr < N && nc >= 0 && nc < N;
  }


  private static class Node {

    int row;
    int col;
    int size;

    public Node(int row, int col, int size) {
      this.row = row;
      this.col = col;
      this.size = size;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof Node)) {
        return false;
      }
      Node node = (Node) o;
      return row == node.row && col == node.col && size == node.size;
    }

    @Override
    public int hashCode() {
      return Objects.hash(row, col, size);
    }
  }

}
