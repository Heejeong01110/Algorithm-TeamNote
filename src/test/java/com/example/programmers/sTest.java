package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class sTest {

  @Test
  void solution() {
    assertEquals(1, s12899.solution(1));
    assertEquals(2, s12899.solution(2));
    assertEquals(4, s12899.solution(3));
    assertEquals(11, s12899.solution(4));

    assertEquals(true, s60059.solution(
        new int[][]{{0, 0, 0},{1, 0, 0},{0, 1, 1}},
        new int[][]{{1, 1, 1},{1, 1, 0},{1, 0, 1}}
    ));
  }
}
