package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class s142085Test {

  @Test
  void solution() {
    s142085 question = new s142085();
    assertEquals(5, question.solution(7, 3, new int[]{4, 2, 4, 5, 3, 3, 1}));
    assertEquals(4, question.solution(2, 4, new int[]{3, 3, 3, 3}));
  }

}
