package com.example.algorithm.sortAndSearch.sort;

import java.util.Arrays;

public class IntegerListSort {
  public static void main(String[] args) {
    int[] array = {4,6,2,345,8,76,243,6,43,44,4,7};
    Arrays.sort(array);

    for (int j : array) {
      System.out.println(j);
    }
  }
}
