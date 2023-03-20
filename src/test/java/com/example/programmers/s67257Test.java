package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class s67257Test {

  @Test
  void solution() {
    s67257 question = new s67257();
    assertEquals(60420, question.solution("100-200*300-500+20"));
    assertEquals(300, question.solution("50*6-3*2"));
  }
}
