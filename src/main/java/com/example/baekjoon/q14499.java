package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q14499 {

  private static final int[][] direct = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
  private static int N;
  private static int M;
  private static int x;
  private static int y;
  private static int K;
  private static int[][] map;
  private static int[] input;
  private static int[] Dice;
  private static StringBuilder sb;

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
    x = Integer.parseInt(st.nextToken());
    y = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    map = new int[N][M];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    input = new int[K];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < K; i++) {
      input[i] = Integer.parseInt(st.nextToken()) - 1;
    }

    br.close();
  }

  private static void Solution() {
    sb = new StringBuilder();
    Dice = new int[6];
    for (int i = 0; i < K; i++) {
      int nx = x + direct[input[i]][0];
      int ny = y + direct[input[i]][1];
      if (isPossible(nx, ny)) {
        sb.append(calc(nx, ny, input[i])).append("\n");
      }
    }
    System.out.print(sb.toString());
    return;
  }

  private static boolean isPossible(int nx, int ny) {
    return nx >= 0 && nx < N && ny >= 0 && ny < M;
  }

  private static int calc(int nx, int ny, int dir) {
    turnDice(dir);
    x = nx;
    y = ny;
    if (map[nx][ny] == 0) {//이동한 칸의 수가 0일 경우
      map[nx][ny] = Dice[3]; //주사위 바닥면 복사
    } else {
      Dice[3] = map[nx][ny]; //주사위에 쓰고 지도에서 삭제
      map[nx][ny] = 0;
    }
    return Dice[1];
  }

  private static void turnDice(int dir) {
    //direct = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    // 2,1,5,6,4,3
    //   북/맨 위/남/맨 아래/서/동
    int[] nDice = new int[6];
    switch (dir) {
      case 0: //동
        nDice[0] = Dice[0];//북
        nDice[2] = Dice[2];//남
        nDice[4] = Dice[3];//서
        nDice[1] = Dice[4];//맨위
        nDice[5] = Dice[1];//동
        nDice[3] = Dice[5];//맨아래
        break;
      case 1://서
        nDice[0] = Dice[0];//북
        nDice[2] = Dice[2];//남
        nDice[4] = Dice[1];//서
        nDice[1] = Dice[5];//맨위
        nDice[5] = Dice[3];//동
        nDice[3] = Dice[4];//맨아래
        break;
      case 2://북
        nDice[4] = Dice[4];//서
        nDice[5] = Dice[5];//동
        nDice[0] = Dice[1];//북
        nDice[1] = Dice[2];//맨위
        nDice[2] = Dice[3];//남
        nDice[3] = Dice[0];//맨아래
        break;
      case 3://남
        nDice[4] = Dice[4];//서
        nDice[5] = Dice[5];//동
        nDice[0] = Dice[3];//북
        nDice[1] = Dice[0];//맨위
        nDice[2] = Dice[1];//남
        nDice[3] = Dice[2];//맨아래
        break;
      default:
        break;
    }
    Dice = nDice;
  }


}
