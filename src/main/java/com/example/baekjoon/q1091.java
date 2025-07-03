package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class q1091 {

  private static int N;
  private static int[] P, S;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    System.out.print(Solution());
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    P = new int[N];
    S = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      P[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      S[i] = Integer.parseInt(st.nextToken());
    }

    br.close();
  }

  private static int Solution() {

    //1. i가 플레이어 P[i]에게 돌아갈 수 있는지 확인
    ArrayList[] cycleCnt = new ArrayList[N];
    for (int i = 0; i < N; i++) {
      cycleCnt[i] = getCycle(i);
      if (!isContainPlayer(cycleCnt[i], P[i])) {
        return -1;
      }
    }

    //2. 주기가 겹치지 않는 경우인지 확인 --> 어떻게?

    //3. 최소값 구하기
    int[] list = new int[N];
    for (int i = 0; i < N; i++) {
      list[i] = i;
    }

    int cnt = 0;
    while (true) {
      if (correctList(list)) {
        return cnt;
      }
      list = shuffle(list);
      cnt++;

      if (isFirstList(list)) {
        return -1;
      }
    }
  }

  private static boolean isContainPlayer(ArrayList<Integer> cycle, int pi) {
    for (Integer idx : cycle) {
      if (idx % 3 == pi) {
        return true;
      }
    }

    return false;
  }

  private static int[] shuffle(int[] list) {
    int[] res = new int[list.length];
    for (int i = 0; i < N; i++) {
      res[i] = list[S[i]];
    }
    return res;
  }

  private static boolean isFirstList(int[] list) {
    for (int i = 0; i < N; i++) {
      if (list[i] != i) {
        return false;
      }
    }
    return true;
  }

  private static boolean correctList(int[] list) {
    for (int i = 0; i < N; i++) {
      if (list[i] % 3 != P[i]) {
        return false;
      }
    }
    return true;
  }

  private static ArrayList<Integer> getCycle(int idx) {
    ArrayList<Integer> result = new ArrayList<>();
    int now = idx;

    while (true) {
      result.add(now);
      now = S[now];
      if (now == idx) {
        break;
      }
    }
    return result;
  }


}
