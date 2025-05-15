package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class q14865 {

  private static int N;
  private static int[][] inp;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    System.out.print(Solution());
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine()); //10^6개
    inp = new int[N + 1][2]; //-10^9 ~ 10^9
    StringTokenizer st;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      inp[i][0] = Integer.parseInt(st.nextToken());
      inp[i][1] = Integer.parseInt(st.nextToken());
    }

    br.close();
  }

  private static String Solution() {
    inp[N][0] = inp[0][0];
    inp[N][1] = inp[0][1];
    ArrayList<int[]> peaks = new ArrayList<>();

    //1. 봉우리 정보 모두 구하기
    int y = inp[0][1];
    int match = 0;
    int tmp = 0; //맨 처음 교차점이 내려가는 선일 경우 저장
    boolean isProcess = false;
    for (int i = 1; i <= N; i++) {
      if (y == inp[i][1] || // 가로로 움직이는 경우
          y < 0 && inp[i][1] < 0 || // 아래쪽 영역에서만 움직이는 경우
          y > 0 && inp[i][1] > 0) { //윗쪽 영역에서만 움직이는 경우
        y = inp[i][1];
        continue;
      }
      if (y < 0) { //봉우리가 시작하는 지점
        match = inp[i][0];
        isProcess = true;
      } else {//봉우리가 끝나는 지점
        if (!isProcess) {
          tmp = inp[i][0];
        } else {
          peaks.add(new int[]{Math.min(match, inp[i][0]), Math.max(match, inp[i][0])});
          isProcess = false;
        }
      }
      y = inp[i][1];
    }
    if (isProcess) {
      peaks.add(new int[]{Math.min(match, tmp), Math.max(match, tmp)});
    }

    //2. 봉우리 조건 체크 -> 직선이 크로스 하는 경우가 없으므로 봉우리도 완전히 속하는 경우만 존재함.
    int topCnt = 0;
    int downCnt = 0;

    peaks.sort((o1, o2) -> o1[0] - o2[0]);
    Deque<int[]> deque = new ArrayDeque<>();
    int idx = 0;
    while (idx < peaks.size()) {
      int now = peaks.get(idx)[1];
      //1. 가장 높은 봉우리에 속한 봉우리들 모두 담기
      topCnt++;
      while (idx < peaks.size() && peaks.get(idx)[1] <= now) {
        deque.add(peaks.get(idx++));
      }
      //2. 가장 낮은 봉우리들 찾기
      while (!deque.isEmpty()) {
        int[] pop = deque.pollFirst();
        if (deque.isEmpty()
            || !(pop[0] < deque.peekFirst()[0]
            && deque.peekFirst()[1] < pop[1])) { //본인이 가장 작은 봉우리일때
          downCnt += 1;
        }
      }
    }
    return topCnt + " " + downCnt;
  }
}
