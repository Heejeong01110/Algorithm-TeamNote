package com.example.programmers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class s92345Test {

  @Test
  void solution() {
    assertEquals(5, s92345.solution(
        new int[][]{{1, 1, 1},{1, 1, 1},{1, 1, 1}},
        new int[]{1,0}, new int[]{1,2}));
  }
}
