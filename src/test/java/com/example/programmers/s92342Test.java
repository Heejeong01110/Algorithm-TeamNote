package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;


class s92342Test {

  @Test
  void solution() {
    assertArrayEquals(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 2},
        s92342.solution(10, new int[]{
            0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3}));
    assertArrayEquals(new int[]{0, 2, 2, 0, 1, 0, 0, 0, 0, 0, 0},
        s92342.solution(5, new int[]{
            2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0}));
    assertArrayEquals(new int[]{-1},
        s92342.solution(1, new int[]{
            1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
    assertArrayEquals(new int[]{1, 1, 2, 0, 1, 2, 2, 0, 0, 0, 0},
        s92342.solution(9, new int[]{
            0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1}));

  }

}
