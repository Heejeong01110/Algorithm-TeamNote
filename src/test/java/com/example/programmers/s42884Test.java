package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class s42884Test {

  @Test
  void solution() {
    assertEquals(2, s42884.solution(new int[][]{{-20, 20}, {-14, -5}, {5, 25}, {-10, 10}}));
    assertEquals(2, s42884.solution(new int[][]{{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}}));
  }
}
