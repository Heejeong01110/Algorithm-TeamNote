package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class q2450 {

  private static int N, M;
  private static int[] inp;

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
    inp = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      inp[i] = Integer.parseInt(st.nextToken());
    }

    br.close();
  }

  private static int Solution() {
    HashMap<Integer, ArrayList<Integer>> shape = new HashMap<>();
    int[] shapeCnt = new int[4];
    for (int i = 0; i < N; i++) {
      shapeCnt[inp[i]]++;
      ArrayList<Integer> ary = shape.getOrDefault(inp[i], new ArrayList<>());
      ary.add(i);
      shape.put(inp[i], ary);
    }

    orderDfs(shape, new int[3], 0);

    return 0;
  }

  private static void orderDfs(HashMap<Integer, ArrayList<Integer>> shape, int[] order, int depth) {
    if (depth == 3) {
      dfs(shape, order);
      return;
    }
    for (int i = 1; i <= 3; i++) {
      order[depth] = i;
      orderDfs(shape, order, depth + 1);
    }
  }

  private static void dfs(HashMap<Integer, ArrayList<Integer>> shape, int[] order) {
    int[] map = inp.clone();
    int shapeIdx = -1, tmp = 0;
    for (int i = 0; i < N; i++) {
      if (i >= tmp) {
        shapeIdx++;
        tmp += shape.get(order[shapeIdx]).size();
      }

      if (map[i] != order[shapeIdx]) {//모양 스위칭 해줘야함
        int nowShape = map[i]; //현재 위치의 모양
        int targetShape = order[shapeIdx]; //바꿔야 하는 모양

        //1. 바꿔야 하는 모양 자리와 현재 자리를 1대1로 바꿔주는 경우
        boolean cngTmp = false;

        int idx = 0; //위치 스위칭할 위치
        int startIdx = getStartIdx(shape, order, targetShape);
        for (int j = 0; j < shape.get(targetShape).size(); j++) {
          if (map[startIdx + j] == targetShape) {
            int save = map[startIdx + j];
            map[startIdx + j] = map[i];
            map[i] = save;
            cngTmp = true;
            break;
          }
        }

        //2. 제3의 자리랑 바꿔주는 경우
        if(cngTmp){

        }
      }


    }
  }

  private static int getStartIdx(HashMap<Integer, ArrayList<Integer>> shape, int[] order,
      int shapeIdx) {
    int res = 0;
    for (int i = 0; i < 3; i++) {
      res += shape.get(order[i]).size();
      if (order[i] == shapeIdx) {
        return res;
      }
    }
    return -1;
  }
}
