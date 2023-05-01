package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class s131130Test {

  @Test
  void solution() {
    s131130 question = new s131130();
    assertEquals(12, question.solution(new int[]{8, 6, 3, 7, 2, 5, 1, 4}));
  }
}
