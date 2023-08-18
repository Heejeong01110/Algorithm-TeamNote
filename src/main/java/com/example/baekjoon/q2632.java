package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class q2632 {

  private static int T, m, n, ans;
  private static ArrayList<Integer>[] pieces;

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

    T = Integer.parseInt(br.readLine());

    StringTokenizer st = new StringTokenizer(br.readLine());
    m = Integer.parseInt(st.nextToken());
    n = Integer.parseInt(st.nextToken());

    pieces = new ArrayList[2];
    pieces[0] = new ArrayList<>();
    for (int i = 0; i < m; i++) {
      pieces[0].add(Integer.parseInt(br.readLine()));
    }

    pieces[1] = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      pieces[1].add(Integer.parseInt(br.readLine()));
    }

    br.close();
  }

  private static int Solution() {
    //1. 두 조각 이상일 경우 연속된 조각 판매
    //2. 피자 조각의 크기 합이 주문한 크기가 되어야 함
    ans = 0;
    HashMap<Integer, Integer>[] piecesMap = new HashMap[2];
    piecesMap[0] = getPiecesMap(0, m);
    piecesMap[1] = getPiecesMap(1, n);

    for (int key : piecesMap[0].keySet()) {
      if (key >= T || !piecesMap[1].containsKey(T - key)) {
        continue;
      }

      int a = piecesMap[0].get(key);
      int b = piecesMap[1].get(T - key);
      ans += a * b;
    }

    if (piecesMap[0].containsKey(T)) {
      ans += piecesMap[0].get(T);
    }
    if (piecesMap[1].containsKey(T)) {
      ans += piecesMap[1].get(T);
    }

    return ans;
  }

  private static HashMap<Integer, Integer> getPiecesMap(int idx, int size) {
    HashMap<Integer, Integer> map = new HashMap<>();
    int totalSize = 0;
    for (int i = 0; i < size; i++) {
      totalSize += pieces[idx].get(i);
    }
    map.put(totalSize, 1);

    for (int i = 0; i < size; i++) {
      int sum = 0;
      for (int j = 0; j < size - 1; j++) {
        sum += pieces[idx].get((i + j) % size);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
      }
    }
    return map;
  }


}
