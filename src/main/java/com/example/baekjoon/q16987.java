package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q16987 {

  static int N;
  static int[] dura;
  static int[] weight;
  static int max = Integer.MIN_VALUE;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    N = Integer.parseInt(br.readLine());
    dura = new int[N];
    weight = new int[N];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      dura[i] = Integer.parseInt(st.nextToken()); // 계란의 내구도
      weight[i] = Integer.parseInt(st.nextToken()); // 계란의 무게
    }

    bt(0, 0); // 0번째 계란부터 시작 , 이 땐 깨진 계란 0개

    System.out.println(max);
  }

  static void bt(int idx, int cnt) {
    if (idx == N) {
      // 최댓값 갱신
      max = Math.max(max, cnt);
      return;
    }
    if (dura[idx] <= 0 || cnt == N - 1) {
      bt(idx + 1, cnt);
      return;
    }
    int nCnt = cnt;
    for (int i = 0; i < N; i++) {
      if (i == idx) {
        continue;
      }
      if (dura[i] <= 0) {
        continue;
      }
      hitEgg(idx, i);
      if (dura[idx] <= 0) {
        cnt++;
      }
      if (dura[i] <= 0) {
        cnt++;
      }
      bt(idx + 1, cnt);
      recoveryEgg(idx, i);
      cnt = nCnt;
    }
  }

  static void hitEgg(int handEgg, int targetEgg) {
    dura[targetEgg] -= weight[handEgg];
    dura[handEgg] -= weight[targetEgg];
  }

  static void recoveryEgg(int handEgg, int targetEgg) {
    dura[targetEgg] += weight[handEgg];
    dura[handEgg] += weight[targetEgg];
  }
}
