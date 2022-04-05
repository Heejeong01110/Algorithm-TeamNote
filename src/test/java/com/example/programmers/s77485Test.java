package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class s77485Test {

  @Test
  void solution() {
    assertArrayEquals(new int[]{8, 10, 25},
        s77485.solution(6, 6, new int[][]{{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}}));
    assertArrayEquals(new int[]{1, 1, 5, 3},
        s77485.solution(3, 3, new int[][]{{1, 1, 2, 2}, {1, 2, 2, 3}, {2, 1, 3, 2}, {2, 2, 3, 3}}));
    assertArrayEquals(new int[]{1}, s77485.solution(100, 97, new int[][]{{1, 1, 100, 97}}));

  }
}
