package com.example.baekjoon;

import org.junit.jupiter.api.Test;

class q15486Test extends AbstractTest {

  @Test
  void testSample() throws Exception {
    defaultClassName = "q15486";

    testCorrect("7\n"
        + "3 10\n"
        + "5 20\n"
        + "1 10\n"
        + "1 20\n"
        + "2 15\n"
        + "4 40\n"
        + "2 200\n", "45");
    testCorrect("10\n"
        + "1 1\n"
        + "1 2\n"
        + "1 3\n"
        + "1 4\n"
        + "1 5\n"
        + "1 6\n"
        + "1 7\n"
        + "1 8\n"
        + "1 9\n"
        + "1 10\n", "55");
    testCorrect("10\n"
        + "5 10\n"
        + "5 9\n"
        + "5 8\n"
        + "5 7\n"
        + "5 6\n"
        + "5 10\n"
        + "5 9\n"
        + "5 8\n"
        + "5 7\n"
        + "5 6\n", "20");
    testCorrect("10\n"
        + "5 50\n"
        + "4 40\n"
        + "3 30\n"
        + "2 20\n"
        + "1 10\n"
        + "1 10\n"
        + "2 20\n"
        + "3 30\n"
        + "4 40\n"
        + "5 50\n", "90");
  }

}
