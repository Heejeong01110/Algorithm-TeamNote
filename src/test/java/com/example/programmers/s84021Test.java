package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class s84021Test {

  @Test
  void solution() {
    assertEquals(14, s84021.solution(
        new int[][]{
            {1, 1, 0, 0, 1, 0},
            {0, 0, 1, 0, 1, 0},
            {0, 1, 1, 0, 0, 1},
            {1, 1, 0, 1, 1, 1},
            {1, 0, 0, 0, 1, 0},
            {0, 1, 1, 1, 0, 0}},
        new int[][]{{1, 0, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 0}, {0, 1, 1, 0, 1, 1}, {0, 0, 1, 0, 0, 0},
            {1, 1, 0, 1, 1, 0}, {0, 1, 0, 0, 0, 0}}));

    assertEquals(0, s84021.solution(
        new int[][]{{0, 0, 0}, {1, 1, 0}, {1, 1, 1}},
        new int[][]{{1, 1, 1}, {1, 0, 0}, {0, 0, 0}}));
  }
}
