package com.example.programmers.exam;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ss2Test {

  @Test
  void solution() {
    assertEquals(27, ss2.solution(new int[][]{{1, 2}, {2, 3}, {2, 6}, {3, 4}, {4, 5}}, 1, 2));
    assertEquals(37, ss2.solution(new int[][]{{1, 2}, {2, 3}, {2, 6}, {3, 4}, {4, 5}}, 2, 3));
  }
}
