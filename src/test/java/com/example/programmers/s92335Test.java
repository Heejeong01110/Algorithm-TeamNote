package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class s92335Test {

  @Test
  void solution() {
    s92335 question = new s92335();
    assertEquals(3, question.solution(437674, 3));
    assertEquals(2, question.solution(110011, 10));
  }
}
