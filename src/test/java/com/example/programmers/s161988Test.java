package com.example.programmers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class s161988Test {

  @Test
  void solution() {
    s161988 question = new s161988();
    assertEquals(10, question.solution(new int[]{2, 3, -6, 1, 3, -1, 2, 4}));
  }
}
