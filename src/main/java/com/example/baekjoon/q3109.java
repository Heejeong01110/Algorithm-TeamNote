package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class q3109 {

  private static int R;
  private static int C;
  private static int[][] map;
  private static int[][] dir = new int[][]{{-1, 1}, {0, 1}, {1, 1}};
  private static int[][] dir2 = new int[][]{{-1, -1}, {0, -1}, {1, -1}};

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
    map = new int[R][C];

    for (int i = 0; i < R; i++) {
      String str = br.readLine();
      for (int j = 0; j < C; j++) {
        map[i][j] = (str.charAt(j) == '.' ? 0 : 1);
      }
    }

    br.close();
  }

  private static int Solution() {
    ArrayList<Integer> pre = new ArrayList<>();
    ArrayList<Integer> now = new ArrayList<>();
    int cnt = R;

    for (int i = 0; i < R; i++) {
      pre.add(i);
    }

    for (int j = 1; j < C; j++) {
      now = new ArrayList<>();
      for (int i = 0; i < R; i++) {
        if (map[i][j] == 0 && (pre.contains(i - 1) || pre.contains(i) || pre.contains(i + 1))) {
          now.add(i);
        }
      }
      pre = (ArrayList<Integer>) now.clone();
      cnt = Math.min(cnt, now.size());
    }

    return cnt;
  }


}
