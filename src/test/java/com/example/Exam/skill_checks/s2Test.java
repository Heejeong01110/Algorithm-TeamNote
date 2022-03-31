package com.example.Exam.skill_checks;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class s2Test {

  @Test
  void solution() {
    assertEquals(4, s2.solution(5, 12));
    assertEquals(3, s2.solution(2, 11));
  }
}
