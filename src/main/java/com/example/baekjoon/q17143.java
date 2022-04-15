package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class q17143 {

  private static int R;
  private static int C;
  private static int M;
  private static int[][] direct = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}}; //상좌하우
  private static ArrayList<Shark> sharks;
  private static Shark[][] map;

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
    M = Integer.parseInt(st.nextToken());
    sharks = new ArrayList<>();
    map = new Shark[R][C];
    for (int i = 0; i < M; i++) {
    }
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int r = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      int s = Integer.parseInt(st.nextToken());
      int d = Integer.parseInt(st.nextToken());
      int z = Integer.parseInt(st.nextToken());

      if (d == 1) {
        d = 0;
      } else if (d == 4) {
        d = 1;
      }

      sharks.add(new Shark(r - 1, c - 1, s, d, z));
      map[r - 1][c - 1] = sharks.get(i);
    }

    br.close();
  }

  private static int Solution() {

    int result = 0;
    PriorityQueue<Shark> sizeQueue;

    //1.
    for (int i = 0; i < C; i++) {
      //2.
      for (int j = 0; j < R; j++) {
        if (map[j][i] != null) {
          result += map[j][i].size;
          sharks.remove(map[j][i]);
          map[j][i] = null;
          break;
        }
      }

      //3.
      sizeQueue = new PriorityQueue<>((o1, o2) -> o2.size - o1.size);
      sizeQueue.addAll(sharks);

      map = new Shark[R][C];
      sharks = new ArrayList<>();

      while (!sizeQueue.isEmpty()) {
        Shark now = sizeQueue.poll();

        int speed = now.speed;
        if (now.direct % 2 == 0) {
          speed %= (R - 1) * 2;
        } else {
          speed %= (C - 1) * 2;
        }

        for (int s = 0; s < speed; s++) {
          // 현재 r, c에 방향에 맞게 1칸씩 추가하며 위치 이동
          int newR = now.row + direct[now.direct][0];
          int newC = now.col + direct[now.direct][1];

          // 이동할 새로운 위치가 범위를 벗어나 벽에 부딪히면
          if (newR < 0 || newR >= R || newC < 0 || newC >= C) {
            now.row -= direct[now.direct][0]; // 다시 값 돌려주고
            now.col -= direct[now.direct][1];
            now.direct = (now.direct + 2) % 4; // 방향 반대로
            continue;
          }

          // 위치 벗어나지 않을때는 새로운 위치로 이동
          now.row = newR;
          now.col = newC;
        }
        if(map[now.row][now.col]== null) { // 이미 상어가 있다면 두 상어 크기 비교
          map[now.row][now.col] = new Shark(now.row, now.col, now.speed, now.direct, now.size);
          sharks.add(map[now.row][now.col]);
        }

      }

    }
    return result;
  }

  private static class Shark {

    int row;
    int col;
    int speed;
    int direct;
    int size;

    public Shark(int row, int col, int speed, int direct, int size) {
      this.row = row;
      this.col = col;
      this.speed = speed;
      this.direct = direct;
      this.size = size;
    }
  }
}
