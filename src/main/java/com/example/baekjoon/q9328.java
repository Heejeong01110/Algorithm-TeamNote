package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class q9328 {

  private static final int[][] direct = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());
    for (int t = 0; t < T; t++) {

      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());
      char[][] map = new char[N + 2][M + 2];

      for (int i = 1; i <= N; i++) {
        String str = br.readLine();
        map[i][0] = '.';
        for (int j = 1; j <= M; j++) {
          map[i][j] = str.charAt(j - 1);
        }
        map[i][M + 1] = '.';
      }
      for (int i = 0; i <= M + 1; i++) {
        map[0][i] = '.';
        map[N + 1][i] = '.';
      }

      String str = br.readLine();
      Queue<Character> keys = new ArrayDeque<>();
      if (!str.equals("0")) {
        for (int i = 0; i < str.length(); i++) {
          keys.add(str.charAt(i));
        }
      }

      Queue<int[]> queue = new ArrayDeque<>();
      boolean[][] visited = new boolean[N + 2][M + 2];

      queue.add(new int[]{0, 0});
      visited[0][0] = true;

      //갖고있는 열쇠 다 열고 가기

      while (!queue.isEmpty()) {
        int[] now = queue.poll();

        //열쇠인 경우
        if (map[now[0]][now[1]] >= 97 && map[now[0]][now[1]] <= 122) {
          //소문자
          keys.add(map[now[0]][now[1]]);
          map = openDoors(map, map[now[0]][now[1]]);

          visited = new boolean[N + 2][M + 2];
          visited[now[0]][now[1]] = true;
        }

        for (int i = 0; i < 4; i++) {
          int r = now[0] + direct[i][0];
          int c = now[1] + direct[i][1];

          if (isPossible(r, c, map) && !visited[r][c]) {
            if (map[r][c] == '.' || map[r][c] == '$' || map[r][c] >= 97 && map[r][c] <= 122) {
              //통행 가능
              queue.add(new int[]{r, c});
              visited[r][c] = true;
            } else if (keys.contains(Character.toLowerCase(map[r][c]))) {
              //자물쇠
              map[r][c] = '.';
              queue.add(new int[]{r, c});
              visited[r][c] = true;
            }
          }
        }
      }

      //모든 문서 챙기기
      int result = getDocu(map);
      sb.append(result).append('\n');

    }
    System.out.print(sb);
    br.close();
  }

  private static char[][] openDoors(char[][] map, char key) {
    for (int i = 0; i < map.length; i++) {
      for (int j = 0; j < map[0].length; j++) {
        if (map[i][j] == key || map[i][j] == Character.toUpperCase(key)) {
          map[i][j] = '.';
        }
      }
    }
    return map;
  }

  private static int getDocu(char[][] map) {

    Queue<int[]> queue;
    boolean[][] visited = new boolean[map.length][map[0].length];
    int count = 0;

    queue = new ArrayDeque<>();
    visited[0][0] = true;
    queue.add(new int[]{0, 0});

    while (!queue.isEmpty()) {
      int[] now = queue.poll();

      //문서인 경우
      if (map[now[0]][now[1]] == '$') {
        count++;
      }

      for (int i = 0; i < 4; i++) {
        int r = now[0] + direct[i][0];
        int c = now[1] + direct[i][1];

        if (isPossible(r, c, map) && !visited[r][c] &&
            (map[r][c] == '.' || map[r][c] == '$')) {
          queue.add(new int[]{r, c});
          visited[r][c] = true;
        }
      }
    }

    return count;
  }


  private static boolean isPossible(int row, int col, char[][] map) {
    return row >= 0 && row < map.length && col >= 0 && col < map[0].length;
  }

}
