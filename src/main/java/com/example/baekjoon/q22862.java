package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q22862 {

  private static int N, K;
  private static boolean[] inp;

  public static void main(String[] args) throws IOException {
    inputData();
    System.out.print(Solution());
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    inp = new boolean[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(st.nextToken());
      inp[i] = num % 2 == 0;
    }

    br.close();
  }

  private static int Solution() {

    int res = 0;
    int left = 0;
    int right = 0;
    int cnt = 0;
    while (right < N) {
      if (cnt < K) {
        if (!inp[right]) {
          cnt++;
        }
        right++;
        res = Math.max(right - left - cnt, res);
      } else if (inp[right]) {
        right++;
        res = Math.max(right - left - cnt, res);
      } else {
        if (!inp[left]) {
          cnt--;
        }
        left++;
      }
    }

    return res;
  }

}
