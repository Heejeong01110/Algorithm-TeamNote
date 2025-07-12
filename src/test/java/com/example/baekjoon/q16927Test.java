package com.example.baekjoon;

import org.junit.jupiter.api.Test;

class q16927Test extends AbstractTest {

  @Test
  void testSample() throws Exception {
    defaultClassName = "q16927";

    testCorrect("4 4 2\n"
        + "1 2 3 4\n"
        + "5 6 7 8\n"
        + "9 10 11 12\n"
        + "13 14 15 16\n", "3 4 8 12 \n"
        + "2 11 10 16 \n"
        + "1 7 6 15 \n"
        + "5 9 13 14 \n");
    testCorrect("5 4 7\n"
        + "1 2 3 4\n"
        + "7 8 9 10\n"
        + "13 14 15 16\n"
        + "19 20 21 22\n"
        + "25 26 27 28\n", "28 27 26 25 \n"
        + "22 9 15 19 \n"
        + "16 8 21 13 \n"
        + "10 14 20 7 \n"
        + "4 3 2 1 \n");
    testCorrect("2 2 3\n"
        + "1 1\n"
        + "1 1\n", "1 1 \n"
        + "1 1 \n");
  }
}
