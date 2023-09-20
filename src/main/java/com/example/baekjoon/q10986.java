package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q10986 {

  private static int N, M;
  private static long[] ary;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    ary = new long[N];
    long ans = 0;
    long[] sum = new long[N + 1];
    long[] idxCnt = new long[M];

    sum[0] = 0;
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      ary[i] = Long.parseLong(st.nextToken());
      sum[i + 1] = (sum[i] + ary[i]) % M;
      if (sum[i + 1] == 0) {
        ans++;
      }
      idxCnt[(int) sum[i + 1]] += 1;
    }

    for (int i = 0; i < M; i++) {
      if (idxCnt[i] > 1) {
        ans += (idxCnt[i] * (idxCnt[i] - 1) / 2);
      }
    }
    System.out.print(ans);
    br.close();
  }
}
