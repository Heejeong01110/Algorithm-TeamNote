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
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < boardLen - strLen; i++) { //전체 탐색
      //1. 문자열 일치하는부분/아닌부분 분리
      int[] stickers = new int[strLen]; //0:불일치 1:스티커 뗀 자리 2:일치
      int[] alp = new int[26]; //알파벳 별 남아있는 수

      for (int j = 0; j < strLen; j++) {

        if (nodes[boardNums[i + j]].alp.equals(str.substring(j, j + 1))) {
          stickers[j] = 2;
        } else {
          alp[str.charAt(j) - 'a'] += 1;
        }
      }

      //2. 아닌부분들 중에서 가지고있는것, 사는것 가격비교해서 붙이기
      int cost = 0;
      for (int j = 0; j < strLen; j++) {
        if (cost > min) {
          break;
        }

        if (stickers[j] == 2) {
          continue;
        }

        int minCost = Integer.MAX_VALUE;
        //changeCost
        int nodeNum = getNodeNum(str.substring(j, j + 1), nodes);
        if (nodeNum == -1) {
          break;
        }
        if (alp[nodes[nodeNum].alp.charAt(0) - 'a'] > 0) { //바꿀 알파벳이 남아있을 경우
          //그 중에서 가장 교체 비용이 적은 위치 찾기
          //1. 
          for (int k = 0; k < boardLen; k++) {
            if (nodes[boardNums[k]].alp.equals(nodes[nodeNum].alp)) {
              minCost = Math.min(minCost, nodes[boardNums[k]].delCost);
            }
          }
        }
        // buyCost
        minCost = Math.min(minCost, nodes[nodeNum].buyCost);
        cost += minCost + nodes[nodeNum].delCost;
      }
      min = Math.min(min, cost);
    }

    if (min == Integer.MAX_VALUE) {
      return -1;
    }

    return min;
  }

  private static int getNodeNum(String find, Node[] nodes) {
    for (int i = 0; i < nodes.length; i++) {
      if (nodes[i].alp.equals(find)) {
        return i;
      }
    }
    return -1;
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
