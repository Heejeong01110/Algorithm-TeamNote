package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class s131703Test {

  @Test
  void solution() {

    assertEquals(5,
        s131703.solution(new int[][]{{0, 1, 0, 0, 0},{1, 0, 1, 0, 1},{0, 1, 1, 1, 0},{1, 0, 1, 1, 0},{0, 1, 0, 1, 0}},
            new int[][]{{0, 0, 0, 1, 1},{0, 0, 0, 0, 1},{0, 0, 1, 0, 1},{0, 0, 0, 1, 0},{0, 0, 0, 0, 1}}));
    assertEquals(-1,
        s131703.solution(new int[][]{{0, 0, 0},{0, 0, 0},{0, 0, 0}},
            new int[][]{{1, 0, 1},{0, 0, 0},{0, 0, 0}}));
  }
}
