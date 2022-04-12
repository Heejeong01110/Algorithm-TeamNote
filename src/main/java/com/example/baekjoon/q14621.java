package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class q14621 {

  private static int N;
  private static int M;
  private static boolean[] vertex;
  private static HashMap<Integer, ArrayList<CustomVextor>> nodes;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    output(Solution());
  }

  private static void output(int result) {
    System.out.print(result);
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    vertex = new boolean[N + 1];
    nodes = new HashMap<>();
    for (int i = 1; i <= N; i++) {
      nodes.put(i, new ArrayList<>());
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      vertex[i] = st.nextToken().equals("M");
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int one = Integer.parseInt(st.nextToken());
      int two = Integer.parseInt(st.nextToken());
      int len = Integer.parseInt(st.nextToken());

      nodes.get(one).add(new CustomVextor(two, len));
      nodes.get(two).add(new CustomVextor(one, len));
    }

    br.close();
  }

  private static int Solution() {
    return prim();
  }


  private static int prim() {
    boolean[] visited = new boolean[N + 1];
    int sum = 0;
    int cnt = 0;

    PriorityQueue<CustomVextor> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
    queue.add(new CustomVextor(1, 0));

    while (!queue.isEmpty()) {
      CustomVextor now = queue.poll();

      if (visited[now.index]) {
        continue;
      }

      sum += now.cost;
      visited[now.index] = true;
      cnt++;

      if (cnt == N) { // 모든 노드를 방문했다면 return
        return sum;
      }

      for (int i = 0; i < nodes.get(now.index).size(); i++) {
        // 연결된 노드들 중 방문하지 않은 노드 찾기
        CustomVextor next = nodes.get(now.index).get(i);
        if (visited[next.index] || vertex[now.index] == vertex[next.index]) {
          continue;
        }

        queue.add(next);
      }
    }

    return -1;
  }


  static class CustomVextor {

    int index; //이어진 index
    int cost; //요금

    public CustomVextor(int index, int cost) {
      this.index = index;
      this.cost = cost;
    }
  }
}
