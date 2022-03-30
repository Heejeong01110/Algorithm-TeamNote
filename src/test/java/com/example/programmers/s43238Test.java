package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class s43238Test {

  @Test
  void solution() {
    assertEquals(28, s43238.solution(6, new int[]{7, 10}));
    assertEquals(10, s43238.solution(2, new int[]{7, 10}));
    assertEquals(7, s43238.solution(1, new int[]{7, 10}));
  }
}
