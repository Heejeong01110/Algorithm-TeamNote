package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class q2437 {

  private static int N;
  private static ArrayList<Integer> nums;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    output(Solution());
  }

  private static void output(long result) {
    System.out.print(result);
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    nums = new ArrayList<>();

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      nums.add(Integer.parseInt(st.nextToken()));
    }

    br.close();
  }

  private static long Solution() {
    nums.sort(Comparator.naturalOrder());
    if (!nums.contains(1)) {
      return 1;
    }
    long repNum = 1;
    for (int i = 1; i < N; i++) {
      int now = nums.get(i);
      if (now <= repNum + 1) {//1. 연속되는 수
        repNum += now;
      } else {//2. 안생기는 경우
        return repNum + 1;
      }
    }

    return repNum + 1;
  }

}
