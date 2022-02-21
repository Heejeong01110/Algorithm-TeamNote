package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class s42586Test {

  @Test
  void solution() {
    assertArrayEquals(new int[]{1, 3, 2},
        s42586.solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1}));
    assertArrayEquals(new int[]{2, 1}, s42586.solution(new int[]{93, 30, 55}, new int[]{1, 30, 5}));

  }
}
