package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.Objects;
import java.util.StringTokenizer;

public class q3190 {

  private static int N;
  private static int K;
  private static int[][] map;
  private static int[][] directs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    output(Solution());
  }

  private static void output(int result) {
    System.out.print(result);
  }

  private static int Solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());

    K = Integer.parseInt(br.readLine());
    map = new int[N][N];

    for (int i = 0; i < K; i++) {
      st = new StringTokenizer(br.readLine());
      map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = 1;
    }

    int L = Integer.parseInt(br.readLine());

    Deque<Node> deque = new ArrayDeque<>();
    ArrayList<Info> infos = new ArrayList<>();

    for (int i = 0; i < L; i++) {
      st = new StringTokenizer(br.readLine());
      int X = Integer.parseInt(st.nextToken());
      String C = st.nextToken();
      infos.add(new Info(X, C));
    }

    infos.sort(Comparator.comparingInt(o -> o.count));
    int idx = 0;
    boolean[][] visited = new boolean[N][N];

    deque.add(new Node(0, 0, 1));

    while (!deque.isEmpty()) {
      Node now = deque.peekLast();

      Node next = new Node(now.row, now.col, now.direct);
      if (!infos.isEmpty() && infos.get(0).count == idx) {
        int dir = getDirect(now.direct, infos.get(0).direct);
        next.row += directs[dir][0];
        next.col += directs[dir][1];
        next.direct = dir;
        infos.remove(0);
      } else {
        next.row += directs[now.direct][0];
        next.col += directs[now.direct][1];
      }

      idx++;
      if (!isPossible(next.row, next.col) || deque.contains(next)) {
        //벽에 부딫침
        //자기 자신의 몸에 부딫히는 경우
        break;
      }

      if (map[next.row][next.col] == 1 && !visited[next.row][next.col]) {
        //안먹은 사과일 경우
        visited[next.row][next.col] = true;
        deque.addLast(next);
      } else {
        deque.addLast(next);
        deque.pollFirst();
      }

    }

    br.close();
    return idx;
  }

  private static boolean isPossible(int row, int col) {
    return row >= 0 && row < N && col >= 0 && col < N;
  }

  private static int getDirect(int direct, String dirString) {
    int dirInt = dirString.equals("L") ? 1 : -1;
    if (direct + dirInt >= 4) {
      return 0;
    } else if (direct + dirInt < 0) {
      return 3;
    }
    return direct + dirInt;
  }

  private static class Node {

    int row;
    int col;
    int direct;

    public Node(int row, int col, int direct) {
      this.row = row;
      this.col = col;
      this.direct = direct;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      Node node = (Node) o;
      return row == node.row && col == node.col;
    }

    @Override
    public int hashCode() {
      return Objects.hash(row, col);
    }
  }

  private static class Info {

    int count;
    String direct;

    public Info(int count, String direct) {
      this.count = count;
      this.direct = direct;
    }
  }
}
