package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q1285 {

  private static int N;
  private static int[][] map;

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

    N = Integer.parseInt(br.readLine());
    map = new int[N][N];

    for (int i = 0; i < N; i++) {
      String s = br.readLine();
      for (int j = 0; j < N; j++) {
        map[i][j] = s.charAt(j) == 'T' ? 1 : 0;
      }
    }

    br.close();
  }

  private static int Solution() {
    int res = Integer.MAX_VALUE;
    for (int bit = 0; bit < (1 << N); bit++) {
      //어떤 가로줄을 뒤집을 것인지 bit생성
      int sum = 0;

      for (int c = 0; c < N; c++) { //세로로 한줄씩 탐색
        //세로줄을 한 단위로 탐색하지만 비트마스크 체크값은 어떤 가로줄을 뒤집을지를 기준으로 확인
        int T = 0;
        for (int r = 0; r < N; r++) {//위에서부터 하나씩 내려오면서 확인
          int now = map[r][c];
          if ((bit & (1 << r)) != 0) {//뒤집기로 한 열인 경우
            now = (now + 1) % 2;
          }
          T += now;
        }
        //즉, 비트마스크에 의해 가로줄 뒤집기는 결정되어있는 상태로 세로줄을 하나씩 탐색해서 나오는 최소값을 저장
        sum += Math.min(N - T, T);
      }
      res = Math.min(res, sum);
    }
    return res;
  }
}
