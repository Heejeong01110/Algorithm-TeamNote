package com.example.baekjoon;

import org.junit.jupiter.api.Test;

class q31863Test extends AbstractTest {

  @Test
  void testSample() throws Exception {
    defaultClassName = "q31863";

    testCorrect("5 6\n"
        + "*.*...\n"
        + "..||..\n"
        + "..@*|*\n"
        + ".*.*..\n"
        + "..*##.\n", "4 5");
    testCorrect("7 9\n"
        + "...#...#.\n"
        + ".*.*..*..\n"
        + "...*..#..\n"
        + "...**.*..\n"
        + ".*..*.@..\n"
        + ".#...**..\n"
        + "..#.#..*.\n", "10 8");
  }


}
