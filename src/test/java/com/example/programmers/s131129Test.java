package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class s131129Test {

  @Test
  void solution() {
    assertArrayEquals(new int[]{3, 3}, s131129.solution(106));
    assertArrayEquals(new int[]{3, 2}, s131129.solution(154));
    assertArrayEquals(new int[]{2, 2}, s131129.solution(29));
    assertArrayEquals(new int[]{2, 2}, s131129.solution(58));
    assertArrayEquals(new int[]{1, 0}, s131129.solution(21));
  }
}
