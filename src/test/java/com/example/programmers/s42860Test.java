package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class s42860Test {

  @Test
  void solution() {
    assertEquals(15, s42860.solution("ABBAAABAAAABB"));
    assertEquals(8, s42860.solution("BBBAAAAAB"));
    assertEquals(56, s42860.solution("JEROEN"));
    assertEquals(23, s42860.solution("JAN"));
  }
}
