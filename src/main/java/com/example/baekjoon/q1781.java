package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class q1781 {

  private static int N;
  private static long Days;
  private static ArrayList<Node> questions;

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

    StringTokenizer st;
    N = Integer.parseInt(br.readLine());
    Days = 0;
    questions = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int deadline = Integer.parseInt(st.nextToken());
      int ramen = Integer.parseInt(st.nextToken());
      questions.add(new Node(deadline, ramen));
      Days = Math.max(Days, questions.get(i).deadline);
    }

    br.close();
  }

  private static long Solution() {

    questions.sort((o1, o2) -> {
      if (o1.deadline == o2.deadline) {
        return o2.ramen - o1.ramen;
      }
      return o1.deadline - o2.deadline;
    });

    PriorityQueue<Integer> queue = new PriorityQueue<>();

    for (Node now : questions) {
      int size = queue.size();

      if (size < now.deadline) {// 데드라인이 작다면 무조건 삽입 가능
        queue.add(now.ramen);
      } else if (size == now.deadline) {// 같은 날짜라면, 큐에 담겨진 가장 작은 라면수와 현재 라면수랑 비교하기
        int peek = queue.peek();
        if (now.ramen > peek) {
          queue.poll();
          queue.add(now.ramen);
        }
      }
    }
    long cnt = 0;
    while (!queue.isEmpty()) {
      cnt += queue.poll();
    }

    return cnt;
  }

  private static class Node {

    int deadline;
    int ramen;

    public Node(int deadline, int ramen) {
      this.deadline = deadline;
      this.ramen = ramen;
    }
  }

}
