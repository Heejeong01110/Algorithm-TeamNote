package com.example.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class s214289 {

  private static int T1, T2;
  private static ArrayList<String> memo;

  public static int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
    int T = onboard.length;
    T1 = t1;
    T2 = t2;
    int answer = 0;
    memo = new ArrayList<>();

    int[][] dp = new int[T][51]; //[]초일 때 [][]도가 되는 최소값

    for (int i = 0; i < T; i++) {
      Arrays.fill(dp[i], Integer.MAX_VALUE);
    }



    PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> {
      if (o1.min == o2.min) {
        return o1.sum - o2.sum;
      }
      return o1.min - o2.min;
    });
    queue.add(new Node(0, temperature, 0));
    memo.add(convStr(0, temperature, 0));

    while (!queue.isEmpty()) {
      Node now = queue.poll();

      if (now.min == T - 1) {
        answer = now.sum;
        break;
      }

      boolean boarding = onboard[now.min + 1] == 1;
      //1. 안틀기
      int temp = now.temp + (temperature == now.temp ? 0 : (temperature > now.temp ? 1 : -1));
      isPossible(queue, boarding, now.min + 1, temp, now.sum);

      //2-1. 틀고 유지(b)
      isPossible(queue, boarding, now.min + 1, now.temp, now.sum + b);

      //2-2. 틀고 변경(a)
      isPossible(queue, boarding, now.min + 1, now.temp + 1, now.sum + a);
      isPossible(queue, boarding, now.min + 1, now.temp - 1, now.sum + a);
    }

    return answer;
  }

  private static int resize(int num) {
    return num + 10;
  }

  private static String convStr(int min, int temp, int sum) {
    return min + "_" + temp + "_" + sum;
  }

  private static void isPossible(PriorityQueue<Node> queue,
      boolean boarding, int min, int temp, int sum) {
    String m = convStr(min, temp, sum);
    if (!memo.contains(m) && (!boarding || temp >= T1 && temp <= T2)) { //승객이 없는경우, 승객이 있고 온도가 권장온도
      queue.add(new Node(min, temp, sum));
      memo.add(m);
    }
  }

  private static class Node {

    int min;
    int temp;
    int sum;

    public Node(int min, int temp, int sum) {
      this.min = min;
      this.temp = temp;
      this.sum = sum;
    }
  }
}
