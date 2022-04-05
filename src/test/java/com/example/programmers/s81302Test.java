package com.example.programmers;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class s81302Test {

  @Test
  void solution() {
    assertArrayEquals(new int[]{1, 0, 1, 1, 1},s81302.solution(new String[][]{
            {"POOOP",
            "OXXOX",
            "OPXPX",
            "OOXOX",
            "POXXP"},

            {"POOPX",
            "OXPXP",
            "PXXXO",
            "OXXXO",
            "OOOPP"},

            {"PXOPX",
            "OXOXP",
            "OXPOX",
            "OXXOP",
            "PXPOX"},

            {"OOOXX",
            "XOOOX",
            "OOOXX",
            "OXOOX",
            "OOOOO"},

            {"PXPXP",
            "XPXPX",
            "PXPXP",
            "XPXPX",
            "PXPXP"}
        }));

  }
}
