package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class s62050Test {
  @Test
  void solution() {
    assertEquals(15, s62050.solution(
        new int[][]{{1, 4, 8, 10},{5, 5, 5, 5},{10, 10, 10, 10},{10, 10, 10, 20}}, 3));
    assertEquals(18, s62050.solution(
        new int[][]{{10, 11, 10, 11},{2, 21, 20, 10},{1, 20, 21, 11},{2, 1, 2, 1}}, 1));
  }
}
