package com.example.baekjoon;

import org.junit.jupiter.api.Test;

class q2573Test extends AbstractTest {

  @Test
  void testSample() throws Exception {
    defaultClassName = "q2573";

    testCorrect("5 7\n"
        + "0 0 0 0 0 0 0\n"
        + "0 2 4 5 3 0 0\n"
        + "0 3 0 2 5 2 0\n"
        + "0 7 6 2 4 0 0\n"
        + "0 0 0 0 0 0 0", "2");
  }

}
