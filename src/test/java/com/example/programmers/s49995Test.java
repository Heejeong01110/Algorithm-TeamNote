package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class s49995Test {

  @Test
  void solution() {
    assertEquals(3, s49995.solution(new int[]{1, 1, 2, 3}));
    assertEquals(500, s49995.solution(new int[]{1, 250, 1, 250, 500, 500}));
    assertEquals(0, s49995.solution(new int[]{1, 2, 4, 5}));

  }
}
