package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Set;
import java.util.StringTokenizer;

public class q2931 {

  private static final int[][] dir = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
  private static HashMap<Character, String> block;
  private static int N, M;
  private static int sr, sc, er, ec;
  private static char[][] map;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    Solution();
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new char[N][M];

    for (int i = 0; i < N; i++) {
      String str = br.readLine();
      map[i] = str.toCharArray();
    }

    block = new HashMap<>();
    block.put('|', "1010");
    block.put('-', "0101");
    block.put('+', "1111");
    block.put('1', "1100");
    block.put('2', "0110");
    block.put('3', "0011");
    block.put('4', "1001");
    block.put('.', "----");
    block.put('Z', "----");
    block.put('M', "----");
    br.close();
  }

  private static void Solution() {
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (map[i][j] == '.') {
          if (check(i, j)) {
            return;
          }
        }
      }
    }
  }

  private static boolean check(int row, int col) {
    String checks = "";
    boolean tmp = false;
    for (int d = 0; d < 4; d++) {
      int nr = row + dir[d][0];
      int nc = col + dir[d][1];
      if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
        String pipe = block.get(map[nr][nc]);
        int inputDir = (d + 2) % 4;
        if (pipe.charAt(inputDir) == '1') {//가스 통과 가능
          checks += "1";
          tmp = true;
        }
      }
      if (!tmp) {
        checks += "0";
      }
      tmp = false;
    }

    Set<Character> keySet = block.keySet();
    for (Character key : keySet) {
      if (block.get(key).equals(checks)) {
        System.out.print((row + 1) + " " + (col + 1) + " " + key);
        return true;
      }
    }

    return false;
  }

}
