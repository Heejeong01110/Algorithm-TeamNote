package com.example.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class s42891 {

  private static int N;

  public static int solution(int[] food_times, long k) {
    LinkedList<Node> list = new LinkedList<>();
    int len = food_times.length;
    for(int i = 0; i < len; i++) {
      list.add(new Node(i + 1, food_times[i]));
    }
    Collections.sort(list, (o1, o2) -> o1.time - o2.time);

    int current_time = 0;
    int idx = 0;

    for(Node f : list) {
      long diff = f.time - current_time;
      if(diff != 0) {
        long spend = diff * len;
        if(spend <= k) {
          k -= spend;
          current_time = f.time;
        } else {
          k %= len;
          list.subList(idx, food_times.length).sort((o1, o2) -> o1.idx - o2.idx);
          return list.get(idx + (int)k).idx;
        }
      }
      idx++;
      len--;
    }
    return -1;
  }


  private static class Node {

    int idx;
    int time;

    public Node(int idx, int time) {
      this.idx = idx;
      this.time = time;
    }
  }
}
