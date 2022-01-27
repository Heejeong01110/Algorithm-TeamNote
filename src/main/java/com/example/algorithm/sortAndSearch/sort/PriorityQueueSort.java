package com.example.algorithm.sortAndSearch.sort;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueSort {

  public static void main(String[] args) {
    PriorityQueue<CustomVextor> minCostQueue = new PriorityQueue<>(
        Comparator.comparingInt(o -> o.cost));
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
