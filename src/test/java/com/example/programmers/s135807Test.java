package com.example.programmers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class s135807Test {

  @Test
  void solution() {
    s135807 question = new s135807();
    assertEquals(0, question.solution(new int[]{10, 17},new int[]{5, 20}));
    assertEquals(10, question.solution(new int[]{10, 20},new int[]{5, 17}));
    assertEquals(7, question.solution(new int[]{14, 35, 119},new int[]{18, 30, 102}));
  }
}
