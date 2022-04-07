package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class s87391Test {

  @Test
  void solution() {
    assertEquals(4,
        s87391.solution(2, 2, 0, 0,
            new int[][]{{2, 1}, {0, 1}, {1, 1}, {0, 1}, {2, 1}}));
    assertEquals(2,
        s87391.solution(2, 5, 0, 1,
            new int[][]{{3, 1}, {2, 2}, {1, 1}, {2, 3}, {0, 1}, {2, 1}}));
  }
}
