package com.example.baekjoon;

import org.junit.jupiter.api.Test;

class q1461Test extends AbstractTest {

  @Test
  void testSample() throws Exception {
    testCorrect("7 2\n"
        + "-37 2 -6 -39 -29 11 -28", "131");
    testCorrect("8 3\n"
        + "-18 -9 -4 50 22 -26 40 -45", "158");
    testCorrect("6 2\n"
        + "3 4 5 6 11 -1", "29");
    testCorrect("1 50\n"
        + "1", "1");
  }


}
