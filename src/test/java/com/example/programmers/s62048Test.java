package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class s62048Test {

  @Test
  public void 정답() {
    assertEquals(80, s62048.Solution(8, 12));
    assertEquals(80, s62048.Solution(12, 8));
    assertEquals(12, s62048.Solution(4, 4));
  }
}
