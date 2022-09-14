package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class s70130Test {

  @Test
  void solution() {
    assertEquals(4, s70130.solution(new int[]{5, 2, 3, 3, 5, 3}));
    assertEquals(0, s70130.solution(new int[]{0}));
    assertEquals(8, s70130.solution(new int[]{0, 3, 3, 0, 7, 2, 0, 2, 2, 0}));

  }
}
