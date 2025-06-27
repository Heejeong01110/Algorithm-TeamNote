package com.example.baekjoon;

import org.junit.jupiter.api.Test;

class q17135Test extends AbstractTest {

  @Test
  void testSample() throws Exception {
    defaultClassName = "q17135";

    testCorrect("5 5 3\n"
        + "1 1 1 0 1\n"
        + "0 1 1 0 0\n"
        + "1 1 1 0 0\n"
        + "0 1 1 0 0\n"
        + "1 1 1 0 0\n", "13");
    testCorrect("5 5 1\n"
        + "0 0 0 0 0\n"
        + "0 0 0 0 0\n"
        + "0 0 0 0 0\n"
        + "0 0 0 0 0\n"
        + "1 1 1 1 1\n", "3");
    testCorrect("5 5 1\n"
        + "0 0 0 0 0\n"
        + "0 0 0 0 0\n"
        + "0 0 0 0 0\n"
        + "1 1 1 1 1\n"
        + "0 0 0 0 0\n", "3");
    testCorrect("5 5 2\n"
        + "0 0 0 0 0\n"
        + "0 0 0 0 0\n"
        + "0 0 0 0 0\n"
        + "1 1 1 1 1\n"
        + "0 0 0 0 0\n", "5");
    testCorrect("5 5 5\n"
        + "1 1 1 1 1\n"
        + "1 1 1 1 1\n"
        + "1 1 1 1 1\n"
        + "1 1 1 1 1\n"
        + "1 1 1 1 1\n", "15");
    testCorrect("6 5 1\n"
        + "1 0 1 0 1\n"
        + "0 1 0 1 0\n"
        + "1 1 0 0 0\n"
        + "0 0 0 1 1\n"
        + "1 1 0 1 1\n"
        + "0 0 1 0 0\n", "9");
    testCorrect("6 5 2\n"
        + "1 0 1 0 1\n"
        + "0 1 0 1 0\n"
        + "1 1 0 0 0\n"
        + "0 0 0 1 1\n"
        + "1 1 0 1 1\n"
        + "0 0 1 0 0\n", "14");
  }

}
