package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class q18500 {

  private static int R;
  private static int C;
  private static boolean[][] mineral;
  private static int[] heights;

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
    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    mineral = new boolean[R][C];

    for (int i = R - 1; i >= 0; i--) {
      String str = br.readLine();
      for (int j = 0; j < C; j++) {
        mineral[i][j] = str.charAt(j) == 'x';
      }
    }
    Integer range = Integer.parseInt(br.readLine());
    heights = new int[range];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < range; i++) {
      heights[i] = Integer.parseInt(st.nextToken());
    }

    br.close();
  }

  private static int Solution() {

    for (int h = 0; h < heights.length; h++) {
      int breakH = heights[h] - 1;

      if (h % 2 == 0) {
        for (int i = 0; i < C; i++) {
          if (mineral[breakH][i]) {
            mineral[breakH][i] = false;
            mineral = reLocate(mineral);
            break;
          }
        }
      } else {
        for (int i = C - 1; i >= 0; i--) {
          if (mineral[breakH][i]) {
            mineral[breakH][i] = false;
            mineral = reLocate(mineral);
            break;
          }
        }
      }

    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        sb.append(mineral[i][j] ? "x" : ".");
      }
      sb.append("\n");
    }

    return 0;
  }


  private static boolean[][] checkCluster(boolean[][] mineral) {
    boolean[][] notVisited = new boolean[R][C];
    Queue<Node> queue = new ArrayDeque<>();
    for (int i = 0; i < R; i++) {
      notVisited[i] = mineral[i].clone(); //미네랄 있는곳이 true;
    }

    for (int i = 0; i < C; i++) {
      if (notVisited[0][i]) {
        queue.add(new Node(0, i));
        notVisited[0][i] = false;
      }
    }

    int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    //공중에 띄워져있는 미네랄 있는지 확인
    while (!queue.isEmpty()) {
      Node now = queue.poll();

      for (int i = 0; i < 4; i++) {
        int nr = now.row + dir[i][0];
        int nc = now.col + dir[i][1];

        if (nr >= 0 && nr < R && nc >= 0 && nc < C && notVisited[nr][nc]) {
          queue.add(new Node(nr, nc));
          notVisited[nr][nc] = false;
        }
      }
    }

    return notVisited;
  }

  private static boolean[][] reLocate(boolean[][] mineral) {
    boolean[][] notV = checkCluster(mineral);

    //방문되지 않은 곳 존재할 시 아래로 내리기(1가지만 존재함)
    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        if (notV[i][j]) {
          //떨구기
          mineral[i][j] = false;
          mineral[i - 1][j] = true; //한칸 떨구기X 완전 떨구기로 바꾸기
        }
      }
    }

    return mineral;
  }

  private static class Node {

    int row;
    int col;

    public Node(int row, int col) {
      this.row = row;
      this.col = col;
    }
  }


}
