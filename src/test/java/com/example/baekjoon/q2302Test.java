package com.example.baekjoon;

import org.junit.jupiter.api.Test;

class q2302Test extends AbstractTest {

  @Test
  void testSample() throws Exception {
    defaultClassName = "q2302";

    testCorrect("9\n"
        + "2\n"
        + "4\n"
        + "7\n", "12");

    testCorrect("1\n"
        + "0\n", "1");
    testCorrect("1\n"
        + "1\n"
        + "1\n", "1");
  }

}
