package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class q9576 {

  private static int T;
  private static int N;
  private static int M;
  private static Node[] nodes;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    T = Integer.parseInt(br.readLine());
    StringTokenizer st;
    for (int t = 0; t < T; t++) {

      st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());

      nodes = new Node[M];
      for (int i = 0; i < M; i++) {
        st = new StringTokenizer(br.readLine());
        int one = Integer.parseInt(st.nextToken());
        int two = Integer.parseInt(st.nextToken());
        nodes[i] = new Node(one, two);
      }

      boolean[] visited = new boolean[N + 1];
      int count = 0;

      PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> {
        if (o1.end == o2.end) {
          return o1.start - o2.start;
        }
        return o1.end - o2.end;
      });
      queue.addAll(Arrays.asList(nodes));

      while (!queue.isEmpty()) {
        Node now = queue.poll();

        for (int i = now.start; i <= now.end; i++) {
          if (!visited[i]) {
            visited[i] = true;
            count++;
            break;
          }
        }
      }

      sb.append(count).append("\n");
    }

    System.out.print(sb);
    br.close();
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
