package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class s60063Test {

  @Test
  void solution() {
    assertEquals(7, s60063.solution(
        new int[][]{{0, 0, 0, 1, 1}, {0, 0, 0, 1, 0}, {0, 1, 0, 1, 1}, {1, 1, 0, 0, 1},
            {0, 0, 0, 0, 0}}));
  }
}
