package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class s152996Test {

  @Test
  void solution() {
    s152996 question = new s152996();
    assertEquals(4, question.solution(new int[]{100, 180, 360, 100, 270}));
  }
}
