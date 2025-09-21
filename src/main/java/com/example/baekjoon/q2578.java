package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q2578 {

  private static int[][] inp;
  private static int[] res;

  public static void main(String[] args) throws IOException {
    inputData();
    System.out.print(Solution());
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st;
    inp = new int[5][5];
    res = new int[25];

    for (int i = 0; i < 5; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 5; j++) {
        inp[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int i = 0; i < 5; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 5; j++) {
        res[i * 5 + j] = Integer.parseInt(st.nextToken());
      }
    }

    br.close();
  }

  private static int Solution() {

    int ans = 0;
    for (int i = 0; i < 25; i++) {
      ans += find(res[i]);
      if (ans >= 3) {
        return i + 1;
      }
    }
    return -1;
  }

  private static int find(int now) {
    //1. 당첨 자리 찾기
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        if (now == inp[i][j]) {
          inp[i][j] = 0;
          return check(i, j);
        }
      }
    }
    return 0;
  }

  private static int check(int r, int c) {
    //2. 자리 기준 가로, 세로, 대각선 확인
    boolean[] bingo = new boolean[4];
    bingo[0] = true;
    bingo[1] = true;
    bingo[2] = false;
    bingo[3] = false;
    for (int i = 0; i < 5; i++) {
      if (inp[r][i] != 0) {
        bingo[0] = false;
      }
      if (inp[i][c] != 0) {
        bingo[1] = false;
      }
    }

    if (r == c) {
      bingo[2] = true;
      for (int i = 0; i < 5; i++) {
        if (inp[i][i] != 0) {
          bingo[2] = false;
          break;
        }
      }
    }

    if ((4 - r) == c) {
      bingo[3] = true;
      for (int i = 0; i < 5; i++) {
        if (inp[4 - i][i] != 0) {
          bingo[3] = false;
          break;
        }
      }
    }

    int ans = 0;
    for (int i = 0; i < 4; i++) {
      if (bingo[i]) {
        ans++;
      }
    }

    return ans;
  }
}
