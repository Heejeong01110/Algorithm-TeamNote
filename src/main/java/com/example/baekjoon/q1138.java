package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class q1138 {

  private static int N;
  private static int[][] inp;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    Solution();
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    inp = new int[N][2];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      inp[i][0] = i + 1;
      inp[i][1] = Integer.parseInt(st.nextToken());
    }

    br.close();
  }

  private static void Solution() {

    PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
      if (o1[1] == o2[1]) {
        return o2[0] - o1[0];
      }
      return o1[1] - o2[1];
    });

    for (int i = 0; i < N; i++) {
      queue.add(inp[i]);
    }

    ArrayList<int[]> res = new ArrayList<>();
    res.add(queue.poll());

    while (!queue.isEmpty()) {
      int idx = 0;
      int cnt = 0;
      int[] now = queue.poll();
      while (idx <= res.size()) {
        if (cnt == now[1] || idx == res.size()) {
          res.add(idx, now);
          break;
        }
        if (res.get(idx)[0] > now[0]) {
          cnt++;
        }
        idx++;
      }
    }

    for (int i = 0; i < N; i++) {
      System.out.print(res.get(i)[0] + " ");
    }
  }
}
