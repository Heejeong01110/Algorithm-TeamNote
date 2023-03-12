package com.example.programmers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class s118667Test {

  @Test
  void solution() {
    s118667 question = new s118667();
    assertEquals(2, question.solution(new int[]{3, 2, 7, 2},new int[]{4, 6, 5, 1}));
    assertEquals(7, question.solution(new int[]{1, 2, 1, 2},new int[]{1, 10, 1, 2}));
    assertEquals(-1, question.solution(new int[]{1, 1},new int[]{1, 5}));
  }
}
