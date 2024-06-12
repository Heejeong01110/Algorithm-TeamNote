package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class q2515 {

  private static int N, S;
  private static long ans;
  private static ArrayList<Art> inp;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    System.out.print(Solution());
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    S = Integer.parseInt(st.nextToken());
    inp = new ArrayList<>();
    ans = 0;

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      inp.add(new Art(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
    }

    br.close();
  }

  private static int Solution() {
    inp.sort((o1, o2) -> {
      if (o1.H == o2.H) {
        return o1.C - o2.C;
      }
      return o1.H - o2.H;
    });
    int[][] dp = new int[N][2];
    dp[0][0] = 0;
    dp[0][1] = inp.get(0).C;

    int max = dp[0][1];

    for (int i = 1; i < N; i++) {
      dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
      dp[i][1] = inp.get(i).C;

      int start = 0;
      int end = i - 1;
      int mid = 0;

      while (start <= end) {
        mid = (start + end) / 2;
        if (inp.get(i).H - inp.get(mid).H >= S && inp.get(i).H - inp.get(mid + 1).H < S) {
          break;
        } else if (inp.get(i).H - inp.get(mid).H >= S && inp.get(i).H - inp.get(mid + 1).H >= S) {
          start = mid + 1;
        } else if (inp.get(i).H - inp.get(mid).H < S) {
          end = mid - 1;
        }
      }
      if (inp.get(i).H - inp.get(mid).H >= S) {
        dp[i][1] += Math.max(dp[mid][0], dp[mid][1]);
      }

    }

    return Math.max(dp[N - 1][0], dp[N - 1][1]);
  }

  private static class Art {

    int H;
    int C;

    public Art(int h, int c) {
      H = h;
      C = c;
    }
  }

}
