package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
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

    for (int i = 0; i < strLen; i++) {
      if (getNodeNum(str.substring(i, i + 1)) == -1) {
        return -1;
      }
    }

    for (int n = 0; n <= boardLen - strLen; n++) {
      int currentCost = 0;
      List<String> attach = new ArrayList<>();
      int[] state = new int[boardLen]; //0:사용X 1:사용O 2:일치
      for (int i = 0; i < strLen; i++) { //일치하지 않는 스티커 모두 제거
        String now = nodes[boardNums[n + i]].alp;
        if (str.substring(i, i + 1).equals(now)) {
          state[n + i] = 2;
        } else {
          attach.add(now);
          currentCost += nodes[boardNums[n + i]].delCost;
        }
      }

      for (int i = 0; i < strLen; i++) { //빈자리 채우기
        if (state[n + i] != 2) {
          //1번과 2번 방법중 선택해야함.
          String now = str.substring(i, i + 1);
          if (attach.contains(now)) { //제거한 스티커 중 있는지
            attach.remove(now);
            state[n + i] = 2;
            continue;
          }

          int delCost = Integer.MAX_VALUE;
          int idx = -1;
          for (int j = 0; j < boardLen; j++) { //제거안한 스티커중 있는지
            if (j >= n && j < n + strLen) {
              continue;
            }

            if (now.equals(nodes[boardNums[j]].alp)
                && state[j] == 0) {
              delCost = nodes[boardNums[j]].delCost;
              idx = j;
              break;
            }
          }

          //새로 구매
          int nodeNum = getNodeNum(now);
          state[n + i] = 2;
          if (delCost < nodes[nodeNum].buyCost) {
            state[idx] = 1;
            currentCost += delCost;
          } else {
            currentCost += nodes[nodeNum].buyCost;
          }

        }
      }

      if (minCost > currentCost) {
        minCost = currentCost;
      }


    }

    return minCost == Integer.MAX_VALUE ? -1 : minCost;
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
