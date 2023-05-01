package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class s134239Test {

  @Test
  void solution() {
    s134239 question = new s134239();
    assertArrayEquals(new double[]{33.0, 31.5, 0.0, -1.0},
        question.solution(5, new int[][]{{0, 0}, {0, -1}, {2, -3}, {3, -3}}));
  }
}
