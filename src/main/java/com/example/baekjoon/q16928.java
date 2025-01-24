package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class q16928 {

  private static final int LAB = 0, SNA = 1;
  private static int N, M;
  private static Info info;

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
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    info = new Info();

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      info.insert(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), LAB);
    }
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      info.insert(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), SNA);
    }

    br.close();
  }

  private static int Solution() {
    int answer = 0;
    int[] memo = new int[101];
    PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> {
      if (o1.cnt == o2.cnt) {
        return o2.num - o1.num;
      }
      return o1.cnt - o2.cnt;
    });

    Arrays.fill(memo, Integer.MAX_VALUE);
    memo[1] = 0;
    queue.add(new Node(1, 0));

    while (!queue.isEmpty()) {
      Node now = queue.poll();
      if (now.num == 100) {
        answer = now.cnt;
        break;
      }

      int end = info.getEnd(now.num);
      if (end != -1) {
        if (memo[end] > now.cnt) {
          memo[end] = now.cnt;
          queue.add(new Node(end, now.cnt));
        }
        continue;
      }

      for (int d = 1; d <= 6; d++) {
        int next = now.num + d;

        if (next <= 100 && memo[next] > now.cnt + 1) {
          memo[next] = now.cnt + 1;
          queue.add(new Node(next, now.cnt + 1));
        }
      }

    }

    return answer;
  }

  private static class Node {

    int num;
    int cnt;

    public Node(int num, int cnt) {
      this.num = num;
      this.cnt = cnt;
    }

  }

  private static class Info {

    List<int[]> info;

    public Info() {
      info = new ArrayList<>();
    }

    public void insert(int start, int end, int type) {
      info.add(new int[]{start, end, type});
    }

    public int getEnd(int start) {
      for (int[] i : info) {
        if (i[0] == start) {
          return i[1];
        }
      }
      return -1;
    }
  }

}
