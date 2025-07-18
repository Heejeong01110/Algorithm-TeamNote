package com.example.baekjoon;

import org.junit.jupiter.api.Test;

class q25196Test extends AbstractTest {

  @Test
  void testSample() throws Exception {
    defaultClassName = "q25196";

    testCorrect("3 1 2\n"
        + "4 1 2\n"
        + "5 3 4\n", "13");
    testCorrect("10 3 5\n"
        + "11 5 8\n"
        + "12 2 4\n", "63");
    testCorrect("8 1 2\n"
        + "8 3 4\n"
        + "8 5 6\n", "-1");
  }


}
