package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class q1374 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Node[] arr = new Node[n];
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      st.nextToken();
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      arr[i] = new Node(start, end);
    }
    Arrays.sort(arr, (o1, o2) -> o1.start - o2.start);
    PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> {
      if (o1.end == o2.end) {
        return o1.start - o2.start;
      }
      return o1.end - o2.end;
    });

    queue.add(arr[0]);
    for (int i = 1; i < n; i++) {
      Node now = queue.peek();
      if (now.end <= arr[i].start) {
        queue.poll();
        now.end = arr[i].end;
        queue.add(now);
      } else {
        queue.add(arr[i]);
      }
    }

    System.out.println(queue.size());
  }


  private static class Node {

    int start;
    int end;

    public Node(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }
}
