package com.example.programmers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class s12899Test {

  @Test
  void solution() {
    assertEquals("1", s12899.solution(1));
    assertEquals("2", s12899.solution(2));
    assertEquals("4", s12899.solution(3));
    assertEquals("11", s12899.solution(4));
    assertEquals("44", s12899.solution(12));
    assertEquals("444", s12899.solution(39));
    assertEquals("11111", s12899.solution(121));
    assertEquals("4444", s12899.solution(120));
  }
}
