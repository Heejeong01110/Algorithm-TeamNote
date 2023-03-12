package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class s12971Test {

  @Test
  void solution() {
    s12971 question = new s12971();
    assertEquals(34, question.solution(new int[]{14, 6, 5, 11, 3, 9, 2}));
    assertEquals(36, question.solution(new int[]{14, 6, 5, 11, 3, 9, 2, 10}));
    assertEquals(8, question.solution(new int[]{1, 3, 2, 5, 4}));
  }

}
