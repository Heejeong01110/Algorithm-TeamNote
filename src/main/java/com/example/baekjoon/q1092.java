package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class q1092 {


  private static int N;
  private static int M;
  private static int[] cranes;
  private static int[] boxes;

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
    cranes = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      cranes[i] = Integer.parseInt(st.nextToken());
    }

    M = Integer.parseInt(br.readLine());
    boxes = new int[M];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < M; i++) {
      boxes[i] = Integer.parseInt(st.nextToken());
    }

    br.close();
  }

  private static int Solution() {
    ArrayList<Integer> box2 = new ArrayList<>();
    ArrayList<Integer> crane2 = new ArrayList<>();
    for (int i = 0; i < M; i++) {
      box2.add(boxes[i]);
    }
    box2.sort(Comparator.reverseOrder());

    for (int i = 0; i < N; i++) {
      crane2.add(cranes[i]);
    }
    crane2.sort(Comparator.reverseOrder());

    if (crane2.get(0) < box2.get(0)) {
      return -1;
    }

    int idx = 0;
    while (idx <= M) {
      if (box2.size() == 0) {
        break;
      }

      int cidx = 0;
      int bidx = 0;
      while (bidx < box2.size() && cidx < N) {
        if (crane2.get(cidx) >= box2.get(bidx)) {
          box2.remove(bidx);
          cidx++;
        } else {
          bidx++;
        }
      }
      idx++;
    }

    return idx;
  }


}
