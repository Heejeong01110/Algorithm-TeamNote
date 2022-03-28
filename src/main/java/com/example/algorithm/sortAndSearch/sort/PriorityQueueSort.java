package com.example.algorithm.sortAndSearch.sort;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueSort {



  public static void main(String[] args) {
    PriorityQueue<CustomVextor> minCostQueue = new PriorityQueue<>(
        Comparator.comparingInt(o -> o.cost));

    PriorityQueue<CustomVextor> priorityQueue = new PriorityQueue<>((o1, o2) -> {
      if (o1.cost == o2.cost) { //오름차순
        return o1.index - o2.index;
      }
      return o1.cost - o2.cost;
    });
  }

  static class CustomVextor {

    int index;
    int cost; //요금

    public CustomVextor(int index, int cost) {
      this.index = index;
      this.cost = cost;
    }
  }

}
