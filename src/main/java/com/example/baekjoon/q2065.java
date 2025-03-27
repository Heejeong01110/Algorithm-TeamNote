package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class q2065 {

  private static int N, M, t, loc, time;
  private static Node[] node;
  private static PriorityQueue<int[]>[] docks;
  private static Queue<int[]> boat;
  private static int[] memo;

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
    M = Integer.parseInt(st.nextToken());
    t = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    node = new Node[N];
    docks = new PriorityQueue[2];
    docks[0] = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
    docks[1] = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      node[i] = new Node(Integer.parseInt(st.nextToken()), st.nextToken().equals("left") ? 0 : 1);
      docks[node[i].loc].add(new int[]{i, node[i].time});
    }

    br.close();
  }

  private static String Solution() {
    StringBuilder sb = new StringBuilder();
    boat = new LinkedList<>();
    memo = new int[N];
    loc = 0;
    time = 0;

    while (!docks[0].isEmpty() || !docks[1].isEmpty()) {
      if (!tryLoad()) {
        waitPassenger();
        tryLoad();
      }
      moveShip();
    }

    for (int i = 0; i < N; i++) {
      sb.append(memo[i]).append("\n");
    }

    return sb.toString();
  }

  private static void moveShip() {
    time += t;
    while (!boat.isEmpty()) {
      int[] now = boat.poll();
      memo[now[0]] = time;
    }
    loc = (loc + 1) % 2;
  }

  private static void waitPassenger() {
    if (docks[0].isEmpty()) {
      time = Math.max(time, docks[1].peek()[1]);
      return;
    }

    if (docks[1].isEmpty()) {
      time = Math.max(time, docks[0].peek()[1]);
      return;
    }

    time = Math.min(time, Math.min(docks[0].peek()[1], docks[1].peek()[1]));
  }

  private static boolean tryLoad() {
    if (docks[loc].isEmpty()) {
      return false;
    }

    while (!docks[loc].isEmpty()) {
      if (docks[loc].peek()[1] > time) {
        break;
      }
      int[] now = docks[loc].poll();
      boat.add(now);
      if (boat.size() == M) {
        return true;
      }
    }
    return !boat.isEmpty();
  }

  private static class Node {

    int time;
    int loc;

    public Node(int time, int loc) {
      this.time = time;
      this.loc = loc;
    }
  }
}
