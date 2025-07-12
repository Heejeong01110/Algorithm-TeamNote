package com.example.baekjoon;

import org.junit.jupiter.api.Test;

class q1074Test extends AbstractTest {

  @Test
  void testSample() throws Exception {
    defaultClassName = "q1074";

    testCorrect("2 3 1", "11");
    testCorrect("3 7 7", "63");
    testCorrect("1 0 0", "0");
    testCorrect("4 7 7", "63");
    testCorrect("10 511 511", "262143");
    testCorrect("10 512 512", "786432");
  }


}
