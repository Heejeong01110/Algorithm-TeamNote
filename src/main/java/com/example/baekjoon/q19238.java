package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class q19238 {

  private static int N, M, F;
  private static Node start;
  private static Node[] goals;
  private static int[][] map, p_map;
  private static int[][] dir = new int[][]{{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

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
    N = Integer.parseInt(st.nextToken()); //맵 크기
    M = Integer.parseInt(st.nextToken()); //승객 수
    F = Integer.parseInt(st.nextToken()); //초기 연료
    p_map = new int[N + 1][N + 1]; //승객 정보 맵
    map = new int[N + 1][N + 1]; //벽 정보 맵

    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    st = new StringTokenizer(br.readLine());
    start = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0, false);
    goals = new Node[M + 1];

    for (int i = 1; i <= M; i++) {
      st = new StringTokenizer(br.readLine());
      p_map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = i;
      goals[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0,
          false);
    }

    br.close();
  }

  private static int Solution() {

    PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> {
      if (o1.value == o2.value) {
        if (o1.row == o2.row) {
          return o1.col - o2.col;
        }
        return o1.row - o2.row;
      }
      return o1.value - o2.value;
    });
    queue.add(start);

    boolean[] complete = new boolean[M + 1];
    boolean[][] visited = new boolean[N + 1][N + 1];
    visited[start.row][start.col] = true;
    int now_goal = -1;

    while (!queue.isEmpty()) {
      Node now = queue.poll();

      if (isEnd(complete)) {
        return F; //모두 데려다 준 경우
      }

      if (!now.working) { //승객 찾는 중

        //승객 위치 도착
        if (p_map[now.row][now.col] != 0 && !complete[p_map[now.row][now.col]]) {
          //승객 탐색 목록 삭제
          queue.clear();

          //연료 내에 도착했는지 확인
          if (now.value > F) {
            return -1;
          }

          F -= now.value;
          now_goal = p_map[now.row][now.col];
          visited = new boolean[N + 1][N + 1];
          visited[now.row][now.col] = true;
          queue.add(new Node(now.row, now.col, 0, true));

        } else {//찾는중
          for (int i = 0; i < dir.length; i++) {
            int nr = now.row + dir[i][0];
            int nc = now.col + dir[i][1];

            if (isPossible(nr, nc) && map[nr][nc] == 0 && !visited[nr][nc]) {
              visited[nr][nc] = true;
              queue.add(new Node(nr, nc, now.value + 1, false));
            }
          }
        }

      } else { //목적지 찾는 중
        if (now.row == goals[now_goal].row && now.col == goals[now_goal].col) { //목적지 도착
          queue.clear();//목적지 탐색 목록 삭제
          if (now.value > F) {//연료 내에 도착했는지 확인
            return -1;
          }
          F += now.value;
          complete[now_goal] = true;
          visited = new boolean[N + 1][N + 1];
          visited[now.row][now.col] = true;
          queue.add(new Node(now.row, now.col, 0, false));
          now_goal = -1;

        } else {//찾는중
          for (int i = 0; i < dir.length; i++) {
            int nr = now.row + dir[i][0];
            int nc = now.col + dir[i][1];

            if (isPossible(nr, nc) && map[nr][nc] == 0 && !visited[nr][nc]) {
              visited[nr][nc] = true;
              queue.add(new Node(nr, nc, now.value + 1, true));
            }
          }
        }
      }
    }

    return -1;
  }

  private static boolean isPossible(int r, int c) {
    return r >= 1 && r <= N && c >= 1 && c <= N;
  }

  private static boolean isEnd(boolean[] visited) {
    for (int i = 1; i <= M; i++) {
      if (!visited[i]) {
        return false;
      }
    }
    return true;
  }

  private static class Node {

    int row;
    int col;
    int value;
    boolean working;

    public Node(int row, int col, int value, boolean working) {
      this.row = row;
      this.col = col;
      this.value = value;
      this.working = working;
    }
  }

}
