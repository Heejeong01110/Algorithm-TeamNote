package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class s87694Test {

  @Test
  void solution() {
    assertEquals(10,
        s87694.solution(new int[][]{{2, 2, 5, 5}, {1, 3, 6, 4}, {3, 1, 4, 6}}, 1, 4, 6, 3));
    assertEquals(17,
        s87694.solution(new int[][]{{1, 1, 7, 4}, {3, 2, 5, 5}, {4, 3, 6, 9}, {2, 6, 8, 8}}, 1, 3,
            7, 8));
    assertEquals(11,
        s87694.solution(new int[][]{{1, 1, 8, 4}, {2, 2, 4, 9}, {3, 6, 9, 8}, {6, 3, 7, 7}}, 9, 7,
            6, 1));
    assertEquals(9, s87694.solution(new int[][]{{1, 1, 5, 7}}, 1, 1, 4, 7));
    assertEquals(15, s87694.solution(new int[][]{{2, 1, 7, 5}, {6, 4, 10, 10}}, 3, 1, 7, 10));

  }
}
