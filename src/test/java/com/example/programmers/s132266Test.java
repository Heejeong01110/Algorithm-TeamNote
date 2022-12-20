package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class s132266Test {

  @Test
  void solution() {

    assertArrayEquals(new int[]{1, 2},
        s132266.solution(3, new int[][]{{1, 2}, {2, 3}}, new int[]{2, 3}, 1));
    assertArrayEquals(new int[]{2, -1, 0},
        s132266.solution(5, new int[][]{{1, 2}, {1, 4}, {2, 4}, {2, 5}, {4, 5}}, new int[]{1, 3, 5},
            5));
  }
}
