package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class s60062Test {

  @Test
  void solution() {
    assertEquals(2, s60062.solution(12, new int[]{1, 5, 6, 10}, new int[]{1, 2, 3, 4}));
    assertEquals(1, s60062.solution(12, new int[]{1, 3, 4, 9, 10}, new int[]{3, 5, 7}));
  }
}
