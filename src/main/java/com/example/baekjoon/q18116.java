package com.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;

public class q18116 {

  private static int N;
  private static String[] inputs;
  private static HashMap<Integer, Integer> robotCounts;

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
    HashMap<Integer, ArrayList<Integer>> partsList = new HashMap<>();
    robotCounts = new HashMap<>();
    Integer one;
    Integer two;
    for (int i = 0; i < N; i++) {
      String[] input = inputs[i].split(" ");
      if (input[0].equals("I")) {
        one = Integer.parseInt(input[1]);
        two = Integer.parseInt(input[2]);

        ArrayList<Integer> list = partsList.getOrDefault(one, new ArrayList<>());
        list.add(two);
        partsList.put(one, list);

        ArrayList<Integer> list2 = partsList.getOrDefault(two, new ArrayList<>());
        list2.add(one);
        partsList.put(two, list2);
      } else {
        one = Integer.parseInt(input[1]);
        sb.append(bfs(partsList, one)).append("\n");
      }
    }
    return sb;
  }

  private static Integer bfs(HashMap<Integer, ArrayList<Integer>> partsList, Integer start) {
    if (!partsList.containsKey(start)) {
      return 1;
    }

    if (robotCounts.containsKey(start)) {
      return robotCounts.get(start);
    }

    Integer count = 0;
    Queue<Integer> queue = new ArrayDeque<>();
    ArrayList<Integer> visited = new ArrayList<>();
    queue.add(start);

    while (!queue.isEmpty()) {
      Integer now = queue.poll();
      visited.add(now);
      count++;

      for (int i = 0; i < partsList.get(now).size(); i++) {
        if (!visited.contains(partsList.get(now).get(i))) {
          queue.add(partsList.get(now).get(i));
        }
      }

    }

    for (int i = 0; i < visited.size(); i++) {
      robotCounts.put(visited.get(i), count);
    }

    return count;
  }

}
