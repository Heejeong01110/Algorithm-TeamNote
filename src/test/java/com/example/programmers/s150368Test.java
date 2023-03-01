package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class s150368Test {

  @Test
  void solution() {
    assertArrayEquals(new int[]{1, 5400}, s150368.solution(
        new int[][]{
            {40, 10000},
            {25, 10000}},
        new int[]{7000, 9000}));
    assertArrayEquals(new int[]{4, 13860}, s150368.solution(
        new int[][]{
            {40, 2900},{23, 10000},{11, 5200},{5, 5900},{40, 3100},{27, 9200},{32, 6900}},
        new int[]{1300, 1500, 1600, 4900}));
  }
}
