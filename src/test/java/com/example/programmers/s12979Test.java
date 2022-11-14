package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class s12979Test {

  @Test
  void solution() {
    assertEquals(3, s12979.solution(16, new int[]{9}, 2));
    assertEquals(2, s12979.solution(11, new int[]{4, 6, 11}, 1));
    assertEquals(3, s12979.solution(11, new int[]{4, 11}, 1));
  }
}
