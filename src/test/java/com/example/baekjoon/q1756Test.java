package com.example.baekjoon;

import org.junit.jupiter.api.Test;

class q1756Test extends AbstractTest {

  @Test
  void testSample() throws Exception {
    defaultClassName = "q1756";

    testCorrect("7 3\n"
        + "5 6 4 3 6 2 3\n"
        + "3 2 5\n", "2");
    testCorrect("7 3\n"
        + "5 6 4 3 6 2 3\n"
        + "4 4 4\n", "1");
  }


}
