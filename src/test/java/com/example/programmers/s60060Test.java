package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class s60060Test {

  @Test
  void solution() {
    assertArrayEquals(new int[]{3, 2, 4, 1, 0}, s60060.solution(
        new String[]{"frodo", "front", "frost", "frozen", "frame", "kakao"},
        new String[]{"fro??", "????o", "fr???", "fro???", "pro?"}));
  }
}
