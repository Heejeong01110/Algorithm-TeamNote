package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q11085 {

  public static int[] group;
  private static int p;
  private static int w;
  private static int c;
  private static int v;
  private static Load[] loads;

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
    p = Integer.parseInt(st.nextToken());
    w = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    c = Integer.parseInt(st.nextToken());
    v = Integer.parseInt(st.nextToken());

    loads = new Load[w];
    for (int i = 0; i < w; i++) {
      st = new StringTokenizer(br.readLine());
      int one = Integer.parseInt(st.nextToken());
      int two = Integer.parseInt(st.nextToken());
      int width = Integer.parseInt(st.nextToken());
      loads[i] = new Load(one, two, width);
    }

    br.close();
  }

  private static int Solution() {

    Arrays.sort(loads, (o1, o2) -> o2.width - o1.width);
    group = new int[p];

    for (int i = 0; i < p; i++) {
      group[i] = i;
    }

    for (int i = 0; i < w; i++) {
      union(loads[i].one, loads[i].two);

      if (isSameParent(c, v)) {
        return loads[i].width;
      }
    }
    return -1;
  }

  private static int find(int x) {
    if (x == group[x]) {
      return x;
    }

    group[x] = find(group[x]);
    return group[x];
  }

  private static void union(int x, int y) {
    x = find(x);
    y = find(y); // 같은 부모를 가지고 있지 않을 때
    if (x != y) { // y가 x 보다 크다는 것을 가정한다면 아래와 같이 표현
      group[y] = x;
    }
  }

  // 같은 부모 노드를 가지는지 확인
  private static boolean isSameParent(int x, int y) {
    x = find(x);
    y = find(y);
    if (x == y) {
      return true;
    } else {
      return false;
    }
  }

  private static class Load {

    int one;
    int two;
    int width;

    public Load(int one, int two, int width) {
      this.one = one;
      this.two = two;
      this.width = width;
    }
  }

}
