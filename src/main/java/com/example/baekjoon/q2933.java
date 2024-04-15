package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q2933 {

  private static int R, C, N;
  private static char[][] map;
  private static int[] sticks;
  private static int[][] dir = new int[][]{{1, 0}, {0, -1}, {0, 1}, {-1, 0}};

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    print(Solution());
  }

  private static void print(char[][] map) {
    for (int i = R; i >= 1; i--) {
      for (int j = 1; j <= C; j++) {
        System.out.print(map[i][j]);
      }
      System.out.print("\n");
    }
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    map = new char[R + 1][C + 1];

    for (int i = R; i >= 1; i--) {
      String str = br.readLine();
      for (int j = 1; j <= C; j++) {
        map[i][j] = str.charAt(j - 1);
      }
    }

    N = Integer.parseInt(br.readLine());
    sticks = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      sticks[i] = Integer.parseInt(st.nextToken());
    }

    br.close();
  }

  private static char[][] Solution() {
    for (int i = 0; i < N; i++) {
      //1. 막대로 미네랄 부수기
      int loc = throwStick(sticks[i], i % 2 == 0);
      //2. 떨어지는 클러스트 확인하기
      if (loc == -1) {
        continue;
      }
      checkMap(sticks[i], loc);
    }
    return map;
  }

  private static int throwStick(int stick, boolean direct) {
    int s = direct ? 0 : C + 1;
    int d = direct ? 1 : -1;
    for (int i = 1; i <= C; i++) {
      int c = s + d * i;
      if (map[stick][c] == 'x') {
        map[stick][c] = '.';
        return c;
      }
    }
    return -1;
  }

  private static void checkMap(int row, int col) {
    //1. 공중에 떠있는 클러스터 찾기
    for (int d = 0; d < 4; d++) {
      int nr = row + dir[d][0];
      int nc = col + dir[d][1];

      if (isPossible(nr, nc) && map[nr][nc] == 'x') {
        //2. 클러스터 내 미네랄들 위치정보 구하기
        Result result = getRowHeights(nr, nc);

        if (result.success) { //땅에 닿아있지 않을 경우
          //3. 높이 내리기
          setHeight(result.locations);
          break;
        }

      }
    }

  }

  private static void setHeight(ArrayList<int[]> locations) {
    //1. 연산을 위해 지도에서 locations 위치의 미네랄 모두 지우기
    for (int[] loc : locations) {
      map[loc[0]][loc[1]] = '.';
    }
    //2. 한칸씩 내려가며 옮길 수 있는지 확인
    int h = 1;
    Loop:
    while (h < R) {
      for (int[] loc : locations) {
        if (map[loc[0] - h][loc[1]] == 'x' || loc[0] - h == 0) {
          h -= 1;
          break Loop;
        }
      }
      h++;
    }

    //3. 확인 후 해당 높이로 미네랄 넣기
    for (int[] loc : locations) {
      map[loc[0] - h][loc[1]] = 'x';
    }
  }


  private static Result getRowHeights(int row, int col) {
    ArrayList<int[]> locations = new ArrayList<>();
    boolean success = true;

    boolean[][] visited = new boolean[R + 1][C + 1];
    Queue<int[]> queue = new LinkedList<>();

    queue.add(new int[]{row, col});
    visited[row][col] = true;
    locations.add(new int[]{row, col});

    while (!queue.isEmpty()) {
      int[] now = queue.poll();

      if (now[0] == 1) {
        success = false;
        break; //땅에 닿아있음
      }

      for (int d = 0; d < 4; d++) {
        int nr = now[0] + dir[d][0];
        int nc = now[1] + dir[d][1];

        if (isPossible(nr, nc) && map[nr][nc] == 'x' && !visited[nr][nc]) {
          queue.add(new int[]{nr, nc});
          visited[nr][nc] = true;
          locations.add(new int[]{nr, nc});
        }
      }
    }
    return new Result(locations, success);

  }


  private static boolean isPossible(int r, int c) {
    return r >= 1 && r <= R && c >= 1 && c <= C;
  }

  private static class Result {

    ArrayList<int[]> locations;
    boolean success;

    public Result(ArrayList<int[]> locations, boolean success) {
      this.locations = locations;
      this.success = success;
    }
  }

}
