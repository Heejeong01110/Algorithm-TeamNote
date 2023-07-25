package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class q24042 {

  private static int N;
  private static int M;
  private static int[][] nums;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    output(Solution());
  }

  private static void output(long result) {
    System.out.print(result);
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    nums = new int[M][2];

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      nums[i][0] = Integer.parseInt(st.nextToken());
      nums[i][1] = Integer.parseInt(st.nextToken());
    }

    br.close();
  }

  private static long Solution() {

    HashMap<Integer, ArrayList<Node>> map = new HashMap<>();

    for (int i = 0; i < M; i++) {
      ArrayList<Node> one = map.getOrDefault(nums[i][0], new ArrayList<>());
      ArrayList<Node> two = map.getOrDefault(nums[i][1], new ArrayList<>());

      one.add(new Node(nums[i][1], i));
      two.add(new Node(nums[i][0], i));

      map.put(nums[i][0], one);
      map.put(nums[i][1], two);

    }

    PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> Long.compare(o1.time, o2.time));
    long[] costs = new long[N + 1];
    queue.add(new Node(1, 0));
    Arrays.fill(costs, Long.MAX_VALUE);
    costs[1] = 0;

    long res = 0;
    while (!queue.isEmpty()) {
      Node now = queue.poll();

      if (now.idx == N) {
        res = now.time;
        break;
      }

      int size = map.containsKey(now.idx) ? map.get(now.idx).size() : 0;
      for (int i = 0; i < size; i++) {
        Node next = map.get(now.idx).get(i);
        //도착 시간
        long t =
            ((now.time % M > next.time) ? (now.time / M) + 1 : now.time / M) * M + next.time + 1;

        if (costs[next.idx] > t) { //도착 시간
          costs[next.idx] = t;
          queue.add(new Node(next.idx, t));
        }
      }
    }

    return res;
  }

  private static class Node {

    int idx;
    long time;

    public Node(int idx, long time) {
      this.idx = idx;
      this.time = time;
    }
  }


}
