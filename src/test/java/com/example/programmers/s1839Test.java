package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class s1839Test {

  @Test
  void solution() {
    assertArrayEquals(new int[]{8, 15}, s1839.solution(4, 6, 25,
        new int[][]{
            {0, 1, 1, -1, 2, 4},
            {-1, 7, 2, 1, 5, 7},
            {-1, 1, -1, 1, 6, 3},
            {-1, 1, -1, -1, 7, 0}}));
    assertArrayEquals(new int[]{12, 11}, s1839.solution(5, 5, 12,
        new int[][]{
            {0, 1, 1, 1, 1},
            {9, 9, 9, 1, 9},
            {1, 1, 1, 1, 9},
            {1, 1, 5, 9, 9},
            {1, 1, 1, 1, 0}}));
    assertArrayEquals(new int[]{4, 103},
        s1839.solution(3, 3, 150, new int[][]{
            {0, 2, 99},
            {100, 100, 4},
            {1, 2, 0}}));
  }
}
