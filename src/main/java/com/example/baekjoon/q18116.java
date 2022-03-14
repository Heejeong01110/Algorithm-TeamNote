package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class q18116 {

  private static int N;
  private static String[] inputs;
  private static HashMap<Integer, Integer> robotCounts;
  private static HashMap<Integer, Integer> parentsList;

  public static void main(String[] args) throws IOException {
    run();
  }

  public static void run() throws IOException {
    inputData();
    output(Solution());
  }

  private static void output(StringBuilder result) {
    System.out.print(result.toString());
  }

  private static void inputData() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    inputs = new String[N];

    for (int i = 0; i < N; i++) {
      inputs[i] = br.readLine();
    }

    br.close();
  }

  private static StringBuilder Solution() {
    StringBuilder sb = new StringBuilder();
    parentsList = new HashMap<>();
    robotCounts = new HashMap<>();
    Integer one;
    Integer two;
    for (int i = 0; i < N; i++) {
      String[] input = inputs[i].split(" ");
      if (input[0].equals("I")) {
        one = Integer.parseInt(input[1]);
        two = Integer.parseInt(input[2]);
        union(one, two);

      } else {
        one = Integer.parseInt(input[1]);
        sb.append(robotCounts.getOrDefault(findParent(one), 1)).append("\n");
      }
    }
    return sb;
  }

  private static void union(Integer one, Integer two) {
    one = findParent(one);
    two = findParent(two);

    if (one < two) {
      parentsList.put(two, one);
      Integer sum = robotCounts.getOrDefault(one, 1) + robotCounts.getOrDefault(two, 1);
      robotCounts.put(one, sum);
    } else {
      if (!one.equals(two)) {
        parentsList.put(one, two);
        Integer sum = robotCounts.getOrDefault(one, 1) + robotCounts.getOrDefault(two, 1);
        robotCounts.put(two, sum);
      }
    }

  }

  private static int findParent(int x) {
    if (x == parentsList.getOrDefault(x, x)) {
      return x;
    } else {
      int parent = findParent(parentsList.get(x));
      parentsList.put(x, parent);
      return parent;
    }
  }

}
