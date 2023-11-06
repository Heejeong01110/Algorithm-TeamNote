package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class s12927Test {

  @Test
  void solution() {
    assertEquals(0, s12927.solution(3, new int[]{1, 1}));
    assertEquals(12, s12927.solution(4, new int[]{4, 3, 3}));
    assertEquals(6, s12927.solution(1, new int[]{2, 1, 2}));
  }

}
