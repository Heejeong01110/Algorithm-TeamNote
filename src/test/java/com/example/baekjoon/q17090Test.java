package com.example.baekjoon;

import org.junit.jupiter.api.Test;

class q17090Test extends AbstractTest {

  @Test
  void testSample() throws Exception {
    defaultClassName = "q17090";

    testCorrect("3 3\n"
        + "DDD\n"
        + "DDD\n"
        + "DDD\n", "9");
    testCorrect("3 3\n"
        + "DDR\n"
        + "DLU\n"
        + "LLL\n", "9");
    testCorrect("3 3\n"
        + "RRD\n"
        + "RDD\n"
        + "ULL\n", "0");
    testCorrect("3 4\n"
        + "RRDD\n"
        + "RRDR\n"
        + "DULU\n", "4");
  }

}
