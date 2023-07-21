package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class s169198Test {

  @Test
  void solution() {

    s169198 q = new s169198();
    assertArrayEquals(new int[]{52, 37, 116}, q.solution(10, 10, 3, 7,
        new int[][]{{7, 7}, {2, 7}, {7, 3}}));
  }
}
