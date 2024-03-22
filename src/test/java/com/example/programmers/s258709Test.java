package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class s258709Test {

  @Test
  void solution() {
    assertArrayEquals(new int[]{1, 4}, s258709.solution(
        new int[][]{{1, 2, 3, 4, 5, 6}, {3, 3, 3, 3, 4, 4}, {1, 3, 3, 4, 4, 4}, {1, 1, 4, 4, 5, 5}}
    ));
    assertArrayEquals(new int[]{2}, s258709.solution(
        new int[][]{{1, 2, 3, 4, 5, 6}, {2, 2, 4, 4, 6, 6}}
    ));
    assertArrayEquals(new int[]{1, 3}, s258709.solution(
        new int[][]{{40, 41, 42, 43, 44, 45},{43, 43, 42, 42, 41, 41},{1, 1, 80, 80, 80, 80},{70, 70, 1, 1, 70, 70}}
    ));
  }
}
