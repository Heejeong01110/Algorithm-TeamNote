package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class s258705Test {

  @Test
  void solution() {
    assertEquals(149, s258705.solution(4, new int[]{1, 1, 0, 1}));
    assertEquals(11, s258705.solution(2, new int[]{0, 1}));
    assertEquals(7704, s258705.solution(10, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
  }
}
