package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class s148653Test {

  @Test
  void solution() {
    s148653 question = new s148653();
    assertEquals(6, question.solution(16));
    assertEquals(16, question.solution(2554));
  }
}
