package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class s12904Test {

  @Test
  void solution() {
    assertEquals(7, s12904.solution("abcdcba"));
    assertEquals(3, s12904.solution("abacde"));
  }
}
