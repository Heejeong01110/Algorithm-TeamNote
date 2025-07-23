package com.example.baekjoon;

import org.junit.jupiter.api.Test;

class q12904Test extends AbstractTest {

  @Test
  void testSample() throws Exception {
    defaultClassName = "q12904";

    testCorrect("B\n"
        + "ABBA", "1");
    testCorrect("AB\n"
        + "ABB", "0");
  }


}
