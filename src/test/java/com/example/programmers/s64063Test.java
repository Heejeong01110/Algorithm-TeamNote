package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class s64063Test {

  @Test
  void solution() {
    assertArrayEquals(new long[]{1, 3, 4, 2, 5, 6}, s64063.solution(10, new long[]{1, 3, 4, 1, 3, 1}));

  }
}
