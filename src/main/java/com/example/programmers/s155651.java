package com.example.programmers;

import java.util.ArrayList;
import java.util.List;

public class s155651 {

  public int solution(String[][] book_time) {
    List<Node> nodes = new ArrayList<>();
    for (String[] times : book_time) {
      nodes.add(new Node(toMinute(times[0]), toMinute(times[1])));
    }
    nodes.sort((o1, o2) -> o1.start == o2.start ? o1.end - o2.end : o1.start - o2.start);

    int[] times = new int[24 * 60 + 10];
    for (Node node : nodes) {
      for (int i = node.start; i < node.end + 10; i++) {
        times[i] += 1;
      }
    }

    int answer = 0;
    for (int i = 0; i < 24 * 60 + 10; i++) {
      answer = Math.max(answer, times[i]);
    }

    return answer;
  }

  private int toMinute(String time) {
    String[] split = time.split(":");
    int hour = Integer.parseInt(split[0]) * 60;
    int minute = Integer.parseInt(split[1]);

    return hour + minute;
  }

  private class Node {

    int start;
    int end;

    public Node(int start, int end) {
      this.start = start;
      this.end = end;
    }

  }

}
