package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class s60061Test {

  @Test
  void solution() {
    assertArrayEquals(
        new int[][]{{1, 0, 0}, {1, 1, 1}, {2, 1, 0}, {2, 2, 1}, {3, 2, 1}, {4, 2, 1}, {5, 0, 0},
            {5, 1, 0}},
        s60061.solution(5,
            new int[][]{{1, 0, 0, 1}, {1, 1, 1, 1}, {2, 1, 0, 1}, {2, 2, 1, 1}, {5, 0, 0, 1},
                {5, 1, 0, 1}, {4, 2, 1, 1}, {3, 2, 1, 1}}));

    assertArrayEquals(
        new int[][]{{0, 0, 0}, {0, 1, 1}, {1, 1, 1}, {2, 1, 1}, {3, 1, 1}, {4, 0, 0}},
        s60061.solution(5,
            new int[][]{{0, 0, 0, 1}, {2, 0, 0, 1}, {4, 0, 0, 1}, {0, 1, 1, 1}, {1, 1, 1, 1},
                {2, 1, 1, 1}, {3, 1, 1, 1}, {2, 0, 0, 0}, {1, 1, 1, 0}, {2, 2, 0, 1}}));
  }
}
