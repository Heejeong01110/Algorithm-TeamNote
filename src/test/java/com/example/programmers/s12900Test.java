package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class s12900Test {

  @Test
  void solution() {
    assertEquals(1, s12900.solution(1));
    assertEquals(2, s12900.solution(2));
    assertEquals(3, s12900.solution(3));
    assertEquals(5, s12900.solution(4));
    assertEquals(8, s12900.solution(5));
    assertEquals(13, s12900.solution(6));
  }
}
