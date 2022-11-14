package com.example.algorithm.sortAndSearch.sort;

import java.util.Arrays;
import java.util.Collections;

public class IntegerListSort {

  public static void main(String[] args) {
    int[] array = {4, 6, 2, 345, 8, 76, 243, 6, 43, 44, 4, 7};
    Arrays.sort(array);

    for (int j : array) {
      System.out.println(j);
    }

    //primitive 로는 변형이 안됨
    int[] reverseAry =
        Arrays.stream(array).boxed().sorted(Collections.reverseOrder())
            .mapToInt(Integer::intValue).toArray();

    int[][] map = {{1, 2}, {1, 4}, {5, 1}, {6, 4}, {3, 2}, {7, 10}, {10, 10}};

    Arrays.sort(map, (o1, o2) -> {
      if (o1[0] == o2[0]) {
        return o1[1] - o2[1]; //오름차순
      }
      return o1[0] - o2[0];//오름차순
    });
  }
}
