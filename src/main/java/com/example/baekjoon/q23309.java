package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q23309 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    //2단 배열로 만들어서 시간초과난거같음 -> 그래서 1단 배열로 전역과 다음역을 나타내는 역 2개만듬
    int[] preArr = new int[1000001];
    int[] postArr = new int[1000001];

    //첫역 넣기
    int firstStation = Integer.parseInt(st.nextToken());
    int prevStation = firstStation;

    //두번째역부터 마지막역 전까지 넣기
    for (int i = 1; i < N - 1; i++) {
      int station = Integer.parseInt(st.nextToken());
      preArr[station] = prevStation;
      postArr[prevStation] = station;
      prevStation = station;
    }
    //마지막역 넣기
    int LastStation = Integer.parseInt(st.nextToken());
    postArr[prevStation] = LastStation;
    preArr[LastStation] = prevStation;
    postArr[LastStation] = firstStation;
    preArr[firstStation] = LastStation;

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      String str = st.nextToken();
      int curStation = Integer.parseInt(st.nextToken());
      if (str.contains("BN")) {
        int newStation = Integer.parseInt(st.nextToken());
        int nextStation = postArr[curStation];
        sb.append(nextStation).append("\n");
        postArr[curStation] = newStation;
        preArr[newStation] = curStation;
        postArr[newStation] = nextStation;
        preArr[nextStation] = newStation;
      } else if (str.contains("BP")) {
        int newStation = Integer.parseInt(st.nextToken());
        int beStation = preArr[curStation];
        sb.append(beStation).append("\n");
        postArr[beStation] = newStation;
        preArr[newStation] = beStation;
        postArr[newStation] = curStation;
        preArr[curStation] = newStation;
      } else if (str.contains("CN")) {
        int nextStation = postArr[curStation];
        sb.append(nextStation).append("\n");
        int nextNextStation = postArr[nextStation];
        postArr[curStation] = nextNextStation;
        preArr[nextNextStation] = curStation;
      } else if (str.contains("CP")) {
        int beStation = preArr[curStation];
        sb.append(beStation).append("\n");
        int beBeStation = preArr[beStation];
        preArr[curStation] = beBeStation;
        postArr[beBeStation] = curStation;
      }
    }
    System.out.println(sb);
  }


}
