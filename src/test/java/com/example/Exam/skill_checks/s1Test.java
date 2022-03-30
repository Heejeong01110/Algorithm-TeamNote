package com.example.Exam.skill_checks;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class s1Test {

  @Test
  void solution() {
    assertEquals(28, s1.solution(6, new int[]{7, 10}));
    assertEquals(10, s1.solution(2, new int[]{7, 10}));
    assertEquals(7, s1.solution(1, new int[]{7, 10}));
  }
}
