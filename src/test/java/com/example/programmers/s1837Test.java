package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class s1837Test {

  @Test
  void solution() {

    assertEquals(1, s1837.solution(7, 10,
        new int[][]{{1, 2}, {1, 3}, {2, 3}, {2, 4}, {3, 4}, {3, 5}, {4, 6}, {5, 6}, {5, 7}, {6, 7}},
        6, new int[]{1, 2, 3, 3, 6, 7}));
    assertEquals(0, s1837.solution(7, 10,
        new int[][]{{1, 2}, {1, 3}, {2, 3}, {2, 4}, {3, 4}, {3, 5}, {4, 6}, {5, 6}, {5, 7}, {6, 7}},
        6, new int[]{1, 2, 4, 6, 5, 7}));

  }
}
