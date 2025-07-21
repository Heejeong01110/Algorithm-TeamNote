package com.example.baekjoon;

import org.junit.jupiter.api.Test;

class q18111Test extends AbstractTest {

  @Test
  void testSample() throws Exception {
    defaultClassName = "q18111";

    testCorrect("3 4 99\n"
        + "0 0 0 0\n"
        + "0 0 0 0\n"
        + "0 0 0 1\n", "2 0");
    testCorrect("3 4 1\n"
        + "64 64 64 64\n"
        + "64 64 64 64\n"
        + "64 64 64 63\n", "1 64");
    testCorrect("1 2 13\n"
        + "0 256\n", "378 134");
  }


}
