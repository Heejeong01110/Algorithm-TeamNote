package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class q14950 {

  private static int N;
  private static int M;
  private static int T;
  private static int count;
  private static HashMap<Integer, ArrayList<CustomVextor>> nodes;

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
    T = Integer.parseInt(st.nextToken());

    nodes = new HashMap<>();
    for (int i = 1; i <= N; i++) {
      nodes.put(i, new ArrayList<>());
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());

      int one = Integer.parseInt(st.nextToken());
      int two = Integer.parseInt(st.nextToken());
      int value = Integer.parseInt(st.nextToken());
      nodes.get(one).add(new CustomVextor(two, value));
      nodes.get(two).add(new CustomVextor(one, value));
    }

    br.close();
  }

  private static long Solution() {

    long prim = prim();

    long plus = 0;

    for (int i = 0; i < count - 1; i++) {
      plus += (long) i * T;
    }
    return prim + plus;
  }


  private static long prim() {

    boolean[] visited = new boolean[nodes.size() + 1];
    PriorityQueue<CustomVextor> queue = new PriorityQueue<>(
        Comparator.comparingInt(o -> o.cost));

    // 1번 노드부터 출발
    queue.add(new CustomVextor(1, 0));

    long result = 0;
    int cnt = 0;
    while (!queue.isEmpty()) {

      CustomVextor now = queue.poll();

      // 이미 확인한 정점이면 pass
      if (visited[now.index]) {
        continue;
      }

      result += now.cost;
      count++;
      visited[now.index] = true;
      // 모든 노드를 방문했다면 return
      if (++cnt == nodes.size()) {
        return result;
      }

      for (int i = 0; i < nodes.get(now.index).size(); i++) {
        // 연결된 노드들 중 방문하지 않은 노드 찾기
        CustomVextor next = nodes.get(now.index).get(i);
        if (visited[next.index]) {
          continue;
        }

        queue.add(next);
      }
    }

    return result;
  }

  private static class CustomVextor {

    int index; //이어진 index
    int cost; //요금

    public CustomVextor(int index, int cost) {
      this.index = index;
      this.cost = cost;
    }
  }

}
