package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class s118670Test {

  @Test
  void solution() {
//    assertArrayEquals(
//        new int[][]{{8, 9, 6}, {4, 1, 2}, {7, 5, 3}}, s118670.solution(
//            new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},
//            new String[]{"Rotate", "ShiftRow"}
//        ));
//    assertArrayEquals(
//        new int[][]{{8, 3, 3}, {4, 9, 7}, {3, 8, 6}}, s118670.solution(
//            new int[][]{{8, 6, 3}, {3, 3, 7}, {8, 4, 9}},
//            new String[]{"Rotate", "ShiftRow", "ShiftRow"}
//        ));
    assertArrayEquals(
        new int[][]{{1, 6, 7, 8}, {5, 9, 10, 4}, {2, 3, 12, 11}}, s118670.solution(
            new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}},
            new String[]{"ShiftRow", "Rotate", "ShiftRow", "Rotate"}
        ));
  }

}
