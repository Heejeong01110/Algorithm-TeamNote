package com.example.baekjoon;

import org.junit.jupiter.api.Test;

class q17070Test extends AbstractTest {

  @Test
  void testSample() throws Exception {
    defaultClassName = "q17070";

    testCorrect("3\n"
        + "0 0 0\n"
        + "0 0 0\n"
        + "0 0 0\n", "1");
    testCorrect("4\n"
        + "0 0 0 0\n"
        + "0 0 0 0\n"
        + "0 0 0 0\n"
        + "0 0 0 0\n", "3");
    testCorrect("5\n"
        + "0 0 1 0 0\n"
        + "0 0 0 0 0\n"
        + "0 0 0 0 0\n"
        + "0 0 0 0 0\n"
        + "0 0 0 0 0\n", "0");
    testCorrect("6\n"
        + "0 0 0 0 0 0\n"
        + "0 1 0 0 0 0\n"
        + "0 0 0 0 0 0\n"
        + "0 0 0 0 0 0\n"
        + "0 0 0 0 0 0\n"
        + "0 0 0 0 0 0\n", "13");
  }


}
