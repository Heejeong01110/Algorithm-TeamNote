package com.example.baekjoon;

import org.junit.jupiter.api.Test;

class q3089Test extends AbstractTest {

  @Test
  void testSample() throws Exception {
    defaultClassName = "q3089";

    testCorrect("4 4\n"
        + "1 1\n"
        + "1 0\n"
        + "0 1\n"
        + "0 0\n"
        + "RULD", "0 0");
    testCorrect("7 5\n"
        + "0 0\n"
        + "0 1\n"
        + "0 -1\n"
        + "1 0\n"
        + "1 -1\n"
        + "3 0\n"
        + "3 -1\n"
        + "DRRUD", "3 -1");
    testCorrect("10 6\n"
        + "0 0\n"
        + "1 1\n"
        + "2 1\n"
        + "0 2\n"
        + "-1 2\n"
        + "-1 3\n"
        + "2 3\n"
        + "2 4\n"
        + "4 3\n"
        + "2 -1\n"
        + "ULURDL", "1 1");
  }

}
