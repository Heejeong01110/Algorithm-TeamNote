package com.example.baekjoon;

import org.junit.jupiter.api.Test;

class q1103Test extends AbstractTest {

  @Test
  void testSample() throws Exception {
    defaultClassName = "q1103";

    testCorrect("4 4\n"
        + "3994\n"
        + "9999\n"
        + "9999\n"
        + "2924\n", "-1");
    testCorrect("6 7\n"
        + "12HHHHH\n"
        + "2214HHH\n"
        + "H1HHHHH\n"
        + "H4H9H2H\n"
        + "HHHHHHH\n"
        + "HHH2HHH\n", "7");
    testCorrect("4 4\n"
        + "3HH2\n"
        + "H1HH\n"
        + "H2H1\n"
        + "2219\n", "8");

    testCorrect("3 7\n"
        + "3942178\n"
        + "1234567\n"
        + "9123432\n", "6");
    testCorrect("3 7\n"
        + "3942178\n"
        + "1234567\n"
        + "9123532\n", "5");
    testCorrect("1 10\n"
        + "2H3HH4HHH5\n", "4");
    testCorrect("4 6\n"
        + "123456\n"
        + "234567\n"
        + "345678\n"
        + "456789\n", "4");
    testCorrect("1 1\n"
        + "9\n", "1");
    testCorrect("3 7\n"
        + "2H9HH11\n"
        + "HHHHH11\n"
        + "9HHHH11\n", "2");
  }
}
