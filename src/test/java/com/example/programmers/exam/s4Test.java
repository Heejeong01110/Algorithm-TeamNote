package com.example.programmers.exam;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.programmers.exam.s4;
import org.junit.jupiter.api.Test;

class s4Test {

  @Test
  void solution() {
    assertEquals(5, s4.solution(
        new int[][]{{0, 1, 0, 0, 0}, {1, 0, 1, 0, 1}, {0, 1, 1, 1, 0}, {1, 0, 1, 1, 0},
            {0, 1, 0, 1, 0}},
        new int[][]{{0, 0, 0, 1, 1}, {0, 0, 0, 0, 1}, {0, 0, 1, 0, 1}, {0, 0, 0, 1, 0},
            {0, 0, 0, 0, 1}}));
    assertEquals(-1, s4.solution(new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}},
        new int[][]{{1, 0, 1}, {0, 0, 0}, {0, 0, 0}}));
  }
}
