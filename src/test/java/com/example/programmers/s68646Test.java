package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class s68646Test {

  @Test
  void solution() {
    assertEquals(3, s68646.solution(new int[]{9, -1, -5}));
    assertEquals(6, s68646.solution(new int[]{-16, 27, 65, -2, 58, -92, -71, -68, -61, -33}));

  }
}
