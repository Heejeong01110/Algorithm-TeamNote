package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class s42894Test {

  @Test
  void solution() {
    assertEquals(2, s42894.solution(
        new int[][]{
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 4, 0, 0, 0},
            {0, 0, 0, 0, 0, 4, 4, 0, 0, 0},
            {0, 0, 0, 0, 3, 0, 4, 0, 0, 0},
            {0, 0, 0, 2, 3, 0, 0, 0, 5, 5},
            {1, 2, 2, 2, 3, 3, 0, 0, 0, 5},
            {1, 1, 1, 0, 0, 0, 0, 0, 0, 5}}));

  }
}
