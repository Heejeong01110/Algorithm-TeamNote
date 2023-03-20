package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class s150367Test {

  @Test
  void solution() {
    s150367 question = new s150367();
    assertArrayEquals(new int[]{1,0}, question.solution(new long[]{1,423}));
    assertArrayEquals(new int[]{1, 1, 0}, question.solution(new long[]{7, 42, 5}));
    assertArrayEquals(new int[]{1, 1, 0}, question.solution(new long[]{63, 111, 95}));
  }
}
