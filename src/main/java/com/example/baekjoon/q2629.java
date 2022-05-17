package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q2629 {

  private static int N;
  private static int M;
  private static int maxBall;
  private static int[] grams;
  private static int[] balls;
  private static ArrayList<Integer> list;
  private static boolean[] isCheck;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    output(Solution());
  }

  private static void output(String result) {
    System.out.print(result);
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    grams = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      grams[i] = Integer.parseInt(st.nextToken());
    }

    M = Integer.parseInt(br.readLine());
    balls = new int[M];
    maxBall = 0;
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < M; i++) {
      balls[i] = Integer.parseInt(st.nextToken());
      maxBall = Math.max(maxBall, balls[i]);
    }

    br.close();
  }

  private static String Solution() {
    String answer = "";
    boolean[] result = new boolean[M];

    boolean[] dp = new boolean[40001];
    int max = 0;
    int size = 0;
    Queue<Integer> queue = new ArrayDeque<>();

    for (int i = 0; i < N; i++) {
      size = max;
      for (int j = 1; j <= size; j++) {
        if (dp[j]) {
          if (j + grams[i] <= 40000) {
            queue.add(j + grams[i]);
            max = Math.max(j + grams[i], max);
          }
          if (Math.abs(j - grams[i]) > 0) {
            queue.add(Math.abs(j - grams[i]));
            max = Math.max(j - grams[i], max);
          }
        }
      }
      queue.add(grams[i]);
      max = Math.max(grams[i], max);

      while (!queue.isEmpty()) {
        dp[queue.poll()] = true;
      }
    }

    for (int j = 0; j < balls.length; j++) {
      if (dp[balls[j]]) {
        result[j] = true;
      }
    }

    for (int j = 0; j < M; j++) {
      answer += result[j] ? "Y " : "N ";
    }

//    answer = dpFun();
    return answer;
  }
//
//  private static String dpFun() {
//    isCheck = new boolean[M];
//    list = new ArrayList<>();
//    list.add(0);
//
//    Arrays.sort(grams);
//
//    for (int i = 0; i < N; i++) {
//      int size = list.size();
//
//      for (int j = 0; j < size; j++) {
//
//        if (list.get(j) - grams[i] > maxBall) {
//          break;
//        }
//
//        addList(list.get(j) + grams[i]);
//        addList(Math.abs(list.get(j) - grams[i]));
//      }
//
//      list.sort(Comparator.naturalOrder());
//    }
//
//    StringBuilder sb = new StringBuilder();
//    for (int i = 0; i < M; i++) {
//      sb.append(isCheck[i] ? "Y" : "N").append(" ");
//    }
//    return sb.toString();
//  }
//
//  private static void addList(int gram) {
//    if (gram < 0 || gram > 40000) {
//      return;
//    }
//
//    if (!list.contains(gram)) {
//      list.add(gram);
//
//      if (balls.contains(gram)) {
//        isCheck[balls.indexOf(gram)] = true;
//      }
//
//    }
//  }

}
