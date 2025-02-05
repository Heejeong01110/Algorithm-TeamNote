package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q31092 {

  private static int boardLen; //보드판 크기
  private static int stickerLen; //스티커의 갯수
  private static int strLen; //S의 크기
  private static Node[] nodes;
  private static int[] boardNums; //보드판 스티커의 번호
  private static String str;

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

    boardLen = Integer.parseInt(st.nextToken());
    stickerLen = Integer.parseInt(st.nextToken());
    strLen = Integer.parseInt(st.nextToken());

    nodes = new Node[stickerLen];
    for (int i = 0; i < stickerLen; i++) {
      st = new StringTokenizer(br.readLine());
      String key = st.nextToken();
      nodes[i] = new Node(key, Integer.parseInt(st.nextToken()),
          Integer.parseInt(st.nextToken()));
    }

    boardNums = new int[boardLen];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < boardLen; i++) {
      boardNums[i] = Integer.parseInt(st.nextToken()) - 1;
    }
    str = br.readLine();
    br.close();
  }

  private static int Solution() {
    int minCost = Integer.MAX_VALUE;
    for (int i = 0; i <= boardLen - strLen; i++) {
      //1. 문자열 일치하는부분/아닌부분 분리
      boolean[] stickers = new boolean[boardLen]; // 원래 자리와 일치, 불일치
      int currentCost = 0;
      int[] isChanged = new int[boardLen]; //0:그대로 1:스티커 뗀 자리 2:사용
      for (int j = 0; j < strLen; j++) {
        if (i + j < boardLen && nodes[boardNums[i + j]].alp.equals(str.substring(j, j + 1))) {
          stickers[i + j] = true;
        }
      }

      //2. 아닌부분들 중에서 가지고있는것, 사는것 가격비교해서 붙이기
      for (int j = 0; j < strLen; j++) {
        int sumCost = Integer.MAX_VALUE;
        int nodeNum = getNodeNum(str.substring(j, j + 1));
        int idx = -1;

        if (currentCost > minCost) {
          break;
        }
        if (nodeNum == -1) {
          currentCost = Integer.MAX_VALUE;
          break;
        }
        if (stickers[i + j]) {
          continue;
        }

        //changeCost
        for (int k = 0; k < boardLen; k++) {
          if (!stickers[k] && isChanged[k] != 2
              && nodes[boardNums[k]].alp.equals(nodes[nodeNum].alp)
              && sumCost > nodes[boardNums[k]].delCost) {
            sumCost = nodes[boardNums[k]].delCost;
            idx = k;
          }
        }

        // buyCost
        if (sumCost > nodes[nodeNum].buyCost) {
          sumCost = nodes[nodeNum].buyCost;
        } else if (idx != -1) {
          isChanged[idx] = 2;
        }
        if (isChanged[i + j] == 0) {
          isChanged[i + j] = 1;
          sumCost += nodes[i + j].delCost;
        }
        currentCost += sumCost;
      }
      minCost = Math.min(minCost, currentCost);
    }

    if (minCost == Integer.MAX_VALUE) {
      return -1;
    }

    return minCost;
  }

  private static int getNodeNum(String find) {
    int idx = -1;
    int val = Integer.MAX_VALUE;
    for (int i = 0; i < nodes.length; i++) {
      if (nodes[i].alp.equals(find) && val > nodes[i].buyCost) {
        idx = i;
        val = nodes[i].buyCost;
      }
    }
    return idx;
  }

  private static class Node {

    String alp;//알파벳 소문자
    int delCost;//스티커 제거 비용
    int buyCost;//스티커 구매 비용

    public Node(String alp, int delCost, int buyCost) {
      this.alp = alp;
      this.delCost = delCost;
      this.buyCost = buyCost;
    }
  }

}

//그 중에서 가장 교체 비용이 적은 위치 찾기
//1. 검사중인 문자열 중에서 이미 일치하는 문자와는 교체하면 안됨
//2. 이미 한번 교환한 문자는 다시 사용하지 않도록 해야함.
//3. 교환시 원래 있던 스티커를 따로 체크해둬야함.
