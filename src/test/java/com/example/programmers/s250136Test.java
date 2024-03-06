package com.example.programmers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class s250136Test {

  @Test
  void solution() {
    assertEquals(9, s250136.solution(new int[][]{{0, 0, 0, 1, 1, 1, 0, 0},{0, 0, 0, 0, 1, 1, 0, 0},{1, 1, 0, 0, 0, 1, 1, 0},{1, 1, 1, 0, 0, 0, 0, 0},{1, 1, 1, 0, 0, 0, 1, 1}}));
    assertEquals(16, s250136.solution(new int[][]{{1, 0, 1, 0, 1, 1},{1, 0, 1, 0, 0, 0},{1, 0, 1, 0, 0, 1},{1, 0, 0, 1, 0, 0},{1, 0, 0, 1, 0, 1},{1, 0, 0, 0, 0, 0},{1, 1, 1, 1, 1, 1}}));
  }
}
