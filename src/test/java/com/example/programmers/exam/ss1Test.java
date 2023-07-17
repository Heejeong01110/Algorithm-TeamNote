package com.example.programmers.exam;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ss1Test {

  @Test
  void solution() {
    assertEquals(21, ss1.solution("1451232125", 2));
    assertEquals(312, ss1.solution("313253123", 3));
    assertEquals(-1, ss1.solution("12412415", 4));
  }
}
