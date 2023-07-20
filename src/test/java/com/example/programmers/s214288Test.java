package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class s214288Test {

  @Test
  void solution() {

    s214288 q = new s214288();
    assertEquals(90, q.solution(2, 3,
        new int[][]{{5, 55, 2}, {10, 90, 2}, {20, 40, 2}, {50, 45, 2}, {100, 50, 2}}));
    assertEquals(25, q.solution(3, 5,
        new int[][]{{10, 60, 1}, {15, 100, 3}, {20, 30, 1}, {30, 50, 3}, {50, 40, 1}, {60, 30, 2},
            {65, 30, 1}, {70, 100, 2}}));
  }
}
