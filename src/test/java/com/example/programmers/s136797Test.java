package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class s136797Test {

  @Test
  void solution() {
    s136797 question = new s136797();
    assertEquals(10, question.solution("1756"));
    assertEquals(8, question.solution("5123"));
  }
}
