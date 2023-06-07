package com.example.programmers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class s154540Test {

  @Test
  void solution() {
    s154540 q = new s154540();
    assertArrayEquals(new int[]{1, 1, 27}, q.solution(new String[]{"X591X","X1X5X","X231X", "1XXX1"}));
    assertArrayEquals(new int[]{-1}, q.solution(new String[]{"XXX","XXX","XXX"}));
  }
}
