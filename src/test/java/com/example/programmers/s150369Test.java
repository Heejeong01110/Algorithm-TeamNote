package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class s150369Test {

  @Test
  void solution() {
    assertEquals(16, s150369.solution(4, 5,
        new int[]{1, 0, 3, 1, 2},   //배달
        new int[]{0, 3, 0, 4, 0})); //수거
    assertEquals(30, s150369.solution(2, 7,
        new int[]{1, 0, 2, 0, 1, 0, 2},   //배달
        new int[]{0, 2, 0, 1, 0, 2, 0})); //수거
  }
}
