package com.example.programmers.exam;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class s111111Test {

  @Test
  void solution() {
    assertEquals(2, s111111.solution(new int[]{1, 5, 8}, new int[]{1, 4}));
    assertEquals(2, s111111.solution(new int[]{1, 5, 8}, new int[]{1, 3, 4, 6}));
    assertEquals(4, s111111.solution(new int[]{1, 3, 4, 6, 7, 10}, new int[]{2, 2, 2, 2}));
  }

}
