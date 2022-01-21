package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class s86053Test {

  @Test
  void solution() {
    assertEquals(499,
        s86053.solution(90, 500, new int[]{70, 70, 0}, new int[]{0, 0, 500}, new int[]{100, 100, 2},
            new int[]{4, 8, 1}));
    assertEquals(50,
        s86053.solution(10, 10, new int[]{100}, new int[]{10}, new int[]{7}, new int[]{10}));
  }
}
