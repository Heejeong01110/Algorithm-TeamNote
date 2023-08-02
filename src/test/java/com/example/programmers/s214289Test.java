package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class s214289Test {

  @Test
  void solution() {
    assertEquals(40, s214289.solution(28, 18, 26, 10, 8, new int[]{0, 0, 1, 1, 1, 1, 1}));
    assertEquals(25, s214289.solution(-10, -5, 5, 5, 1, new int[]{0, 0, 0, 0, 0, 1, 0}));
    assertEquals(20,s214289.solution(11, 8, 10, 10, 1, new int[]{0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1}));
    assertEquals(60,s214289.solution(11, 8, 10, 10, 100, new int[]{0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1}));


  }
}
