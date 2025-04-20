package com.example.programmers.exam;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class s250420_1Test {

  @Test
  void solution() {
    assertEquals(11, s250420_1.solution(new int[][]{{6, 2}, {4, 2}}));
    assertEquals(10, s250420_1.solution(new int[][]{{10, 1}, {1, 1}, {3, 2}}));
  }
}
