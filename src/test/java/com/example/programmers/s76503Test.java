package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class s76503Test {

  @Test
  void solution() {
    assertEquals(9,
        s76503.solution(new int[]{-5, 0, 2, 1, 2}, new int[][]{{0, 1}, {3, 4}, {2, 3}, {0, 3}}));
    assertEquals(-1, s76503.solution(new int[]{0, 1, 0}, new int[][]{{0, 1}, {1, 2}}));
    assertEquals(17, s76503.solution(new int[]{-2, 8, -5, -5, -3, 0, 5, 2},
        new int[][]{{0, 1}, {0, 2}, {1, 3}, {1, 4}, {1, 5}, {2, 6}, {2, 7}}));
  }
}
