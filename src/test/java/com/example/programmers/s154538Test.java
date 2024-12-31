package com.example.programmers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class s154538Test {

  @Test
  void solution() {
    assertEquals(2, s154538.solution(10,40,5));
    assertEquals(1, s154538.solution(10,40,30));
    assertEquals(-1, s154538.solution(2,5,4));
  }
}
