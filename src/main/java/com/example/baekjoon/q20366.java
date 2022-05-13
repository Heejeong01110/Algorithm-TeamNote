package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class q20366 {

  private static int N;
  private static int result;
  private static int[] ary;

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

    N = Integer.parseInt(br.readLine());

    ary = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < N; i++) {
      ary[i] = Integer.parseInt(st.nextToken());
    }

    br.close();
  }

  private static int Solution() {
    int answer = 0;

    Arrays.sort(ary);
    ArrayList<Node> nodes = new ArrayList<>();
    for (int i = 0; i < ary.length; i++) {
      for (int j = i + 1; j < ary.length; j++) {
        nodes.add(new Node(i, j, ary[i] + ary[j]));
      }
    }

    nodes.sort(Comparator.comparingInt(o -> o.size));
    int value = Integer.MAX_VALUE; //최소

    for (int i = 0; i < nodes.size() - 1; i++) {
      Node one = nodes.get(i);
      Node two = nodes.get(i + 1);

      if (one.one == two.one || one.one == two.two || one.two == two.one || one.two == two.two) {
        continue;
      }

      value = Math.min(value, Math.abs(one.size - two.size));
    }

    answer = value;
    return answer;
  }

  private static class Node {

    int one;
    int two;
    int size;

    public Node(int one, int two, int size) {
      this.one = one;
      this.two = two;
      this.size = size;
    }
  }


}
