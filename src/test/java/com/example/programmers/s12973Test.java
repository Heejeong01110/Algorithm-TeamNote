package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class s12973Test {

  @Test
  void solution() {
    assertEquals(0, s12973.solution("a"));
    assertEquals(1, s12973.solution("baabaa"));
    assertEquals(1, s12973.solution("aabaab"));
    assertEquals(0, s12973.solution("cdcd"));

  }
}
