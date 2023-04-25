package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class s87377Test {

  @Test
  void solution() {
    s87377 question = new s87377();
    assertArrayEquals(
        new String[]{
            "....*....",
            ".........",
            ".........",
            "*.......*",
            ".........",
            ".........",
            ".........",
            ".........",
            "*.......*"}, question.solution(
            new int[][]{{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}}));
    assertArrayEquals(
        new String[]{"*.*"}, question.solution(
            new int[][]{{0, 1, -1}, {1, 0, -1}, {1, 0, 1}}));
    assertArrayEquals(
        new String[]{"*"}, question.solution(
            new int[][]{{1, -1, 0}, {2, -1, 0}}));
    assertArrayEquals(
        new String[]{"*"}, question.solution(
            new int[][]{{1, -1, 0}, {2, -1, 0}, {4, -1, 0}}));
  }

}
