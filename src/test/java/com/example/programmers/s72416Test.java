package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class s72416Test {

  @Test
  void solution() {
    assertEquals(44, s72416.solution(
        new int[]{14, 17, 15, 18, 19, 14, 13, 16, 28, 17},
        new int[][]{{10, 8}, {1, 9}, {9, 7}, {5, 4}, {1, 5}, {5, 10}, {10, 6}, {1, 3}, {10, 2}}));
    assertEquals(6, s72416.solution(
        new int[]{5, 6, 5, 3, 4},
        new int[][]{{2, 3}, {1, 4}, {2, 5}, {1, 2}}));
    assertEquals(5, s72416.solution(
        new int[]{5, 6, 5, 1, 4},
        new int[][]{{2, 3}, {1, 4}, {2, 5}, {1, 2}}));
    assertEquals(2, s72416.solution(
        new int[]{10, 10, 1, 1},
        new int[][]{{3, 2}, {4, 3}, {1, 4}}));

  }
}
