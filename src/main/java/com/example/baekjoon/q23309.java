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

    int[] next = new int[1000001];
    int[] prev = new int[1000001];

    //첫역 넣기
    st = new StringTokenizer(br.readLine());
    int first = Integer.parseInt(st.nextToken());
    int pre = first;

    //두번째역부터 마지막역 전까지 넣기
    for (int i = 1; i < N - 1; i++) {
      int station = Integer.parseInt(st.nextToken());
      prev[station] = pre;
      next[pre] = station;
      pre = station;
    }
    //마지막역 넣기
    int last = Integer.parseInt(st.nextToken());
    next[pre] = last;
    prev[last] = pre;
    next[last] = first;
    prev[first] = last;

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < M; i++) {
      String cmd = br.readLine().trim();
      String[] spl = cmd.split(" ");
      int now = Integer.parseInt(spl[1]);

      if (spl[0].equals("BN")) {
        int newS = Integer.parseInt(spl[2]);
        int nextS = next[now];
        sb.append(nextS).append("\n");

        next[now] = newS;
        next[newS] = nextS;
        prev[newS] = now;
        prev[nextS] = newS;
      } else if (spl[0].equals("BP")) {
        int newS = Integer.parseInt(spl[2]);
        int prevS = prev[now];
        sb.append(prevS).append("\n");

        prev[now] = newS;
        prev[newS] = prevS;
        next[prevS] = newS;
        next[newS] = now;
      } else if (spl[0].equals("CN")) {
        int delS = next[now];
        int nextS = next[delS];
        sb.append(delS).append("\n");

        next[now] = nextS;
        prev[nextS] = now;
      } else if (spl[0].equals("CP")) {
        int delS = prev[now];
        int prevS = prev[delS];
        sb.append(delS).append("\n");

        prev[now] = prevS;
        next[prevS] = now;
      }
    }
    System.out.print(sb);
    br.close();
  }

}
