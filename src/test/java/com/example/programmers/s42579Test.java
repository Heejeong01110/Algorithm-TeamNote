package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class s42579Test {

  @Test
  void solution() {
    assertArrayEquals(new int[]{4,1,3,0}, s42579.solution(
        new String[]{"classic", "pop", "classic", "classic", "pop"},
        new int[]{500, 600, 150, 800, 2500}));

  }
}
