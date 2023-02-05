package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class s150365Test {

  @Test
  void solution() {
    assertEquals("dllrl", s150365.solution(3, 4, 2, 3, 3, 1, 5));
    assertEquals("dr", s150365.solution(2, 2, 1, 1, 2, 2, 2));
    assertEquals("impossible", s150365.solution(3, 3, 1, 2, 3, 3, 4));
  }


}
