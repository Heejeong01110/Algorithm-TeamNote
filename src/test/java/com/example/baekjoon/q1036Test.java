package com.example.baekjoon;

import org.junit.jupiter.api.Test;

class q1036Test extends AbstractTest {

  @Test
  void testSample() throws Exception {
    defaultClassName = "q1036";

    testCorrect("5\n"
        + "500\n"
        + "POINTS\n"
        + "FOR\n"
        + "THIS\n"
        + "PROBLEM\n"
        + "5\n", "1100TC85");
    testCorrect("5\n"
        + "GOOD\n"
        + "LUCK\n"
        + "AND\n"
        + "HAVE\n"
        + "FUN\n"
        + "7\n", "31YUB");

    testCorrect("1\n"
        + "KEQUALS36\n"
        + "36\n", "ZZZZZZZZZ");
    testCorrect("1\n"
        + "HELLO\n"
        + "2\n", "ZZLLO");
    testCorrect("6\n"
        + "TO\n"
        + "BE\n"
        + "OR\n"
        + "NOT\n"
        + "TO\n"
        + "BE\n"
        + "0\n", "QNO");
  }
}
