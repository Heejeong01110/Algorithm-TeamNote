package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class q2658 {

  private static final int N = 10;
  private static int[][] inp;
  private static int[][] dir = {
      {-1, -1}, {-1, 0}, {-1, 1},
      {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1},};

  private static int[][] diagonal = {
      {0, 1, 2}, {1, 2, 3},
      {2, 3, 4}, {3, 4, 5},
      {4, 5, 6}, {5, 6, 7},
      {0, 6, 7}, {0, 1, 7}
  };

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    System.out.print(Solution());
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    inp = new int[N][N];

    for (int i = 0; i < N; i++) {
      String s = br.readLine();
      for (int j = 0; j < N; j++) {
        inp[i][j] = Integer.parseInt(s.substring(j, j + 1));
      }
    }
    br.close();
  }

  private static String Solution() {
    ResultSet res = null;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (inp[i][j] != 1) {
          continue;
        }
        ArrayList<Integer> check = check(i, j);
        if (check.size() == 3) { // 직각인 꼭짓점인지 확인
          res = checkTriangle(i, j, check);
          break;
        }
      }
    }

    if (res == null || !res.isTriangle) {
      return "0";
    }

    res.vertexes.sort((a, b) -> {
      if (a[0] == b[0]) {
        return a[1] - b[1];
      }
      return a[0] - b[0];
    });

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < res.vertexes.size(); i++) {
      sb.append(res.vertexes.get(i)[0] + 1).append(" ").append(res.vertexes.get(i)[1] + 1)
          .append("\n");
    }
    return sb.toString();
  }

  private static ResultSet checkTriangle(int sr, int sc, ArrayList<Integer> check) {
    int dIdx = -1;

    for (int d = 0; d < diagonal.length; d++) {
      if (diagonal[d][0] == check.get(0) && diagonal[d][1] == check.get(1)
          && diagonal[d][2] == check.get(2)) {
        dIdx = d;
      }
    }

    if (dIdx == -1) {
      return new ResultSet(null, null, false);
    }

    //1. 증가 방향 찾기
    int[] cd = new int[2];
    if (dIdx == 6) {
      cd = dir[diagonal[dIdx][2]];
    } else if (dIdx == 7) {
      cd = dir[diagonal[dIdx][0]];
    } else {
      cd = dir[diagonal[dIdx][1]];
    }

    //2. 탐색 방향 찾기
    int[][] cdTurn = new int[2][2];
    if (cd[0] == 0 && cd[1] != 0) { // 수평일 때
      cdTurn = new int[][]{{1, 0}, {-1, 0}};
      return getResultSet(sr, sc, cd, cdTurn);
    } else if (cd[1] == 0 && cd[0] != 0) { // 수직일 때
      cdTurn = new int[][]{{0, 1}, {0, -1}};
      return getResultSet(sr, sc, cd, cdTurn);
    } else { //대각선일 때
      cdTurn = new int[][]{{0, cd[1]}, {cd[0], 0}};
      return getResultSetByRight(sr, sc, cdTurn);
    }
  }

  private static ResultSet getResultSetByRight(int sr, int sc, int[][] cdTurn) {
    boolean[][] visited = new boolean[N][N];
    ArrayList<int[]> result = new ArrayList<>();
    result.add(new int[]{sr, sc});
    visited[sr][sc] = true;

    //1. 한변의 길이 구하기
    int len = 0;
    while (true) {
      len++;
      int nr = sr + cdTurn[0][0] * len;
      int nc = sc + cdTurn[0][1] * len;
      if (!isPossible(nr, nc) || inp[nr][nc] != 1) {
        break;
      }
    }

    //2. 직각 이등변삼각형 구하기
    int h;
    for (int i = 0; i < len; i++) {
      int nr = sr + cdTurn[0][0] * i;
      int nc = sc + cdTurn[0][1] * i;
      for (int j = 0; j < len - i; j++) {
        int ntr = nr + cdTurn[1][0] * j;
        int ntc = nc + cdTurn[1][1] * j;
        if (isPossible(ntr, ntc) && inp[ntr][ntc] == 1) {
          visited[ntr][ntc] = true;
        } else {
          return new ResultSet(result, visited, false);
        }
      }
    }
    //3. 직각 이등변삼각형 꼭짓점 구하기
    result.add(new int[]{sr + cdTurn[0][0] * (len - 1), sc + cdTurn[0][1] * (len - 1)});
    result.add(new int[]{sr + cdTurn[1][0] * (len - 1), sc + cdTurn[1][1] * (len - 1)});
    return new ResultSet(result, visited, true);
  }

  private static ResultSet getResultSet(int sr, int sc, int[] cd, int[][] cdTurn) {
    ArrayList<int[]> result = new ArrayList<>();
    boolean[][] visited = new boolean[N][N];
    result.add(new int[]{sr, sc});
    visited[sr][sc] = true;

    int idx = 0;
    while (true) {
      idx++;
      int nr = sr + cd[0] * idx;
      int nc = sc + cd[1] * idx;
      if (!isPossible(nr, nc) || inp[nr][nc] != 1) {
        idx--;
        if (idx != 0) {
          nr = sr + cd[0] * idx;
          nc = sc + cd[1] * idx;
          result.add(new int[]{nr + cdTurn[0][0] * idx, nc + cdTurn[0][1] * idx});
          result.add(new int[]{nr + cdTurn[1][0] * idx, nc + cdTurn[1][1] * idx});
        }
        break;
      }

      visited[nr][nc] = true;
      for (int i = 1; i <= idx; i++) {
        for (int[] cdtDir : cdTurn) {
          int ntr = nr + cdtDir[0] * i;
          int ntc = nc + cdtDir[1] * i;
          if (isPossible(ntr, ntc) && inp[ntr][ntc] == 1) {
            visited[ntr][ntc] = true;
          } else {
            return new ResultSet(result, visited, false);
          }
        }
      }
    }
    return new ResultSet(result, visited, true);
  }

  private static ArrayList<Integer> check(int sr, int sc) {
    ArrayList<Integer> dirList = new ArrayList<>();
    for (int i = 0; i < dir.length; i++) {
      int nr = sr + dir[i][0];
      int nc = sc + dir[i][1];
      if (isPossible(nr, nc) && inp[nr][nc] == 1) {
        dirList.add(i);
      }
    }
    return dirList;
  }


  private static boolean isPossible(int r, int c) {
    return r >= 0 && r < N && c >= 0 && c < N;
  }

  private static class ResultSet {

    ArrayList<int[]> vertexes;
    boolean[][] visited;
    boolean isTriangle;

    public ResultSet(ArrayList<int[]> vertexes, boolean[][] visited, boolean isTriangle) {
      this.vertexes = vertexes;
      this.visited = visited;
      this.isTriangle = isTriangle;
    }
  }
}
