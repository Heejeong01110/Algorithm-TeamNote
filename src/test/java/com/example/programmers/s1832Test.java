package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class s1832Test {

  @Test
  void solution() {

    assertEquals(2, s1832.solution(
        3, 6, new int[][]{{0, 2, 0, 0, 0, 2}, {0, 0, 2, 0, 1, 0}, {1, 0, 0, 2, 2, 0}}));
    assertEquals(6, s1832.solution(3, 3, new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}));
  }

}
