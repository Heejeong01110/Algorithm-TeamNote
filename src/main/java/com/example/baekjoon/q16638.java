package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class q16638 {

  private static int N;
  private static String inp;
  private static long ans;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    System.out.print(Solution());
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    inp = br.readLine();

    br.close();
  }

  private static long Solution() {
    ans = Long.MIN_VALUE;
    dfs(1, inp.length(), new boolean[inp.length()]);

    return ans;
  }

  private static void dfs(int idx, int n, boolean[] visited) {
    if (idx == n) {
      ans = Math.max(ans, calc(visited));
      return;
    }

    if (idx == 1 || !visited[idx - 2]) {
      visited[idx] = true;
      dfs(idx + 2, n, visited);
      visited[idx] = false;
    }
    dfs(idx + 2, n, visited);

  }

  private static Long calc(boolean[] parentheses) {

    String now = inp;
    Deque<String> queue1 = new LinkedList<>();
    Deque<Boolean> queue2 = new LinkedList<>();
    for (int i = 0; i < now.length(); i++) {
      queue1.add(now.substring(i, i + 1));
      queue2.add(parentheses[i]);
    }

    //1. 괄호 계산
    while (!queue2.isEmpty()) {
      String now1 = queue1.pollFirst();
      boolean now2 = queue2.pollFirst();

      if (now2) {
        queue1.addLast(calc(queue1.pollLast(), now1, queue1.pollFirst()));
        queue2.pollFirst();
      }else{
        queue1.addLast(now1);
      }
    }

    //2. 곱셈 계산
    Deque<String> queue3 = new LinkedList<>();
    while (!queue1.isEmpty()) {
      String now1 = queue1.pollFirst();

      if (now1.equals("*")) {
        queue3.add(calc(queue3.pollLast(), now1, queue1.pollFirst()));
      } else {
        queue3.add(now1);
      }
    }

    //3. 나머지 계산
    String answer = queue3.pollFirst();
    while (!queue3.isEmpty()) {
      String now1 = queue3.pollFirst();
      String now2 = queue3.pollFirst();
      answer = calc(answer, now1, now2);
    }

    return Long.parseLong(answer);
  }

  private static String calc(String a, String b, String c) {
    long one = Long.parseLong(a);
    long two = Long.parseLong(c);
    if (b.equals("+")) {
      return String.valueOf(one + two);
    } else if (b.equals("-")) {
      return String.valueOf(one - two);
    } else if (b.equals("*")) {
      return String.valueOf(one * two);
    }
    return "";
  }

}
