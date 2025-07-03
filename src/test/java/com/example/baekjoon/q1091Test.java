package com.example.baekjoon;

import org.junit.jupiter.api.Test;

class q1091Test extends AbstractTest {

  @Test
  void testSample() throws Exception {
    defaultClassName = "q1091";

//    testCorrect("3\n"
//        + "2 0 1\n"
//        + "1 2 0\n", "2");
    testCorrect("6\n"
        + "0 1 2 0 1 2\n"
        + "1 4 0 3 2 5\n", "0");
    testCorrect("3\n"
        + "1 0 2\n"
        + "0 2 1\n", "-1");
    testCorrect("12\n"
        + "1 1 2 0 2 0 1 0 2 2 1 0\n"
        + "5 0 9 7 1 8 3 10 4 11 6 2\n", "59");
  }


}
