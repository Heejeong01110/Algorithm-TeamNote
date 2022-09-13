package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class s12938Test {

  @Test
  void solution() {
    assertArrayEquals(new int[]{4, 5}, s12938.solution(2, 9));
    assertArrayEquals(new int[]{-1}, s12938.solution(2, 1));
    assertArrayEquals(new int[]{4, 4}, s12938.solution(2, 8));
    assertArrayEquals(new int[]{33, 33, 34}, s12938.solution(3, 100));

  }
}
