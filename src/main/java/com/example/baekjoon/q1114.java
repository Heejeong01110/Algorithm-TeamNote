package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q1114 {

  private static int L, K, C;
  private static int[] inp;

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
    L = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    inp = new int[K];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < K; i++) {
      inp[i] = Integer.parseInt(st.nextToken());
    }

    br.close();
  }

  private static void Solution() {
    Arrays.sort(inp);
    ArrayList<Integer> part = new ArrayList<>();
    part.add(inp[0]);
    for (int i = 1; i < K; i++) {
      part.add(inp[i] - inp[i - 1]);
    }
    part.add(L - inp[K - 1]);

    int start = 0;
    int end = L;
    int mid = (start + end) / 2;

    while (start < end) {
      mid = (start + end) / 2;

      if (isPossible(part, mid)) {
        end = mid;
      } else {
        start = mid + 1;
      }
    }

    System.out.print(start + " ");
    int sum = 0;
    int cnt = 0;
    for (int i = part.size() - 1; i >= 0; i--) {
      if (sum + part.get(i) <= mid) {
        sum += part.get(i);
      } else {
        cnt++;
        sum = part.get(i);
      }
    }

    if (cnt < C) {
      System.out.print(part.get(0));
    }else{
      System.out.print(sum);
    }
  }

  private static boolean isPossible(ArrayList<Integer> part, int max) {
    int sum = 0;
    int cnt = 0;
    for (int i = 0; i < part.size(); i++) {
      if (sum + part.get(i) <= max) {
        sum += part.get(i);
      } else if (cnt < C) {
        cnt++;
        if (part.get(i) <= max) {
          sum = part.get(i);
        } else {
          return false;
        }
      } else {
        return false;
      }
    }
    return true;
  }

}
