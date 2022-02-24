package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//체스판 다시 칠하기
public class q1018 {

  private static Integer N;
  private static Integer M;
  private static int[][] board;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    output(Solution());
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    board = new int[N][M];

    for (int i = 0; i < N; i++) {
      String str = br.readLine();
      for (int j = 0; j < M; j++) {
        board[i][j] = str.charAt(j) == 'W' ? 1 : 0;
      }
    }

    br.close();
  }

  private static Integer Solution() {
    int answer = Integer.MAX_VALUE;

    for (int i = 0; i <= N - 8; i++) {
      for (int j = 0; j <= M - 8; j++) {
        Integer changeNumber = checkBoard(i, j);
        answer = Math.min(answer, changeNumber);
      }
    }

    return answer;
  }

  private static Integer checkBoard(int row, int col) {
    Integer startColor1 = board[row][col];
    Integer startColor2 = (board[row][col] + 1) % 2;
    Integer changeCount1 = 0;
    Integer changeCount2 = 0;

    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        if (startColor1 != board[row + i][col + j]) {
          changeCount1++;
        }
        if (startColor2 != board[row + i][col + j]) {
          changeCount2++;
        }
        startColor1 = (startColor1 + 1) % 2;
        startColor2 = (startColor2 + 1) % 2;
      }
      startColor1 = (startColor1 + 1) % 2;
      startColor2 = (startColor2 + 1) % 2;
    }

    return Math.min(changeCount1, changeCount2);
  }

  private static void output(Integer result) {
    System.out.print(result);
  }

}
