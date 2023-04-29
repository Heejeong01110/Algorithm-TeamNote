package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class s154539Test {

  @Test
  void solution() {
    s154539 question = new s154539();
    assertArrayEquals(new int[]{3, 5, 5, -1}, question.solution(new int[]{2, 3, 3, 5}));
    assertArrayEquals(new int[]{-1, 5, 6, 6, -1, -1},
        question.solution(new int[]{9, 1, 5, 3, 6, 2}));
  }
}
