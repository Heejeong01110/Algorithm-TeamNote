package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class s388352Test {

  @Test
  void solution() {

    assertEquals(3, s388352.solution(
        10,
        new int[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {3, 7, 8, 9, 10}, {2, 5, 7, 9, 10},
            {3, 4, 5, 6, 7}},
        new int[]{2, 3, 4, 3, 3}));
    assertEquals(5, s388352.solution(
        15,
        new int[][]{{2, 3, 9, 12, 13}, {1, 4, 6, 7, 9}, {1, 2, 8, 10, 12}, {6, 7, 11, 13, 15},
            {1, 4, 10, 11, 14}},
        new int[]{2, 1, 3, 0, 1}));
  }
}
