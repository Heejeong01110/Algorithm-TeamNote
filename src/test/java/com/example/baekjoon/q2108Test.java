package com.example.baekjoon;

import org.junit.jupiter.api.Test;

class q2108Test extends AbstractTest {

  @Test
  void testSample() throws Exception {
    defaultClassName = "q2108";

    testCorrect("3\n"
        + "0\n"
        + "-1\n"
        + "8\n", "2\n"
        + "0\n"
        + "0\n"
        + "9\n");
    testCorrect("5\n"
        + "1\n"
        + "3\n"
        + "8\n"
        + "-2\n"
        + "2\n", "2\n"
        + "2\n"
        + "1\n"
        + "10\n");
    testCorrect("1\n"
        + "4000\n", "4000\n"
        + "4000\n"
        + "4000\n"
        + "0\n");
    testCorrect("5\n"
        + "-1\n"
        + "-2\n"
        + "-3\n"
        + "-1\n"
        + "-2\n", "-2\n"
        + "-2\n"
        + "-1\n"
        + "2\n");
    testCorrect("3\n"
        + "0\n"
        + "0\n"
        + "-1\n", "0\n"
        + "0\n"
        + "0\n"
        + "1\n");
  }

}
